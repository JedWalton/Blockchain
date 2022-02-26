package blockchain;

public class Main {

    public static String fileName = "blockchain.data";

    public static void main(String[] args) {

        Blockchain blockchain = BlockchainManager.retrieveOrCreateBlockchain(fileName);
        blockchain.setFileName(fileName);

        BlockchainManager blockchainManager = new BlockchainManager(blockchain);

        int nbOfBlocksToAdd = 5;
        int nbOfThreads = 6;

        System.out.printf("Adding %d blocks...%n", nbOfBlocksToAdd);
        blockchainManager.startBlockchain(nbOfThreads, nbOfBlocksToAdd);
        System.out.println("Is blockchain valid? " + BlockchainValidator.isBlockchainValid());

        System.out.println();
        System.out.println(blockchain.toString());
    }
}