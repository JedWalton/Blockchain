class Primitive {
    public static boolean toPrimitive(Boolean b) {
        try {
            return Boolean.TRUE.equals(b);
        } catch (Exception e) {
            return false;
        }
    }
}