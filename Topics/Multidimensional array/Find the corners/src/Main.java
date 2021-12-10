class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        int iLength = twoDimArray.length;
        int jLength = twoDimArray[twoDimArray.length - 1].length;
        System.out.println(twoDimArray[0][0] + " " + twoDimArray[0][jLength - 1]);
        System.out.print(twoDimArray[iLength - 1][0] + " " + twoDimArray[iLength - 1][jLength - 1]);
    }
}