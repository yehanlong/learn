package test;


import DataStructure.LinkedList;

import java.util.Stack;

/**
 * @Classname BSTree
 * @Description 源码https://blog.csdn.net/u011676300/article/details/80715249
 * @Created by yhl
 */
public class BSTree {
    public class Node{
        private int val;
        private Node left;
        private Node right;
        public void printNode(){
            System.out.println(val);
        }
    }
    public Node root;

//插入结点到二叉查找树
    public void insert(int val){
        Node target = new Node();
        target.val = val;
        if(root == null){
            root = target;
        }else {
            Node cur = root;
            Node parent;
            while (true){
                parent = cur;
                if(cur.val>target.val){
                    cur = cur.left;
                    if(cur == null){
                        parent.left = target;
                        return;
                    }
                }else if(cur.val<target.val){
                    cur = cur.right;
                    if(cur ==null){
                        parent.right =target;
                        return;
                    }
                }
            }
        }
    }
//查找是否存在某个结点，并输出他的前驱，后继结点
    public boolean find(Node node,int target){
        Node cur = node;
        Node parent =cur;
        while(cur!=null){
            if(target<cur.val){
                parent =cur;
                cur =cur.left;
            }else if(target>cur.val){
                parent = cur;
                cur = cur.right;
            }else if(target == cur.val){
                System.out.println(parent.val);
                System.out.println(cur.val);
                System.out.println(cur.left.val);
                System.out.println(cur.right.val);
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
//删除某个结点
    public boolean delete(int target){
        Node cur = root;
        Node parent = root;
        boolean isleft = false;
        boolean isright =false;
        while(cur.val != target){
            parent =cur;
            isleft =false;
            isright =false;
            if(target>cur.val){
                cur =cur.right;
                isright =true;
            }else if(target<cur.val) {
                cur =cur.left;
                isleft =true;
            }
            if(cur.val!=target&&cur.left==null&&cur.right ==null){
                return false;
            }
        }
        if(cur.left==null&&cur.right==null){
            if(isleft){
                parent.left =null;
            }
            if(isright){
                parent.right = null;
            }
            return true;
        }else if(cur.left!=null&&cur.right==null){
            if(isleft){
                parent.left =cur.left;
            }
            if(isright){
                parent.right =cur.left;
            }
            return true;
        }else if(cur.right!=null&&cur.left==null){
            if(isleft){
                parent.left =cur.right;
            }
            if(isright){
                parent.right = cur.right;
            }
            return true;
        }else if(cur.right!=null&&cur!=null){
            if(isleft){
                parent.left =cur.right;
                Node curleft = cur.right;
                Node parentleft = curleft;
                while (curleft !=null){
                    parentleft = curleft;
                    curleft =curleft.left;
                }
                parentleft.left = cur.left;
                printTreeByleft(root);
            }
            if(isright){
                parent.right =cur.right;
                Node curright = cur.right;
                Node parentright = curright;
                while (curright!=null){
                    parentright =curright;
                    curright = curright.left;
                }
                parentright.left =cur.left;
            }
            return true;
        }
        return true;
    }
//    public  void printTreeByleft(Node root){
//        if(root==null){
//            return;
//        }
//        printTreeByleft(root.left);
//        System.out.println(root.val);
//        printTreeByleft(root.right);
//
//    }
    public static void printTreeByleft(Node root){
        if(root==null){
            return;
        }
        Stack<Node> stack = new Stack();
        Node tmp =root;
        while (true){
            while (tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty()){
                break;
            }
            tmp = stack.pop();
            System.out.println(tmp.val);
            tmp = tmp.right;
        }
    }
    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.insert(50);
        bsTree.insert(25);
        bsTree.insert(65);
        bsTree.insert(15);
        bsTree.insert(35);
        bsTree.insert(55);
        bsTree.insert(70);
        bsTree.insert(10);
        bsTree.insert(20);
        bsTree.insert(30);
        bsTree.insert(36);
//        printTreeByleft(bsTree.root);
        System.out.println(bsTree.find(bsTree.root,15));
//        System.out.println(bsTree.delete(25));

    }
}
