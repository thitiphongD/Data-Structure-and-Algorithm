class BinaryTree {
    public static void main(String[] args) {
        Engine e = new Engine();
        int[] data = {1, 2, 3, 4, 5, 6, 10};
        Element root = e.create(data);
        
        int t = e.count(root);
        System.out.println( "number root " + t );

        int j = e.sum(root);
        System.out.println( "sum root " + j );

        int m = e.findMax(root);
        System.out.println( "max root " + m );
    }
}

class Element {
    int number;
    Element left;
    Element right;
}

class Engine {
    int findMax(Element m) {
        if (m == null) {
            return 0;
        }
        int start = findMax(m.left);
        int finish = findMax(m.right);
        if (start >= finish && start >= m.number) {
            return start;
        } 
        if (finish >= start && finish >= m.number) {
            return finish;
        }
        return m.number;
    }

    int sum(Element y) {
        if (y == null) {
            return 0;
        } else {
            return y.number + sum(y.left) + sum(y.right);
        }
    }
    int count(Element x) {
        if (x == null) {
            return 0;
        } else {
            return 1 + count(x.left) + count(x.right);
        }
    }
    Element create(int[] a) {
        return create(a, 0, a.length - 1);
    }
    Element create(int[] a, int start, int finish) {
        if (start > finish) return null;
        int mid = (start + finish) / 2;
        Element result = new Element();
        result.number = a[mid];
        result.left = create(a, start, mid - 1);
        result.right = create(a, mid + 1, finish);
        return result;
    }
}
