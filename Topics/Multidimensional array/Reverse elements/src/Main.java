
class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        // write your code here

        for (int j = 0; j < twoDimArray.length; j++) {
            for (int i = 0; i < twoDimArray[j].length / 2; i++) {
                int temp = twoDimArray[j][i];
                twoDimArray[j][i] = twoDimArray[j][twoDimArray[j].length - i - 1];
                twoDimArray[j][twoDimArray[j].length - i - 1] = temp;
            }
        }
    }
}