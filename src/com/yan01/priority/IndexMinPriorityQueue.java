package com.yan01.priority;

/**
 * delete问题待解决
 * @author yyh
 * @create 2020-10-17 13:51
 */
public class IndexMinPriorityQueue<T extends Comparable<T>>{

    public static void main(String[] args) {
        //创建索引最小优先队列对象
        IndexMinPriorityQueue<String> queue = new IndexMinPriorityQueue<>(10);

        //往队列中添加元素
        queue.insert(0,"A");
        queue.insert(1,"B");
        queue.insert(2,"C");
        queue.insert(3,"D");

        //测试修改
//        queue.changeItem(2,"E");
        queue.delete(2);

        //测试删除
        while(!queue.isEmpty()){
            int index = queue.delMin();
            System.out.print(index+" ");
        }


    }
    //存储堆中的元素
    private T[] items;

    //保存每一个元素在items数组中的索引，pq数组需要有序
    private int[] pq;

    //保存qp的逆序，pq的值作为索引，pq的索引作为值
    private int[] qp;

    //记录堆中的元素的个数
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.pq = new int[capacity+1];
        this.qp = new int[capacity+1];
        this.N = 0;

        //默认情况下，队列中没有存储任何数据，让qp中的元素都为-1；
        for (int i = 0; i < qp.length; i++) {
            qp[i]=-1;
        }
    }

    //获取队列中元素的个数
    public int size() {
        return N;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return N==0;
    }

    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i, int j) {

        return items[pq[i]].compareTo(items[pq[j]])<0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     */
    private void exchange(int i, int j){
        //交换pq中的数据
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        //更新qp中的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 判断k对应的元素是否存在
     */
    public boolean contains(int k){
        return qp[k] != -1;
    }

    /**
     * 最小元素关联的索引
     */
    public int minIndex(){
        return qp[1];
    }

    /**
     * 往队列中插入一个元素,并关联索引i
     */
    public void insert(int i, T t){
        //判断i是否已经被关联，如果已经被关联，则不让插入

        if (contains(i)){
            System.out.println("非法操作，请勿重复");
            return;
        }
        //元素个数+1
        N++;
        //把数据存储到items对应的i位置处
        items[i] = t;
        //把i存储到pq中
        pq[N] = i;
        //通过qp来记录pq中的i
        qp[i] = N;

        //通过堆上浮完成堆的调整
        swim(N);

    }
    /**
     * 删除队列中最小的元素,并返回该元素关联的索引
     */
    public int delMin(){
        //获取最小元素关联的索引
        int minIndex = pq[1];

        //交换pq中索引1处和最大索引处的元素
        exchange(1,N);

        //删除qp中对应的内容
        qp[pq[N]] = -1;
        //删除items中对应的内容
        items[minIndex] = null;

        //元素个数-1
        N--;
        //下沉调整
        sink(1);

        return minIndex;


    }

    /**
     * 删除索引i关联的元素
     */
    public void delete(int i){
        //找到i在pq中的索引
        int k = qp[i];
        //交换pq中索引k处的值和索引N处的值
        exchange(k,N);
        //删除qp中的内容
        qp[pq[N]] = -1;
        //删除pq中的内容
        pq[N]=-1;
        //删除items中的内容
        items[k]=null;
        //元素的数量-1
        N--;
        //堆的调整
        sink(k);
        swim(k);

    }

    //把与索引i关联的元素修改为为t
    public void changeItem(int i, T t) {
        //修改items数组中i位置的元素为t
        items[i] = t;
        //找到i在pq中出现的位置
        int k = qp[i];
        //堆调整
        sink(k);
        swim(k);
    }
    /**
     *  使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k) {
        while(k>1){
            if (less(k,k/2)){
                exchange(k,k/2);
            }else{
                break;
            }

            k = k/2;
        }
    }


    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void sink(int k) {
        while(2*k<=N){
            //找到子结点中的较小值
            int min;
            if (2*k+1<=N){
                if (less(2*k,2*k+1)){
                    min = 2*k;
                }else{
                    min = 2*k+1;
                }
            }else{
                min = 2*k;
            }
            //比较当前结点和较小值
            if (less(k,min)){
                break;
            }

            exchange(k,min);
            k = min;
        }
    }



























}
