package algorithm.ds.tree;

import algorithm.TreeNode;
import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Test;
import sun.util.resources.cldr.xog.CalendarData_xog_UG;

/**
 * @Auther: c
 * @Date: 2020/11/21 - 11 - 21 - 13:47
 * @Description: algorithm.ds.tree Morris遍历
 * @Version: 1.0
 */
public class MorrisOrder {
    /**
     * Morris遍历
     *
     * @param root
     */
    public void morris(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            if ((mostRight = cur.left) != null) {   //左树不为空
                //找到mostRight
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //第一次访问
                    mostRight.right = cur;
                    cur = cur.left;     //左移
                    continue;   //左移之后就不要右移了
                } else {    //mostRight.right=cur,是第二次访问
                    mostRight.right = null;
                }
            }
            cur = cur.right; //右移
        }
    }

    /**
     * Morris实现中序遍历
     *
     * @param root
     */
    public void morrisInOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            if ((mostRight = cur.left) != null) {   //左树不为空
                //找到mostRight
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //第一次访问
                    mostRight.right = cur;
                    cur = cur.left;     //左移
                    continue;   //左移之后就不要右移了
                } else {    //mostRight.right=cur,是第二次访问
                    mostRight.right = null;
                }
            }
            System.out.print(cur.val + "  ");   //左树不为空的节点第二次访问打印，左树为空直接打印
            cur = cur.right; //右移
        }
    }


    /**
     * Morris实现先序遍历
     *
     * @param root
     */
    public void morrisPreOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            if ((mostRight = cur.left) != null) {   //左树不为空
                //找到mostRight
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {    //第一次访问
                    mostRight.right = cur;
                    System.out.print(cur.val + "  ");   //左树不为空，第一次访问的时候打印
                    cur = cur.left;     //左移
                    continue;   //左移之后就不要右移了
                } else {
                    mostRight.right = null;
                }
            } else
                System.out.print(cur.val + "  ");     //左树为空，只访问一次，也要打印

            cur = cur.right; //右移
        }
    }


    /**
     * Morris实现后序遍历
     *
     * @param root
     */
    public void morrisPostOrder(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode mostRight = null;
        while (cur != null) {
            if ((mostRight = cur.left) != null) {   //左树不为空
                //找到mostRight
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //第一次访问
                    mostRight.right = cur;
                    cur = cur.left;     //左移
                    continue;   //左移之后就不要右移了
                } else {    //mostRight.right=cur,是第二次访问
                    mostRight.right = null;
                    printEdge(cur.left);  //左树不为空的节点第二次访问时逆序打印左孩子的右边界
                }
            }
            cur = cur.right; //右移
        }
        printEdge(root); //逆序打印根节点的右边界
    }

    private void printEdge(TreeNode node) { //反转链表！！！
        TreeNode tail = reverseEdge(node);
        TreeNode p = tail;
        while (p != null) {
            System.out.print(p.val + "  ");
            p = p.right;
        }
        reverseEdge(tail);
    }

    private TreeNode reverseEdge(TreeNode node) { //反转链表！！
        TreeNode p = node;
        TreeNode pre = null;
        TreeNode temp = null;
        while (p != null) {
            temp = p.right;
            p.right = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }


    /**
     * 判断一颗二叉树是否是搜索二叉树
     * @param root
     * @return
     */
    public boolean isBST(TreeNode root) {
        TreeNode cur = root;
        TreeNode mostRight = null;
        Integer pre = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            if(pre!=null&&cur.val<=pre){    //小于等于中序前驱，不是二叉树
                return false;
            }
            pre = cur.val;  //更新pre

            cur = cur.right;
        }
        return true;
    }


    @Test
    public void Test() {
        TreeNode root = TreeNode.getTestTree();
        System.out.println(isBST(root.right));
    }
}
