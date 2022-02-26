package blockchain;


import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int zeroesInHash = 0;
        BlockChainFactory chainFactory = BlockChainFactory.getInstance();
        BlockChain blockChain = chainFactory.generateChainSizeOf(0, zeroesInHash);
        ChatEmulator chatEmulator = ChatEmulator.getInstance();
        chatEmulator.haveChatAt(blockChain);
        chainFactory.extend(blockChain, 5);
        Thread.sleep(10000);
        chatEmulator.stop();
    }
}