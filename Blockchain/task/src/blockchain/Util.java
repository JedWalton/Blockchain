package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.stream.Stream;

class Util {
    public static String sha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final IntSupplier INT_SUPPLIER = new IntSupplier() {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        @Override
        public int getAsInt() {
            return atomicInteger.incrementAndGet();
        }
    };

    public static byte[] concat(byte[]... arrays) {
        int sum = Stream.of(arrays).mapToInt(a -> a.length).sum();
        byte[] result = new byte[sum];

        int total = 0;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, result, total, array.length);
            total += array.length;
        }
        return result;
    }
}