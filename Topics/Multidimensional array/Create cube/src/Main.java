
class ArrayOperations {
    public static int[][][] createCube() {

        final int magicNum = 3;
        int[][][] cube = new int[magicNum][magicNum][magicNum];
        int count;
        for (int i = 0; i < magicNum; i++) {
            count = 0;
            for (int j = 0; j < magicNum; j++) {
                for (int k = 0; k < magicNum; k++) {
                    cube[i][j][k] = count;
                    count++;
                }
            }
        }
        return cube;
    }
}