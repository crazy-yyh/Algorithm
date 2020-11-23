package com.yan01.priority;

/**
 * @author yyh
 * @create 2020-10-17 9:46
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

    public static void main(String[] args) {
        //创建优先队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);

        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        //通过循环从队列中获取最大的元素
        while(!queue.isEmpty()){
            String max = queue.delMax();
            System.out.print(max+" ");
        }

    }
    //存储堆中元素
    private T[] items;

    //记录堆中的元素个数
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public boolean less(int i, int j){
        return items[i].compareTo(items[j])<0;
    }

    public void exchange(int i, int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    public T delMax(){
        T max = items[1];
        exchange(1,N);
        N--;
        sink(1);
        return max;

    }

    public void swim(int k){
        while(k > 1){
            if(less(k/2,k)){
                exchange(k/2,k);
            }

            k = k /2;
        }
    }

    public void sink(int k){
        while(2*k <= N){
            int max;
            if(2*k+1 <= N){
                if(less(2*k,2*k+1)){
                    max = 2*k+1;
                }else{
                    max= 2*k;
                }
            }else{
                max = 2*k;
            }

            if(!less(k,max)){
                break;
            }

            exchange(k,max);

            k = max;
        }


    }



























}
