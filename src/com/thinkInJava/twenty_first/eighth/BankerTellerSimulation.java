package com.thinkInJava.twenty_first.eighth;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankerTellerSimulation {

    static final int MAX_LINE_SIZE = 50;
    static final int ADJUSTMENG_PERIOD = 1000;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
        exec.execute(new CustomerGenerator(customers));
        exec.execute(new TellerManager(exec, customers, ADJUSTMENG_PERIOD));

        if (args.length > 0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

class Customer{
    private final int serviceTime;
    public Customer(int serviceTime){
        this.serviceTime = serviceTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

class CustomerLine extends ArrayBlockingQueue<Customer>{
    public CustomerLine(int maxLineSize){
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0){
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (Customer customer : this){
            result.append(customer);
        }
        return result.toString();
    }
}

class CustomerGenerator implements Runnable{
    private CustomerLine customers;
    private static Random random = new Random(47);
    public CustomerGenerator(CustomerLine  cq){
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                customers.put(new Customer(random.nextInt(1000)));
            }
        }catch (InterruptedException e){
            System.out.println("CustomerGenerator interrupted");
        }
        System.out.println("CustomerGenerator terminating");
    }
}

class Teller implements Runnable, Comparable<Teller>{
    private static int counter = 0;
    private final int id = counter++;

    private int customersServed = 0;
    private CustomerLine customers;
    private boolean servingCustomerLine = true;
    public Teller(CustomerLine cq){
        customers = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                Customer customer = customers.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
                synchronized (this){
                    customersServed++;
                    while (!servingCustomerLine){
                        wait();
                    }
                }
            }
        }catch (InterruptedException e){
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    public synchronized void doSomethingElse(){
        servingCustomerLine = false;
        customersServed = 0;
    }

    public synchronized void serveCustomerLine(){
        assert !servingCustomerLine:"already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller " + id + " ";
    }

    public String shortString(){
        return "T" + id;
    }

    @Override
    public int compareTo(Teller o) {
        return customersServed < o.customersServed ? -1 :
                (customersServed > o.customersServed ? 1 : 0);
    }
}

class TellerManager implements Runnable{
    private ExecutorService exec;
    private CustomerLine customers;
    private PriorityQueue<Teller> workingTellers = new PriorityQueue<>();
    private Queue<Teller> tellersDoingOtherThings = new LinkedList<>();
    private int adjustmentPeriod;
    private static Random random = new Random(47);
    public TellerManager(ExecutorService e, CustomerLine customers, int adjustmentPeriod){
        exec = e;
        this.customers = customers;
        this.adjustmentPeriod = adjustmentPeriod;
        Teller teller = new Teller(customers);
        exec.execute(teller);
        workingTellers.add(teller);
    }

    public void adjustTellerNumber(){
        if (customers.size() / workingTellers.size() > 2){
            if (tellersDoingOtherThings.size() > 0){
                Teller teller = tellersDoingOtherThings.remove();
                teller.serveCustomerLine();
                workingTellers.offer(teller);
                return;
            }
            Teller teller = new Teller(customers);
            exec.execute(teller);
            workingTellers.add(teller);
            return;
        }
        if (workingTellers.size() > 1 && customers.size() / workingTellers.size() < 2){
            reassignOneTeller();
        }
        if (customers.size() == 0){
            while (workingTellers.size() > 1){
                reassignOneTeller();
            }
        }
    }

    public void reassignOneTeller(){
        Teller teller = workingTellers.poll();
        teller.doSomethingElse();
        tellersDoingOtherThings.offer(teller);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustTellerNumber();
                System.out.print(customers + " { ");
                for (Teller teller : workingTellers){
                    System.out.print(teller.shortString() + " ");
                }
                System.out.println("}");
            }
        }catch (InterruptedException e){
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " terminating");
    }

    @Override
    public String toString() {
        return "TellerManager";
    }
}