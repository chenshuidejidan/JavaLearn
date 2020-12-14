package algorithm;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode getTestTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);        //                 1
        TreeNode node3 = new TreeNode(3);        //              /     \
        TreeNode node4 = new TreeNode(4);        //            2         3
        TreeNode node5 = new TreeNode(5);        //           / \       /
        TreeNode node6 = new TreeNode(6);        //          4   5     6
        TreeNode node7 = new TreeNode(10);        //               \     \
        TreeNode node8 = new TreeNode(8);        //                10     8
        node6.right = node8;
        node3.left = node6;
        node2.left = node4;
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node5.right = node7;
        return node1;
    }

//    @Override
//    public String toString() {
//        return "TreeNode{" +
//                "val=" + val +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
//    }

}