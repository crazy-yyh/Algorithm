package com.yan01.link_list;

import java.util.Iterator;

/**
 * @author yyh
 * @create 2020-09-27 20:33
 */
public class SequenceList<T> implements Iterable<T>{

    public static void main(String[] args) {
        //创建顺序表对象
        SequenceList<String> sl = new SequenceList<>(10);
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");

        for (String s : sl) {
            System.out.println(s);
        }

        System.out.println("------------------------------------------");

        //测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        System.out.println("清空后的线性表中的元素个数为:"+sl.length());
    }

    /**
     * 存储元素的数组
     */
    private T[] eles;

    /**
     * 记录当前顺序表中的元素个数
     */
    private int N;

    /**
     * 构造方法
     */
    public SequenceList(int capacity) {
        //初始化数组
        this.eles =(T[]) new Object[capacity];

        //初始化长度
        this.N = 0;

    }

    /**
     * 判断当前线性表是否为空
     */
    public boolean isEmpty(){
        return N == 0;
    }

    /**
     * 获取线性表长度
     */
    public int length(){
        return N;
    }

    /**
     *  获取指定位置的元素
     */
    public T get(int i){
        return eles[i];
    }

    /**
     * 向线性表中添加元素T
     */
    public void insert(T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }

        eles[N++] = t;
    }


    /**
     * 在i元素处插入元素
     */
    public void insert(int i, T t){
        if(N == eles.length){
            resize(2 * eles.length);
        }

        //先把i索引处的元素以及后面的元素依次向后移动一位
        for(int index = N;index > i;index--){
            eles[index] = eles[index - 1];
        }
        //再把t元素放到i索引处即可
        eles[i] = t;
        //元素个数+1
        N++;
    }

    /**
     * 删除指定位置i处的元素，并返回该元素
     */
    public T remove(int i){
        //记录索引i处的值
        T current = eles[i];
        //索引i后面元素依次向前移动一位即可
        for(int index = i; index <N-1; index++){
            eles[index] = eles[index+1];
        }
        //元素个数-1
        N--;

        if(N < eles.length / 4){
            resize(eles.length/2);
        }

        return current;

    }

    /**
     * 查找t元素第一次出现的位置
     */
    public int indexOf(T t){
        for(int i = 0; i < N; i++){
            if(eles[i].equals(t)){
                return i;
            }
        }

        return -1;
    }

    /**
     * 根据参数newsize，重置eles的大小
     */
    public void resize(int newSize){
        //定义一个数组指向原数组
        T[] temp = eles;

        //创建新数组
        eles =(T[]) new Object[newSize];

        //把原数组的数据拷贝到新数组
        for(int i = 0; i < N;i++){
            eles[i] = temp[i];
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cousor;

        public SIterator() {
            this.cousor = 0;
        }

        @Override
        public boolean hasNext() {
            return cousor < N;
        }

        @Override
        public Object next() {
            return eles[cousor++];
        }
    }
}
