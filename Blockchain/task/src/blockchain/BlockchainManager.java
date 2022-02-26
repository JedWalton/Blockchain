package blockchain;

import java.util.ArrayList;
import java.util.List;

public class BlockchainManager {

    Blockchain blockchain;

    public BlockchainManager(Blockchain blockchain) {
        this.blockchain = blockchain;
    }

    public void startBlockchain(int nbOfThreads, int nbOfBlocksToAdd) {

        int totalNbOfBlocks = nbOfBlocksToAdd + blockchain.getNbOfBlocks();

        List<Thread> threads = new ArrayList<>(nbOfThreads);

        for (int i = 0; i < nbOfThreads; i++) {
            threads.add(new Thread(
                    new Miner(blockchain, totalNbOfBlocks),
                    "#" + (i + 1)
            ));
            threads.get(i).start();
        }

        startMessageSender();

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void startMessageSender() {
        MessageSender messageSender = new MessageSender();
        Thread messageThread = new Thread(messageSender);
        messageThread.start();
    }

    public static Blockchain retrieveOrCreateBlockchain(String fileName) {
        Blockchain blockchain;

        try {
            blockchain = (Blockchain) SerializationUtils.deserialize(fileName);
            System.out.println("Retrieving existing Blockchain");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Creating new Blockchain");
            blockchain = Blockchain.getInstance();
        }

        if (!BlockchainValidator.isBlockchainValid()) {
            System.out.println("Invalid blockchain! Creating new one");
            blockchain = Blockchain.getInstance();
        }

        return blockchain;
    }

}