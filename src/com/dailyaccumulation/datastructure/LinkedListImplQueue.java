package com.dailyaccumulation.datastructure;

import javax.xml.soap.Node;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static com.thinkInJava.mylibraries.Print.print;

public class LinkedListImplQueue<Item> implements Iterable<Item> {
    private Node<Item> first;//队头节点
    private Node<Item> last;//队尾节点（注意和上面last的区分，last不是队尾元素的下标）
    private int N;

    //辅助类Node
    private static class Node<Item>{
        private Item item;
        private Node<Item> Next;
    }

    //初始化队列
    public LinkedListImplQueue(){
        first = null;
        last = null;
        N = 0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return first == null;
    }

    //队列中元素的个数
    public int size(){
        return N;
    }

    //元素入列
    public void enqueue(Item item){
        //记录尾节点
        Node<Item> oldlast = last;
        //创建新的节点
        last = new Node<Item>();
        last.item = item;
        last.Next = null;
        //如果队列是空的，将first置为last，因为这个时候队列中刚刚加进去一个新元素
        if (isEmpty()){
            first = last;
        }else {//如果队列非空，则正常在对尾执行插入新节点的操作
            oldlast.Next = last;
        }
        N++;
    }

    //弹出并返回元素
    public Item dequeue(){
        if (isEmpty()) throw new NoSuchElementException("LinkedListImplQueue underflow");
        Item item = first.item;
        first = first.Next;
        N--;
        //如果此时为空，则表示原来只有一个元素，这时候last也应该置为空
        if (isEmpty()){
            last = null;
        }
        return item;
    }

    //返回但不弹出
    public Item peek(){
        if (isEmpty()) throw new NoSuchElementException("LinkedListImplQueue underflow");
        return first.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this){
            s.append(s);
        }
        return s.toString();
    }

    //实现Iterable接口
    public Iterator<Item> iterator(){
        return new ListIterator<>(first);
    }

    //实现迭代器
    public class ListIterator<Item> implements Iterator<Item>{
        private LinkedListImplQueue.Node<Item> current;
        //要实现迭代只需要维护一个节点，并在开始时将它置为first
        public ListIterator(LinkedListImplQueue.Node first){
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (isEmpty()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.Next;
            return item;
        }
    }
    public static void main(String[] args){
        LinkedListImplQueue<String> sq = new LinkedListImplQueue<String>();
        List<String> sIn = Arrays.asList("zhang", "qiao", "fei");
        if (sq.isEmpty()){

            for (String s : sIn){
                sq.enqueue(s);
            }
        }
        Iterator iterator = sq.iterator();
        while (iterator.hasNext()){
            print(iterator.next());
        }
    }
}
