public class Main {

    public static void main(String[] args) {
        ConstantsAndUtilities constAndUtil = new ConstantsAndUtilities();
        System.out.println(constAndUtil.A_CONSTANT_TTT);
        System.out.println(constAndUtil.B_CONSTANT_QQQ);
        System.out.println(constAndUtil.getMagicString());
        System.out.println(constAndUtil.convertStringToAnotherString("aa"));


    }

}

// Don't change this class
class ConstantsAndUtilities {

    public static final String A_CONSTANT_TTT = "1234";

    public static final String B_CONSTANT_QQQ = "7890";

    public static String getMagicString() {
        return A_CONSTANT_TTT + B_CONSTANT_QQQ;
    }

    public static String convertStringToAnotherString(String s) {
        return A_CONSTANT_TTT + s;
    }
}