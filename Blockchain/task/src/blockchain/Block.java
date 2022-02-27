package blockchain;

import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Block {
    private final String previousHash;
    private final String hash;
    private final long timestamp;
    private final int uid;
    private final int magicNumber;
    private final int miningDuration;
    private final long messagesMaxUid;
    private final List<Transaction> transactions;
    private final String author;

    public Block(String author, LinkedList<Block> blockchain, int zeros, List<Transaction> transactions, PublicKey publicKey) {
        Block previous = blockchain.isEmpty() ? null : blockchain.getLast();

        this.author = author;
        previousHash = previous == null ? "0" : previous.hash;
        timestamp = new Date().getTime();
        uid = previous == null ? 0 : previous.uid + 1;
        messagesMaxUid = tryVerify(blockchain, previous, transactions, publicKey);
        this.transactions = new ArrayList<>(transactions);

        String hashProbe;
        int magicNumberProbe;

        long timer = System.currentTimeMillis();
        do {
            if (Thread.currentThread().isInterrupted()) throw new RuntimeException(new InterruptedException());

            magicNumberProbe = randomInt();
            hashProbe = Util.sha256(serialize(uid, timestamp, magicNumberProbe, previousHash, transactions.toString()));
        } while (!hashProbe.startsWith("0".repeat(zeros)));
        miningDuration = (int) ((System.currentTimeMillis() - timer) / 1000);

        magicNumber = magicNumberProbe;
        hash = hashProbe;
    }

    private long tryVerify(LinkedList<Block> blockchain, Block previous, List<Transaction> transactions, PublicKey publicKey) {
        long previousMaxUid = Optional.ofNullable(previous).map(Block::getMessagesMaxUid).orElse(Long.MIN_VALUE);
        try {
            long max = previousMaxUid;
            for (Transaction transaction : transactions) {
                if (!SignatureHelper.verify(transaction, publicKey)) {
                    throw new IllegalArgumentException("verification failed");
                }
                if (previousMaxUid >= transaction.getUid()) {
                    throw new IllegalArgumentException("verification failed");
                }
                String from = transaction.getFrom();
                double balance = TransactionMaster.getInstance().getBalance(blockchain, from);
                if (balance - transaction.getValue() < 0) {
                    throw new IllegalArgumentException("verification failed");
                }
                max = Math.max(max, transaction.getUid());
            }
            return max;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private long getMessagesMaxUid() {
        return messagesMaxUid;
    }

    private int randomInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    private String serialize(int uid, long timestamp, int magicNumber, String previousHash, String message) {
        return String.format("%d-%d-%d-%s-%s", uid, timestamp, magicNumber, previousHash, message);
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getUid() {
        return uid;
    }

    public int getMagicNumber() {
        return magicNumber;
    }

    public int getMiningDuration() {
        return miningDuration;
    }

    public String getAuthor() {
        return author;
    }

    public double getReward() {
        return 100;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}