package blockchain;

import java.security.PrivateKey;
import java.util.Arrays;

public class HonestTransaction implements Transaction {
    private final String from;
    private final long uid;
    private final byte[] signature;
    private final String to;
    private final double value;

    public HonestTransaction(String from, String to, double value, long uid, PrivateKey privateKey) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.uid = uid;

        try {
            this.signature = SignatureHelper.sign(getDigest(), privateKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public byte[] getSignature() {
        return signature.clone();
    }

    @Override
    public long getUid() {
        return uid;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("HonestTransaction{from='%s', uid=%d, signature=%s, to='%s', value=%s}",
                from,
                uid,
                Arrays.toString(signature),
                to,
                value);
    }
}