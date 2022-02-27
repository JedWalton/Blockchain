package blockchain;

public interface Transaction {
    default byte[] getDigest() {
        byte[] from = getFrom().getBytes();
        byte[] to = getTo().getBytes();
        byte[] value = SignatureHelper.doubleToBytes(getValue());
        byte[] uid = SignatureHelper.longToBytes(getUid());

        return Util.concat(from, to, value, uid);
    }

    byte[] getSignature();

    long getUid();

    String getFrom();

    String getTo();

    double getValue();
}