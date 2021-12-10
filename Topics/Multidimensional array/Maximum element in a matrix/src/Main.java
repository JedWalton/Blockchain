class Main {
    public static void main(String[] args) {
        var sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = Integer.MIN_VALUE;
        var indices = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int number = sc.nextInt();
                if (number > max) {
                    max = number;
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        System.out.printf("%d %d", indices[0], indices[1]);
    }
}
