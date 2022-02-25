package blockchain;


import java.io.Serializable;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int zeroesInHash = 0;
        BlockChainFactory chainFactory = BlockChainFactory.getInstance();
        BlockChain blockChain = chainFactory.generateChainSizeOf(5, zeroesInHash);
    }
}


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
        this.threads = threads > numThreads ? numThreads : threads;
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
        for (int i = 1; i <= threads; i++) {
            BlockMiner miner = new BlockMiner(blockChain);
            miner.setId(i);
            miners.add(miner);
        }
        Block result = executorService.invokeAny(miners);
        result.printInfo();
        blockChain.add(result);
        executorService.shutdownNow();
    }
}

class BlockMiner implements Callable<Block> {
    BlockChain blockChain;
    int id;

    BlockMiner(BlockChain blockChain) {
        this.blockChain = blockChain;
    }


    public void setId(int id) {
        this.id = id;
    }

    public Block call() {
        return generateNextBlock();
    }

    Block generateNextBlock() {
        int chainSize = blockChain.size();
        String previousBlockHash;
        if (chainSize == 0) {
            previousBlockHash = "0";
        } else {
            Block previousBlock = blockChain.getLastBlock();
            previousBlockHash = previousBlock.generateHash();
        }
        int blockId = chainSize + 1;
        Block nextBlock = new Block(previousBlockHash, blockId);
        nextBlock.minerId = id;
        nextBlock.magicNumber = findMagicNumberFor(nextBlock);
        return nextBlock;
    }

    int findMagicNumberFor(Block block) {
        Random random = new Random(Integer.MAX_VALUE);
        String validHashRegex = String.format("0{%d}\\w*", blockChain.getZeroesInHash());
        int magicNumber;
        String hash;
        do {
            magicNumber = random.nextInt();
            hash = block.generateHashUsing(magicNumber);
        }
        while (!hash.matches(validHashRegex) & !currentThread().isInterrupted());
        return magicNumber;
    }
}


class Block implements Serializable {
    private static final long serialVersionUID = 8L;
    String previousHash;
    long timesStamp = new Date().getTime();
    int id;
    int magicNumber;
    int minerId;

    Block(String hash, int id) {
        this.previousHash = hash;
        this.id = id;
    }

    void printInfo() {
        String output = "Block:" +
                "\nCreated by miner # " + minerId +
                "\nId: " + id +
                "\nTimestamp: " + timesStamp +
                "\nMagic number: " + magicNumber +
                "\nHash of the previous block:\n" + previousHash +
                "\nHash of the block:\n" + generateHash();
        System.out.println(output);

    }

    boolean hasValid(int zeroesInHash) {
        String validHashRegex = "0{" + zeroesInHash + "}\\w*";
        String hash = generateHash();
        return hash.matches(validHashRegex);
    }

    String generateHash() {
        return StringUtil.applySha256(previousHash + id + minerId + timesStamp + magicNumber);
    }

    String generateHashUsing(int magicNumber) {
        return StringUtil.applySha256(previousHash + id + minerId + timesStamp + magicNumber);
    }
}

class BlockChain implements Serializable {
    private static final long serialVersionUID = 9L;
    ArrayList<Block> blocks = new ArrayList<>();
    private int zeroesInHash;

    public int getZeroesInHash() {
        return zeroesInHash;
    }

    public int size() {
        return blocks.size();
    }

    BlockChain(int zeroesInHash) {
        this.zeroesInHash = zeroesInHash;
    }


    Block getBlockBy(int id) {
        return blocks.get(id - 1);
    }

    Block getLastBlock() {
        return (size() > 0) ? blocks.get(size() - 1) : null;
    }

    void add(Block block) {
        if (canAdd(block)) {
            blocks.add(block);
            adjustZeroesInHash();
        }
    }

    void adjustZeroesInHash() {
        long elapsedTime = Stopwatch.getElapsedSeconds();
        printGenerationTimeMsg(elapsedTime);
        if (elapsedTime > 60) {
            zeroesInHash -= 1;
            System.out.printf("N was decreased to %d\n\n", zeroesInHash);
        } else if (elapsedTime < 10) {
            zeroesInHash += 1;
            System.out.printf("N was increased to %d\n\n", zeroesInHash);
        } else
            System.out.println("N stays the same\n\n");
    }

    private static void printGenerationTimeMsg(long sec) {
        System.out.printf("Block was generating for %d seconds\n", sec);
    }

    boolean canAdd(Block block) {
        return block.hasValid(zeroesInHash) & canHaveValid(block);
    }


    boolean canHaveValid(Block block) {
        int id = block.id;
        boolean isValid = true;
        if (id > 1) {
            String previousHash = block.previousHash;
            Block previousBlock = getBlockBy(id - 1);
            String hash = previousBlock.generateHash();
            if (!hash.equals(previousHash)) {
                isValid = false;
            }
        }
        return isValid;
    }


    boolean isValid() {
        boolean chainIsValid = true;
        for (Block block : blocks) {
            if (!canHaveValid(block)) {
                chainIsValid = false;
                break;
            }
        }
        return chainIsValid;
    }

    void printAllBlock() {
        for (Block block : blocks
        ) {
            block.printInfo();
            System.out.println();
        }
    }
}