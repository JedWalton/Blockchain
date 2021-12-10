class ArrayOperations {
    public static void printTheThirdRow(int[][] twoDimArray) {
        // write your code here
        int len = twoDimArray[2].length;

        for (int i = 0; i < len; i++) {
            System.out.print(twoDimArray[2][i] + " ");
        }
    }
}