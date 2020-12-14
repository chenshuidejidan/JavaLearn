package algorithm.ds.tree;

public class RedBlackTree {
    private final int RED = 0;
    private final int BLACK = 1;
    private Node root = null;
    class Node{
        int data;
        int color=RED;
        Node left;
        Node right;
        Node parent;
        public Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    //插入
    public void insert(Node root, int data){
        if(root.data<data){
            if(root.right==null)
                root.right = new Node(data);
            else
                insert(root.right, data);
        } else if(root.data>data){
            if(root.left==null)
                root.left = new Node(data);
            else insert(root.left, data);
        } else{
            root.data = data;
        }
    }

    //左旋
    private void rotateLeft(Node p){
        if(p!=null){
            Node rightChild = p.right;
            if(p.parent==null){ //p是root
                rightChild.left.parent = p;
                p.parent = rightChild;
                rightChild.parent = null;
                rightChild.left = null;
            }
            if(p==p.parent.left){
                p.parent.left = rightChild;
            } else{
                p.parent.right = rightChild;
            }
            p.right = rightChild.left;
            rightChild.left = p;
        }
    }

    //右旋
    private void rotateRight(Node p){
        if(p!=null){
            Node leftChild = p.left;

        }
    }

}
