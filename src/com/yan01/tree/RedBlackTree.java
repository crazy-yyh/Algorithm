package com.yan01.tree;

import com.yan01.link_list.Queue;

public class RedBlackTree<Key extends Comparable<Key>,Value> {

    //根节点
    private Node root;
    //记录树中元素的个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = false;


    public static void main(String[] args) {
        //创建红黑树
        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        //往树中插入元素
        tree.put(1,"张1");
        tree.put(2,"李2");
        tree.put(3,"王3");
        tree.put(4,"王4");
        tree.put(5,"王5");
        //从树中获取元素
//        String r1 = tree.get(1);
//        System.out.println(r1);
//
//
//        String r2 = tree.get(2);
//        System.out.println(r2);
//
//        String r3 = tree.get(3);
//        System.out.println(r3);
        Queue<Integer> integers = tree.mid();
        for (Integer key : integers) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }
    }

    /**
     * 结点类
     */
    private class Node{
        //存储键
        public Key key;
        //存储值
        public Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;
        //由其父结点指向它的链接的颜色
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int length(){
        return N;
    }

    /**
     * 判断当前节点的父指向链接是否为红色
     */
    public boolean isRed(Node x){

        //不存在
        if(x == null){
            return false;
        }

        //判断是否是红色
        return x.color == RED;
    }

    /**
     * 左旋转
     */
    private Node rotateLeft(Node h){

        //找到h结点的右子结点x
        Node x = h.right;
        //找到x结点的左子结点，让x结点的左子结点称为h结点的右子结点
        h.right = x.left;
        //让h结点称为x结点的左子结点
        x.left = h;
        //让x结点的color属性变为h结点的color属性
        x.color = h.color;
        //让h结点的color属性变为RED
        h.color = RED;

        return x;
    }

    /**
     * 右旋转
     */
    public Node rotateRight(Node h){

        //找到h结点的左子结点 x
        Node x = h.left;
        //让x结点的右子结点成为h结点的左子结点
        h.left = x.right;
        //让h结点成为x结点的右子结点
        x.right = h;
        //让h结点成为x结点的右子结点
        x.color = h.color;
        //让h结点的color属性为RED
        h.color = RED;

        return x;
    }

    /**
     * 颜色反转,相当于完成拆分4-节点
     */
    private void flipColors(Node h){
        //当前结点变为红色
        h.color = RED;
        //左子结点和右子结点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 在整个树上完成插入操作
     */
    public void put(Key key, Value value){
        root = put(root,key,value);
        //根结点的颜色总是黑色
        root.color = BLACK;
    }

    /**
     * 在指定树中，完成插入操作,并返回添加元素后新的树
     */
    private Node put(Node h, Key key, Value value){

        //判断h是否为空，如果为空则直接返回一个红色的结点就可以了
        if(h == null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        //比较h结点的键和key的大小
        int cmp = key.compareTo(h.key);

        if(cmp < 0){
            //继续往左,返回的值会刷新h.left的值
            h.left = put(h.left,key,value);
        }else if(cmp > 0){
            //继续往右
            h.right = put(h.right,key,value);
        }else{
            //发生值的替换
            h.value = value;
        }

        //进行左旋:当当前结点h的左子结点为黑色，右子结点为红色，需要左旋
        if(!isRed(h.left) && isRed(h.right)){
            h = rotateLeft(h);
        }

        //进行右旋：当当前结点h的左子结点和左子结点的左子结点都为红色，需要右旋
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }

        //颜色反转：当前结点的左子结点和右子结点都为红色时，需要颜色反转
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }

        return h;
    }

    /**
     * 根据key，从树中找出对应的值
     */
    public Value get(Key key){
        return get(root,key);
    }

    //从指定的树x中，查找key对应的值
    private Value get(Node h, Key key){
        if(h == null){
            return null;
        }

        int cmp = key.compareTo(h.key);

        if( cmp < 0){
            return get(h.left,key);
        }else if(cmp > 0){
            return get(h.right,key);
        }else{
            return h.value;
        }
    }

    public Queue<Key> mid(){
        Queue<Key> keys = new Queue<>();
        mid(root,keys);
        return keys;
    }

    private void mid(Node x, Queue<Key> keys){

        if(x == null){
            return;
        }
        if(x.left != null){
            mid(x.left,keys);
        }
        keys.enqueue(x.key);
        if(x.right != null){
            mid(x.right,keys);
        }
    }











































}
