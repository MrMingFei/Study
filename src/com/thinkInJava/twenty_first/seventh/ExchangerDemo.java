package com.thinkInJava.twenty_first.seventh;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

import java.util.List;
import java.util.concurrent.*;

public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;

    public static void main(String[] args) throws Exception {
        if (args.length > 0){
            size = new Integer(args[0]);
        }
        if (args.length > 1){
            delay = new Integer(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> exchanger = new Exchanger<>();
        List<Fat>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<Fat>(exchanger, BasicGenerator.create(Fat.class), producerList));
        exec.execute(new ExchangerConsumer<Fat>(exchanger, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}

class ExchangerProducer<T> implements Runnable{
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    ExchangerProducer(Exchanger<List<T>> exchanger, Generator<T> generator, List<T> holder){
        this.exchanger = exchanger;
        this.generator = generator;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                for (int i = 0; i < ExchangerDemo.size; i++){
                    holder.add(generator.next());
                }
                holder = exchanger.exchange(holder);
            }
        }catch (InterruptedException e){

        }
    }
}

class ExchangerConsumer<T> implements Runnable{
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;
    ExchangerConsumer(Exchanger<List<T>> ex, List<T> holder){
        exchanger = ex;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                holder = exchanger.exchange(holder);
                for (T x : holder){
                    value = x;
                    holder.remove(x);
                }
            }
        }catch (InterruptedException e){

        }
    }
}
