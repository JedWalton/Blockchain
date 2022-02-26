package blockchain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Blockchain implements Serializable {

    private static final long serialVersionUID = 12L;
    private static Blockchain instance;

    private String fileName;
    private long nbOfZeros = 0L;
    private long dataId = 0L;
    private final List<Block> blocks = new ArrayList<>();
    private final List<Message> newMessagesA = new ArrayList<>();
    private final List<Message> newMessagesB = new ArrayList<>();
    /**
     * List which receives the latest messages
     */
    private List<Message> newMessagesCurrent = newMessagesA;

    private Blockchain() { }

    public static Blockchain getInstance() {
        if (instance == null) {
            instance = new Blockchain();
        }
        return instance;
    }

    // To fix Singleton deserialize issue.
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        instance = this;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public long getNbOfZeros() {
        return nbOfZeros;
    }

    public List<Message> getNewMessages() {
        return new ArrayList<>(newMessagesCurrent == newMessagesA ? newMessagesB : newMessagesA);
    }

    public void addMessage(Message newMessage) {
        List<Message> messagesBeingProcessed = newMessagesCurrent == newMessagesA ? newMessagesB : newMessagesA;
        boolean success = false;
        long previousBlockMax = messagesBeingProcessed.stream()
                .map(Message::getId)
                .mapToLong(l -> l)
                .max()
                .orElse(0);
        if (previousBlockMax < newMessage.getId()) {
            newMessagesCurrent.add(newMessage);
            success = true;
        }
        if (!success) System.out.printf("User %s: Message failed!", newMessage.getSender());
    }

    private void emptyMessages() {
        if (newMessagesCurrent == newMessagesA) {
            newMessagesB.clear();
            newMessagesCurrent = newMessagesB;
        } else {
            newMessagesA.clear();
            newMessagesCurrent = newMessagesA;
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getNbOfBlocks() {
        return blocks.size();
    }

    public Block getLastBlock() {
        return blocks.size() > 0 ? blocks.get(blocks.size() - 1) : null;
    }

    public void addBlock(Block block) {
        if (BlockchainValidator.isNewBlockValid(block)) {
            int update = updateNbOfZeros(block.getGenerationDuration());
            block.setChangeOfZeros(update);
            blocks.add(block);
            emptyMessages();
            serializeBlockchain();
            System.out.printf("Added new block... (%s)%n", block.getMinerId());
        }
    }

    public long getNewDataId() {
        return ++dataId;
    }

    private void serializeBlockchain() {
        try {
            SerializationUtils.serialize(this, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int updateNbOfZeros(int generationDuration) {
        int DURATION_LOWER_BOUND = 1; //seconds
        int DURATION_HIGHER_BOUND = 5; //seconds
        if (generationDuration < DURATION_LOWER_BOUND) {
            nbOfZeros++;
            return 1;
        }
        if (generationDuration > DURATION_HIGHER_BOUND) {
            nbOfZeros--;
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return blocks.stream()
                .skip(Math.max(0, blocks.size() - 5))
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));
    }

}