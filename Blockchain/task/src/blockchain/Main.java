package blockchain;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int blocksNumber = 15;
        int zeros = 4;
        int miners = 10;
        ParallelExecutor<Block> parallelExecutor = new ParallelExecutor<>(12, miners);

        Supplier<List<Transaction>> transactionSupplier;
        PublicKey pk;
        try {
            SignatureHelper.createKeys();
            PrivateKey sk = SignatureHelper.getPrivate("private.key");
            pk = SignatureHelper.getPublic("public.pub");

            transactionSupplier = transactionGenerator(sk);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        LinkedList<Block> blockchain = new LinkedList<>();
        for (int i = 0; i < blocksNumber; i++) {
            List<Transaction> transactions = i == 0 ? List.of() : transactionSupplier.get();
            Block block = parallelExecutor.execute(id -> () -> new Block("miner" + id,
                    new LinkedList<>(blockchain),
                    zeros,
                    transactions,
                    pk));

            blockchain.add(block);

            printBlock(block);
            System.out.println("N stays the same");
            System.out.println();
        }
    }

    private static Supplier<List<Transaction>> transactionGenerator(PrivateKey privateKey) {
        Random random = new Random();
        return () -> {

            int transactionsNumber = random.nextInt(3) + 1;
            List<Transaction> transactions = new ArrayList<>(transactionsNumber);

            for (int i = 0; i < transactionsNumber; i++) {
                String from = "miner" + random.nextInt(10);
                String to = "miner" + random.nextInt(10);
                double value = Math.abs(random.nextDouble() * 25);
                transactions.add(new HonestTransaction(from, to, value, Util.INT_SUPPLIER.getAsInt(), privateKey));
            }

            return transactions;
        };
    }

    private static void printBlock(Block block) {
        List<Transaction> transactions = block.getTransactions();
        String message = transactions.isEmpty() ?
                "no transactions" :
                System.lineSeparator() + transactions.stream()
                        .map(tr -> String.format("%s sent %.2f VC to %s", tr.getFrom(), tr.getValue(), tr.getTo()))
                        .collect(Collectors.joining(System.lineSeparator()));
        System.out.printf("Block:%n" +
                        "Created by: %s%n" +
                        "%s gets %.0f VC%n" +
                        "Id: %d%n" +
                        "Timestamp: %d%n" +
                        "Magic number: %d%n" +
                        "Hash of the previous block: %n" +
                        "%s%n" +
                        "Hash of the block: %n" +
                        "%s%n" +
                        "Block data: %s%n" +
                        "Block was generating for %d seconds%n",
                block.getAuthor(), block.getAuthor(), block.getReward(), block.getUid(), block.getTimestamp(),
                block.getMagicNumber(), block.getPreviousHash(), block.getHash(), message, block.getMiningDuration());
    }
}