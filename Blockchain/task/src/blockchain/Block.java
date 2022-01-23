package blockchain;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

import static blockchain.util.StringUtil.applySha256;

public class Block implements Serializable {
    private static final long serialVersionUID = 1738588544404978242L;
    private final int id;
    private final long timestamp;
    private final String prevBlockHash;
    private long magicNumber;
    private String blockHash;
    private int timeToGenerate;

    public static Block getProved(int id, String prevBlockHash, int zeroes) {
        final var startTime = Instant.now();
        final var block = new Block(id, new Date().getTime(), prevBlockHash);
        block.findMagicNumber(zeroes);
        block.timeToGenerate = Math.toIntExact(Duration.between(startTime, Instant.now()).toSeconds());
        return block;
    }

    private Block(int id, long timestamp, String prevBlockHash) {
        this.id = id;
        this.timestamp = timestamp;
        this.prevBlockHash = prevBlockHash;
    }

    public String getPrevBlockHash() {
        return prevBlockHash;
    }

    public String getBlockHash() {
        return blockHash;
    }

    @Override
    public String toString() {
        return String.format("Block: \n" +
                        "Id: %d \n" +
                        "Timestamp: %d \n" +
                        "Magic number: %d \n" +
                        "Hash of the previous block: \n" +
                        "%s \n" +
                        "Hash of the block: \n" +
                        "%s \n" +
                        "Block was generating for %d seconds",
                id,
                timestamp,
                magicNumber,
                prevBlockHash,
                blockHash,
                timeToGenerate);
    }

    private void findMagicNumber(int zeroes) {
        final var random = new Random();
        var hash = "";
        // TODO: 27/12/2020 WARNING not safe for multithreading
        do {
            magicNumber = random.nextLong();
            hash = applySha256(stringify());
        } while (!isProved(zeroes, hash));
        blockHash = hash;
    }

    public boolean isProved(int zeroes) {
        return isProved(zeroes, applySha256(stringify()));
    }

    private boolean isProved(int zeroes, String blockHash) {
        for (int i = 0; i < zeroes; i++) {
            if (blockHash.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    private String stringify() {
        return "" +
                id +
                timestamp +
                prevBlockHash +
                magicNumber;
    }
}