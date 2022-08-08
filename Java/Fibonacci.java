class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        Fibonacci(n);
    }
    static void Fibonacci(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3 = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(n1 + " ");
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
    }
}
