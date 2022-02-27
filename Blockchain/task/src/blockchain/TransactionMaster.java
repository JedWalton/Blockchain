package blockchain;

import java.util.List;

public class TransactionMaster {
    private static final TransactionMaster INSTANCE = new TransactionMaster();
    private static final int INITIAL_BALANCE = 100;

    public static TransactionMaster getInstance() {
        return INSTANCE;
    }

    public double getBalance(List<Block> blockchain, String name) {
        double total = INITIAL_BALANCE;

        for (Block block : blockchain) {
            if (block.getAuthor().equals(name)) {
                total += block.getReward();
            }

            for (Transaction transaction : block.getTransactions()) {
                if (transaction.getFrom().equals(name)) {
                    total -= transaction.getValue();
                } else if (transaction.getTo().equals(name)) {
                    total += transaction.getValue();
                }
            }
        }

        return total;
    }
}