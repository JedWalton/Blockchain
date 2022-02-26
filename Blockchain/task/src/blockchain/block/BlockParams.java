package blockchain.block;

public interface BlockParams extends PartBlockParams {
    long getTimestamp();

    long getRuntime();

    long getMagicNumber();

    String getHash();

    String getOwner();
}
