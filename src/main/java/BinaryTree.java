

public class BinaryTree {
    public Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                p = p.right;
            } else if (data < p.data){
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert (int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void remove(int data) {
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            pp = minPP;
            p = minP;
        }
        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }
        if (pp == null) {
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static void printBinaryTree(Node n) {
        if (n == null) {
            return;
        }
        printBinaryTree(n.left);
        System.out.println(n.data);
        printBinaryTree(n.right);
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.insert(4);
        b.insert(5);
        b.insert(2);
        b.insert(3);
        b.insert(7);
        b.insert(1);
//        System.out.println(b.find(3).data);
//        b.remove(5);
        printBinaryTree(b.tree);
    }
}
