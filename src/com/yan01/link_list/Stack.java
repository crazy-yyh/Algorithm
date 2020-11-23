package com.yan01.link_list;

import java.util.Iterator;

/**
 * @author yyh
 * @create 2020-10-16 20:56
 */
public class Stack<T> implements Iterable<T> {

    public static void main(String[] args) {
        //创建栈对象
        Stack<String> stack = new Stack<>();

        //测试压栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for (String item : stack) {
            System.out.println(item);
        }
        System.out.println("------------------------------");
        //测试弹栈
        String result = stack.pop();
        System.out.println("弹出的元素是："+result);
        System.out.println("剩余的元素个数："+stack.size());

    }

    //记录首结点
    private Node head;

    //记录队列中的元素个数
    private int N;


    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public Stack() {
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    /**
     * 向队列中插入元素t
     */
    public void push(T t){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;
        //创建新结点
        Node node = new Node(t,null);
        //让首结点指向新结点
        node.next = oldFirst;
        //让新结点指向原来的第一个结点
        head.next = node;
        //元素个数+1
        N++;
    }

    /**
     * 从队列中拿出一个元素
     */
    public T pop(){
        if(isEmpty()){
            return null;
        }

        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;

        return oldFirst.item;

    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node n;

        public SIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;

            return n.item;
        }
    }
}
