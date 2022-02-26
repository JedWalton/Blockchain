package blockchain.block;

import java.util.Objects;

public class SimpleBlockParams implements BlockParams {
    protected long id;
    protected long timestamp;
    protected long runtime;
    protected long magicNumber;
    protected String hash;
    protected String previousHash;
    protected String owner;

    public SimpleBlockParams(PartBlockParams params) {
        this.id = params.getId();
        this.previousHash = params.getPreviousHash();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    @Override
    public long getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(long magicNumber) {
        this.magicNumber = magicNumber;
    }

    @Override
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleBlockParams that = (SimpleBlockParams) o;
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
        return "SimpleBlockParams{" +
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
