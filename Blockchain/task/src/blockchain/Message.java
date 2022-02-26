package blockchain;

import java.io.Serializable;
import java.security.PublicKey;
import java.time.LocalDateTime;

public class Message implements Serializable {

    private static final long serialVersionUID = 12L;

    private final String sender;
    private final String textMessage;
    private final LocalDateTime dateTime;
    private final long id;
    private final byte[] signature;
    private final PublicKey publicKey;

    public Message(String sender, String textMessage, LocalDateTime dateTime,
                   long id, byte[] signature, PublicKey publicKey) {
        this.sender = sender;
        this.textMessage = textMessage;
        this.dateTime = dateTime;
        this.id = id;
        this.signature = signature;
        this.publicKey = publicKey;
    }

    public byte[] getSignature() {
        return signature;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getSender() {
        return sender;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", sender, textMessage);
    }
}