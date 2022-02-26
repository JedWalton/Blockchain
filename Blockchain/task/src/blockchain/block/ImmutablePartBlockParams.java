package blockchain.block;

import java.util.Objects;

public class ImmutablePartBlockParams implements PartBlockParams {
    protected final long id;
    protected final String previousHash;

    public ImmutablePartBlockParams(long id, String previousHash) {
        this.id = id;
        this.previousHash = previousHash;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutablePartBlockParams that = (ImmutablePartBlockParams) o;
        return id == that.id &&
                Objects.equals(previousHash, that.previousHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, previousHash);
    }

    @Override
    public String toString() {
        return "ImmutablePartBlockParams{" +
                "id=" + id +
                ", previousHash='" + previousHash + '\'' +
                '}';
    }
}
