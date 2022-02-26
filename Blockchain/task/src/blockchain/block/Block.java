package blockchain.block;

public interface Block {
    long getId();

    long getRuntime();

    long getTimestamp();

    long getMagicNumber();

    String getHash();

    String getPreviousHash();

    String getOwner();
}
