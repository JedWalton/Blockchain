package blockchain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SignatureHelper {
    public static byte[] sign(byte[] digest, PrivateKey key) throws Exception {
        Signature rsa = Signature.getInstance("SHA1withRSA");
        rsa.initSign(key);

        rsa.update(digest);
        return rsa.sign();
    }

    public static boolean verify(Transaction transaction, PublicKey pk) throws Exception {
        Signature sig = Signature.getInstance("SHA1withRSA");
        sig.initVerify(pk);
        sig.update(transaction.getDigest());

        return sig.verify(transaction.getSignature());
    }

    public static PrivateKey getPrivate(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    public static PublicKey getPublic(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(filename).toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static byte[] longToBytes(long l) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (l & 0xFF);
            l >>= 8;
        }
        return result;
    }

    public static byte[] doubleToBytes(double d) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Double.BYTES);
        byteBuffer.putDouble(d);
        return byteBuffer.array();
    }

    public static void createKeys() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        Key pub = kp.getPublic();
        Key pvt = kp.getPrivate();
        String outFile = "private";
        OutputStream out = new FileOutputStream(outFile + ".key");
        out.write(pvt.getEncoded());
        out.close();

        outFile = "public";
        out = new FileOutputStream(outFile + ".pub");
        out.write(pub.getEncoded());
        out.close();
    }
}