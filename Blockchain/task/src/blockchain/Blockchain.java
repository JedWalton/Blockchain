package blockchain;

import blockchain.util.SerializationUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Blockchain implements Serializable {
    private static final long serialVersionUID = 3705442926703754261L;
    private final List<Block> blocks;
    private final int zeroes;   // TODO: 27/12/2020

    public static Blockchain getInstance(int zeroes) {
//        try {
//            final var blockchain = (Blockchain) SerializationUtil.deserialize("./Database.txt");
//            return blockchain.isValid() ? blockchain : new Blockchain(zeroes);
        return new Blockchain(zeroes);
//        } catch (ClassNotFoundException e) {
//            e.getMessage();
//            System.out.println("Nothing found on the database. Generating a new blockchain...");
//            return new Blockchain(zeroes);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Something went wrong on restoring the object. Generating a new blockchain...");
//            return new Blockchain(zeroes);
//        }
    }

    private Blockchain(int zeroes) {
        this.blocks = new ArrayList<>();
        this.zeroes = zeroes;
    }

    @Override
    public String toString() {
        final var stringBuilder = new StringBuilder();
        for (var block : blocks) {
            stringBuilder.append(block).append("\n\n");
        }
        return String.valueOf(stringBuilder);
    }

    public void generateBlocks(int blocksNumber) {
        for (var i = 0; i < blocksNumber; i++) {
            generateBlock();
        }
    }

    private void generateBlock() {
        blocks.add(Block.getProved(
                blocks.size(),
                blocks.isEmpty() ? "0" : blocks.get(blocks.size() - 1).getBlockHash(),
                zeroes));
        try {
            SerializationUtil.serialize(this, "./Database.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isValid() {
        for (var i = 0; i < blocks.size(); i++) {
            if (i == 0) {
                if (!blocks.get(i).getPrevBlockHash().equals("0")) return false;
            } else {
                if (!blocks.get(i).getPrevBlockHash().equals(blocks.get(i - 1).getBlockHash())) return false;
            }
            if (!blocks.get(i).isProved(zeroes)) return false;
        }
        return true;
    }
}