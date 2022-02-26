package blockchain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BlockChainFactory {
    private static BlockChainFactory instance = new BlockChainFactory();
    int threads = Runtime.getRuntime().availableProcessors();

    private BlockChainFactory() {
    }

    public static BlockChainFactory getInstance() {
        return instance;
    }

    void setThreads(int threads) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        this.threads = Math.min(threads, numThreads);
    }

    BlockChain generateChainSizeOf(int chainSize, int zeroesInHash) throws ExecutionException, InterruptedException {

        BlockChain blockChain = new BlockChain(zeroesInHash);

        extend(blockChain, chainSize);
        return blockChain;
    }

    void extend(BlockChain blockChain, int blocksNum) throws ExecutionException, InterruptedException {
        for (int i = 0; i < blocksNum; i++) {
            extendByOneBlock(blockChain);
        }
    }

    void extendByOneBlock(BlockChain blockChain) throws ExecutionException, InterruptedException {
        Stopwatch.reset();
        Set<Callable<Block>> miners = new HashSet<>();
        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        ArrayList<String> messagesCache = new ArrayList<>(blockChain.Messages);
        blockChain.Messages.removeAll(messagesCache);
        String BlockData = String.join("\n", messagesCache);

        for (int i = 1; i <= threads; i++) {
            BlockMiner miner = new BlockMiner(blockChain);
            miner.setId(i);
            miner.BlockData = BlockData;
            miners.add(miner);
        }
        Block result = executorService.invokeAny(miners);
        result.printInfo();
        blockChain.add(result);
        executorService.shutdownNow();
    }
}