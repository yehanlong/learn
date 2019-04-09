package test;

import javafx.beans.binding.When;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Classname TreeTest
 * @Description null
 * @Created by yhl
 */
public class TreeTest {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*
                  1
                / \
               2   3
              / \   \
             4  5   6
     */
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;

        //getDepth(r1);
        printTree4(r1);
    }

    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int deepth = 0;
        int curNodes =1;
        int nextNodes = 0;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()){
            TreeNode cur = treeNodes.remove();
            curNodes--;
            if(cur.left!=null){
                treeNodes.add(cur.left);
                nextNodes++;
            }
            if(cur.right!=null){
                treeNodes.add(cur.right);
                nextNodes++;
            }
            if(curNodes==0){
                deepth++;
                curNodes = nextNodes;
                nextNodes =0;
            }
        }
        System.out.println(deepth);
        return deepth;
    }
//先序
    public static void printTree1(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur =stack.pop();
            System.out.println(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }

//中序
    public static void printTree2(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tmp = root;
        while(true){
            while(tmp!=null){
                stack.push(tmp);
                tmp = tmp.left;
            }
            if(stack.isEmpty()){
                break;
            }
            tmp = stack.pop();
            System.out.println(tmp.val);
            tmp =tmp.right;
        }

    }
//后序
    public static void printTree3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            output.push(tmp);
            if(tmp.left!=null){
                stack.push(tmp.left);
            }
            if(tmp.right!=null){
                stack.push(tmp.right);
            }
        }
        while (!output.isEmpty()){
            System.out.println(output.pop().val);
        }

    }

    public static void printTree4(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            TreeNode cur = linkedList.remove();
            System.out.println(cur.val);
            if(cur.left!=null){
                linkedList.add(cur.left);
            }
            if(cur.right!=null){
                linkedList.add(cur.right);
            }
        }
    }
}
