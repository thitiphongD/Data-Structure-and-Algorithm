class BinarySearchTree {
        public static void main(String[] args) {
        Tree b = new Tree();
        Element root = b.create(6,3,8,4,1,5,2);
        System.out.println("count root " + root.key);
        System.out.println("sum " + b.sum(root));
        System.out.println("height " + b.countHeight(root));
        System.out.println("Leaf " + b.countLeaf(root));
    }
}

class Tree {    
    Element create(int ... a) {
        Element root = null;
        for (int i = 0; i < a.length; i++) {
            root = insert(root, a[i]);
        }
        return root;
    }
    Element insert(Element c, int k) {
        if (c == null) {
            c = new Element();
            c.key = k;
            return c;
        }
        if (c.key > k) {
            c.left = insert(c.left, k);
        }
        if (c.key < k) {
            c.right = insert(c.right, k);
        }
        return c;
    }
    int sum(Element c) {
        if (c == null) {
            return 0;
        } else {
            return c.key + sum(c.left) + sum(c.right);
        }
    }

    int countHeight(Element c) {
        if (c == null) {
            return -1;
        }
        int start = countHeight(c.left);
        int finish = countHeight(c.right);
        return start > finish ? start + 1 : finish + 1;
    }

    int countLeaf(Element c) {
        if (c == null) {
            return 0;
        }
        if (c.left == null && c.right == null) return 1;
        int start = countLeaf(c.left);
        int finish = countLeaf(c.right);
        return start + finish;
    }
}

class Element {
    int key;
    Element left;
    Element right;
}
