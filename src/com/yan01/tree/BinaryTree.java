package com.yan01.tree;

import com.yan01.link_list.Queue;

import javax.swing.tree.TreeNode;

/**
 * @author yyh
 * @create 2020-11-02 11:52
 */
public class BinaryTree<Key extends Comparable<Key>,Value> {
    //记录根结点
    private Node root;
    //记录树中元素的个数
    private int N;



    private class Node{
        //存储键
        public Key key;
        //存储值
        public Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //创建二叉查找树对象
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        //测试插入
        tree.put(8,"张8");
        tree.put(4,"李四");
        tree.put(10,"王10");
        tree.put(2,"王2");
        tree.put(6,"王6");
        tree.put(9,"王9");
        tree.put(11,"王11");
//        tree.put(1,"王1");
//        tree.put(3,"王3");
//        tree.put(5,"王5");
//        tree.put(7,"王7");
//        tree.delete(8);
//        System.out.println("最小键是："+tree.min());
//        System.out.println("最大键是："+tree.max());
//        System.out.println("最大深度是"+tree.maxDepth());
        Queue<Integer> integers = tree.midErgodic();
        for (Integer key : integers) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }

//        System.out.println("插入完毕后元素的个数："+tree.size());

        //测试获取
//        System.out.println("键2对应的元素是："+tree.get(2));

        //测试删除
//
//        tree.delete(1);
//        System.out.println(tree.get(1));
//        System.out.println("删除后的元素个数："+tree.size());
//        System.out.println("删除后键3对应的元素:"+tree.get(3));


    }

    /**
     * 获取树中元素的个数
     */
    public int size(){
        return N;
    }

    /**
     * 向树中添加元素key-value
     */
    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    /**
     * 向指定的树x中添加key-value,并返回添加元素后新的树
     */
    public Node put(Node x, Key key,Value value){
        //如果x子树为空
        if(x == null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果x子树不为空
        //比较x结点的键和key的大小：
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = put(x.right,key,value);
        }else if(cmp <0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = put(x.left,key,value);
        }else{
            //如果key等于x结点的键，则替换x结点的值为value即可
            x.value = value;
        }
        return x;
    }

    /**
     * 查询树中指定key对应的value
     */
    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x, Key key){
        //x树为null
        if(x == null){
            return null;
        }
        //x树不为null

        //比较key和x结点的键的大小
        int cmp = key.compareTo(x.key);

        if(cmp >0){
            //如果key大于x结点的键，则继续找x结点的右子树
            return get(x.right,key);
        }else if(cmp < 0){
            //如果key小于x结点的键，则继续找x结点的左子树
            return get(x.left,key);
        }else{
            //如果key等于x结点的键，就找到了键为key的结点，只需要返回x结点的值即可
            return x.value;
        }
    }

    /**
     * 删除树中key对应的value
     */
    public void delete(Key key){
         root = delete(root,key);
    }

    public Node delete(Node x, Key key){
        //x树为null
        if(x == null){
            return null;
        }
        //x树不为null
        int cmp = key.compareTo(x.key);

        if(cmp > 0){
            //如果key大于x结点的键，则继续找x结点的右子树
            x.right = delete(x.right,key);
        }else if(cmp < 0){
            //如果key小于x结点的键，则继续找x结点的左子树
            x.left = delete(x.left,key);
        }else{
            //如果key等于x结点的键，完成真正的删除结点动作，要删除的结点就是x；
            //让元素个数-1
            N--;

            //得找到右子树中最小的结点

            //右子树为空的情况下直接放回左子树
            if(x.right == null){
                return x.left;
            }
            //左子树为空的情况下直接放回右子树
            if(x.left == null){
                return x.right;
            }
            //左右子树都不为空，找右子树，这是右子树的左子树为空的情况
            Node minNode = x.right;
            //右子树的左子树不为空，找最左
            while(minNode.left != null){
                minNode = minNode.left;
            }

            //删除右子树中最小的结点
            Node n = x.right;
            //这是右子树的左子树为空的情况，需要删除右子树
            if(n.left == null){
                x.right = x.right.right;
            }
            //右子树的左子树不为空
            while(n.left!=null){
                if(n.left.left == null){
                    n.left = null;
                }else{
                    //移动
                    n = n.left;
                }
            }
            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;

        }
        return x;
    }

    /**
     * 查找最小键
     * @return
     */
    public Key min(){
        return min(root).key;
    }

    public Node min(Node x){
        if(x == null){
            return null;
        }
        if(x.left != null){
//            return x.left = x.left.left;
            return min(x.left);
        }else{
            return x;
        }
    }

    /**
     * 查找最大键
     * @return
     */
    public Key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if(x == null){
            return null;
        }
        if(x.right != null){
//            return x.left = x.left.left;
            return max(x.right);
        }else{
            return x;
        }
    }


    //使用中序遍历获取树中所有的键
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new Queue<>();
        midErgodic(root,keys);
        return keys;
    }

    //使用中序遍历，获取指定树x中所有的键，并存放到key中
    private void midErgodic(Node x,Queue<Key> keys){
        if (x==null){
            return;
        }
        //先递归，把左子树中的键放到keys中
        if (x.left!=null){
            midErgodic(x.left,keys);
        }
        //把当前结点x的键放到keys中
        keys.enqueue(x.key);
        //在递归，把右子树中的键放到keys中
        if(x.right!=null){
            midErgodic(x.right,keys);
        }

    }

    //使用前序遍历获取树中所有的键
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    //使用前序遍历获取树中所有的键
    private void preErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }

        //把x结点的key放入到keys中
        keys.enqueue(x.key);

        //递归遍历x结点的左子树
        if (x.left != null) {
            preErgodic(x.left, keys);
        }

        //递归遍历x结点的右子树
        if (x.right != null) {
            preErgodic(x.right, keys);
        }

    }

    //使用后序遍历获取树中所有的键
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    //使用前序遍历获取树中所有的键
    private void afterErgodic(Node x, Queue<Key> keys) {
        if (x == null) {
            return;
        }


        //递归遍历x结点的左子树
        if (x.left != null) {
            afterErgodic(x.left, keys);
        }

        //递归遍历x结点的右子树
        if (x.right != null) {
            afterErgodic(x.right, keys);
        }

        //把x结点的key放入到keys中
        keys.enqueue(x.key);

    }

    //获取整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }


    //获取指定树x的最大深度
    private int maxDepth(Node x){
        if (x==null){
            return 0;
        }
        //x的最大深度
        int max=0;
        //左子树的最大深度
        int maxL=0;
        //右子树的最大深度
        int maxR=0;

        //计算x结点左子树的最大深度
        if (x.left!=null){
            maxL = maxDepth(x.left);
        }
        //计算x结点右子树的最大深度
        if (x.right!=null){
            maxR = maxDepth(x.right);
        }
        //比较左子树最大深度和右子树最大深度，取较大值+1即可

        max = maxL>maxR?maxL+1:maxR+1;

        return max;
    }

































}
