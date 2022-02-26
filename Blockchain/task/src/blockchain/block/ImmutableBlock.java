package blockchain.block;

import java.util.Objects;

public class ImmutableBlock implements Block {
    public static final ImmutableBlock EMPTY = new ImmutableBlock();

    protected final long id;
    protected final long timestamp;
    protected final long runtime;
    protected final long magicNumber;
    protected final String hash;
    protected final String previousHash;
    protected final String owner;

    private ImmutableBlock() {
        this(-1, -1, -1, -1,
                "none", "none", "none");
    }

    public ImmutableBlock(BlockParams params) {
        this.id = params.getId();
        this.timestamp = params.getTimestamp();
        this.runtime = params.getRuntime();
        this.magicNumber = params.getMagicNumber();
        this.hash = params.getHash();
        this.previousHash = params.getPreviousHash();
        this.owner = params.getOwner();
    }

    protected ImmutableBlock(Block block) {
        this(block.getId(), block.getTimestamp(), block.getRuntime(), block.getMagicNumber(),
                block.getHash(), block.getPreviousHash(), block.getOwner());
    }

    protected ImmutableBlock(long id, long timestamp, long runtime, long magicNumber,
                             String hash, String previousHash, String owner) {
        this.id = id;
        this.timestamp = timestamp;
        this.runtime = runtime;
        this.magicNumber = magicNumber;
        this.hash = hash;
        this.previousHash = previousHash;
        this.owner = owner;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public long getRuntime() {
        return runtime;
    }

    @Override
    public long getMagicNumber() {
        return magicNumber;
    }

    @Override
    public String getHash() {
        return hash;
    }

    @Override
    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableBlock that = (ImmutableBlock) o;
        return id == that.id &&
                timestamp == that.timestamp &&
                runtime == that.runtime &&
                magicNumber == that.magicNumber &&
                Objects.equals(hash, that.hash) &&
                Objects.equals(previousHash, that.previousHash) &&
                Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, runtime, magicNumber, hash, previousHash, owner);
    }

    @Override
    public String toString() {
        return "ImmutableBlock{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", runtime=" + runtime +
                ", magicNumber=" + magicNumber +
                ", hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
