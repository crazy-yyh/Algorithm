package com.yan01.link_list;

import java.util.Iterator;

/**
 * @author yyh
 * @create 2020-10-16 17:58
 */
public class LinkList<T> implements Iterable<T>{

    public static void main(String[] args) {
        //创建顺序表对象
        LinkList<Integer> sl = new LinkList<>();
        //测试插入
        sl.insert(1);
        sl.insert(2);
        sl.insert(3);
        sl.insert(4);
        sl.insert(5);
        sl.insert(3,6);
        System.out.println(sl.remove(1));
        System.out.println("===================");
//        sl.reverse();

        for (int s : sl) {
            System.out.println(s);
        }



    }

    //记录头节点
    private Node head;

    //记录链表长度
    private int N;


    /**
     *  节点类
     */
    private class Node{
        //存储数据
        T item;

        //下一个节点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        //初始化头结点、
        this.head = new Node(null,null);
        //初始化元素个数
        this.N = 0;
    }

    /**
     * 获取链表的长度
     */
    public int length(){
        return N;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取指定位置i出的元素
     */
    public T get(int i){

        if(i <= 0 || i > length()){
            return null;
        }
        Node cursor = head.next;
        for(int index = 0; index < i -1 ; index++){
            cursor = cursor.next;
        }
        return cursor.item;
    }

    /**
     * 向链表中添加元素t，尾插法
     */
    public void insert(T t){

        //找到最后一个节点
        Node cursor = head;
        while(cursor.next != null){
            cursor = cursor.next;
        }
        //创建新结点，保存元素t
        Node node = new Node(t,null);
        //让当前最后一个结点指向新结点
        cursor.next = node;

        //元素的个数+1
        N++;
    }

    /**
     * 向指定位置i出，添加元素t
     */
    public void insert(int i, T t){
        if(i <= 0){
            head.next = new Node(t,head.next);
            return;
        }
        if(i > length()){
            insert(t);
            return;
        }

        //找到i位置前一个结点
        Node cursor = head;
        for(int index = 0; index < i-1;index++){
            cursor = cursor.next;
        }
        //找到i位置的结点
        Node curr = cursor.next;
        //创建新结点，并且新结点需要指向原来i位置的结点
        Node node = new Node(t,curr);
        //原来i位置的前一个节点指向新结点即可
        cursor.next = node;
        //元素的个数+1
        N++;
    }

    /**
     * 删除指定位置i处的元素，并返回被删除的元素
     */
    public T remove(int i){

        if(i <= 0 || i > length()){
            return null;
        }
        //找到i位置的前一个节点
        Node cursor = head;
        for (int j = 0; j < i -1; j++) {
            cursor = cursor.next;
        }
        //要找到i位置的结点
        Node curr = cursor.next;
        //前一个结点指向下一个结点
        cursor.next = cursor.next.next;
        //元素个数-1
        N--;
        return curr.item;
    }

    /**
     * 查找元素t在链表中第一次出现的位置
     */
    public int indexOf(T t){
        //从头结点开始，依次找到每一个结点，取出item，和t比较，如果相同，就找到了
        Node cursor = head;
        for (int i = 0; i < N; i++) {
            cursor = cursor.next;
            if(cursor.item.equals(t)){
                return i;
            }
        }
        return -1;

    }

    //用来反转整个链表
    public void reverse(){

        //判断当前链表是否为空链表，如果是空链表，则结束运行，如果不是，则调用重载的reverse方法完成反转
        if (isEmpty()){
            return;
        }

        reverse(head.next);
    }

    //反转指定的结点curr，并把反转后的结点返回
    public Node reverse(Node curr){
//        if (curr.next==null){
//            head.next=curr;
//            return curr;
//        }
//        //递归的反转当前结点curr的下一个结点；返回值就是链表反转后，当前结点的上一个结点
//        Node pre = reverse(curr.next);
//        //让返回的结点的下一个结点变为当前结点curr；
//        pre.next=curr;
//        //把当前结点的下一个结点变为null
//        curr.next=null;
//        return curr;
        if(curr.next ==null){
            head.next = curr;
            return curr;
        }

        Node pre = reverse(curr.next);

        pre.next = curr;

        curr.next = null;

        return curr;


    }



    public  boolean isCircle(Node head){
        Node fast = head;
        Node last = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            last = last.next;

            if(fast == last){
                return true;
            }
        }
        return false;
    }




    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator{

        private Node n;

        public MyIterator() {
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
