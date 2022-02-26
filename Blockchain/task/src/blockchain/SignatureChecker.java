package blockchain;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureChecker {

    public static boolean check(Message message) {
        Signature signature;
        try {
            signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(message.getPublicKey());
            String data = message.getSender() + message.getTextMessage() + message.getDateTime().toString() + message.getId();
            signature.update(data.getBytes());
            return signature.verify(message.getSignature());
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }
}