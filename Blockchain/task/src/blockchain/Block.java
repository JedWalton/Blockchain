package blockchain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Block implements Serializable {

    private static final long serialVersionUID = 12L;

    private final int id;
    private final long timeStamp;
    private final int magicNumber;
    private final int generationDuration;
    private String changeOfNbOfZeros;
    private final String minerId;
    private final String hash;
    private final String hashOfPreviousBlock;
    private final List<Message> messages;

    public Block(int id, String hashOfPreviousBlock, long timestamp,
                 int magicNumber, int generationDuration,
                 List<Message> messages, String minerId) {
        this.id = id;
        this.hashOfPreviousBlock = hashOfPreviousBlock;
        this.magicNumber = magicNumber;
        this.generationDuration = generationDuration;
        this.timeStamp = timestamp;
        this.minerId = minerId;
        this.messages = messages;
        this.hash = HashCreator.createHash(hashOfPreviousBlock, id, timeStamp, magicNumber, messages, minerId);
    }

    public int getId() {
        return id;
    }

    public int getGenerationDuration() {
        return generationDuration;
    }

    public String getHashOfPreviousBlock() {
        return hashOfPreviousBlock;
    }

    public String getHash() {
        return hash;
    }

    public String getMinerId() {
        return minerId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setChangeOfZeros(int change) {
        switch (change) {
            case 0:
                this.changeOfNbOfZeros = "N stays the same";
                break;
            case 1:
                this.changeOfNbOfZeros = "N was increased by 1";
                break;
            case -1:
                this.changeOfNbOfZeros = "N was decreased by 1";
                break;
            default:
                this.changeOfNbOfZeros = "?";
        }
    }

    @Override
    public String toString() {
        String strMessages = messages.isEmpty() ? "no messages" :
                messages.stream()
                        .map(Objects::toString)
                        .collect(Collectors.joining("\n"));
        return String.format("Block: %n" +
                        "Created by Miner %s%n" +
                        "Id: %s%nTimestamp: %d%n" +
                        "Magic number: %d%n" +
                        "Hash of the previous block: %n%s%n" +
                        "Hash of the block: %n%s%n" +
                        "Block data:%n" +
                        "%s%n" +
                        "Block was generating for %d seconds%n" +
                        "%s%n",
                minerId, id, timeStamp, magicNumber, hashOfPreviousBlock, hash,
                strMessages, generationDuration, changeOfNbOfZeros);
    }
}
