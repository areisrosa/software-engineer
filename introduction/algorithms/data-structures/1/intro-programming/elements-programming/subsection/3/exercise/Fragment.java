class Fragment {
    public static void main(String[] args) {
        // int N = Integer.parseInt(args[0]);
        // int M = Integer.parseInt(args[1]);
        // double[][] c = new double[N][N];
        // double[][] b = new double[M][N];
        // double[][] a = new double[N][M];
        //
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         for (int k = 0; k < M; k++) {
        //             if (N == M) {
        //                 c[i][j] += a[i][k] * b[k][j];
        //                 System.out.print(c[i][j] + " ");
        //             } else {
        //                 System.out.print("Dimensions do not satisfy this condition.");
        //                 break;
        //             }
        //         }
        //     }
        //     System.out.println();
        // }
        //
        int[] a = new int[10];

        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
            System.out.println(a[i]);
            System.out.println();
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
            System.out.println(a[i]);
        }

        System.out.println(a[5]);
    }
}
