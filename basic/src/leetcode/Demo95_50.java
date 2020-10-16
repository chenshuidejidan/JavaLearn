package leetcode;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Demo95_50 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<TreeNode>();
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if(start>end){
            ans.add(null);
        }else if(start==end){
            ans.add(new TreeNode(start));
        }else {
            for(int i = start; i<=end; i++){
                List<TreeNode> lefts = generateTree(start, i-1);
                List<TreeNode> rights = generateTree(i+1, end);
                for(TreeNode left : lefts){
                    for(TreeNode right:rights){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }


    @Test
    public void testGenerateTree(){
        List<TreeNode> treeNodes = generateTrees(3);
        System.out.println(treeNodes);
    }

    public TreeNode treeCopy(TreeNode root){
        if(root==null)  return root;
        return new TreeNode(root.val, treeCopy(root.left), treeCopy(root.right));
    }

    public TreeNode addNode(TreeNode root, TreeNode n){
        if(root==null){
            root=n;
            return root;
        }
        if(root.val<n.val) root.right = addNode(root.right, n);
        if(root.val>n.val) root.left = addNode(root.left, n);
        return root;
    }
}
