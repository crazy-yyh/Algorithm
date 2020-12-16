package com.yan01.link_list;

import java.util.Iterator;

public class CircularLinkList<T> implements Iterable<T> {


    public static void main(String[] args) {
        CircularLinkList<Integer> link = new CircularLinkList<>();

        link.insert(1);
        link.insert(2);
        link.insert(3);
        link.insert(4);
        link.insert(5);
        link.insert(6);
        link.travel();

    }

    private Node head;

    private int size;

    private Node first;

    private Node last;

    private class Node{
        T items;
        Node next;

        public Node(T items, Node next) {
            this.items = items;
            this.next = next;
        }
    }

    public CircularLinkList() {
        this.head = new Node(null,null);
        this.size = 0;
    }

    public void travel(){

        if(isEmpty()){
            return;
        }
        Node curr = head.next;

        while(curr.next != head.next){
            System.out.println(curr.items);
            curr = curr.next;
        }
        System.out.println(curr.items);
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int length(){
        return size;
    }

    public void insert(T t){
        Node node = new Node(t,null);
        if(isEmpty()){
            head.next = node;
            node.next = head.next;
            first = head.next;
            last = head.next;
            size++;
            return;
        }
        Node curr  = head.next;
        while(curr.next != head.next){
            curr = curr.next;
        }
        curr.next = node;
        node.next = head.next;
        last = node;
        size++;

    }

    public void insert(int i, T t){

        Node node = new Node(t,null);
        Node curr = head;
        for (int j = 0; j < i - 1; j++) {
            curr = curr.next;
        }

    }







    @Override
    public Iterator<T> iterator() {
        return new CIterator();
    }

    private class CIterator implements Iterator {

        private Node n;

        public CIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.items;
        }
    }
}
