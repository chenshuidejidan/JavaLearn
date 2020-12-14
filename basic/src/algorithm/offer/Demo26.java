package algorithm.offer;

import algorithm.ListNode;
import algorithm.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: c
 * @Date: 2020/11/22 - 11 - 22 - 14:29
 * @Description: algorithm.offer
 * @Version: 1.0
 */
public class Demo26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        int[] arrA = preOrder(A);
        int[] arrB = preOrder(B);
        int[] next = getNext(arrB);
        int i = 0, j = 0;
        while(i<arrA.length && j<arrB.length){
            if(j==-1||arrA[i]==arrB[j]){
                i++; j++;
            }else{
                j = next[j];
            }
        }
        if(j==arrB.length)  return true;
        return false;
    }

    private int[] getNext(int[] arr) {
        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int i = 0;
        int j = -1;
        while(i<arr.length-1){
            if(j==-1||arr[i]==arr[j]){
                next[++i]=++j;
            }else{
                j=next[j];
            }
        }
        return next;
    }

    public int[] preOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode p = stack.pop();
            list.add(p.val);
            if(p.right!=null)   stack.push(p.right);
            if(p.left!=null)    stack.push(p.left);
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i<list.size(); i++)  arr[i]=list.get(i);
        return arr;
    }
}
