package blockchain;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;


class StringUtil {
    /* Applies Sha256 to a string and returns a hash. */
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem: hash) {
                String hex = Integer.toHexString(0xff & elem);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

final class Block {
    public String hash;
    public String hashOfPrevBlock;
    public int blockId;
    public long timestamp;

    public Block(String hashOfPrevBlock, int blockId) {
        this.hashOfPrevBlock = hashOfPrevBlock;
        this.blockId = blockId;
        this.timestamp = new Date().getTime();
        this.hash = StringUtil.applySha256(hashOfPrevBlock);
    }


}

class Blockchain {
    ArrayList<Block> blockchain = new ArrayList();
    public Blockchain() {

    }

    public void generateBlock() {
        if (blockchain.size() > 0) {
            Block newBlock = new Block(blockchain.get(blockchain.size() - 1).hash, blockchain.size());
            this.blockchain.add(newBlock);
        } else {
            Block newBlock = new Block("0", 0);

            this.blockchain.add(newBlock);
        }
    }

    public void validateBlockchain() {
        for (int i = 0; i < blockchain.size() - 1; i++) {
            if (i > 0) {
                if (this.blockchain.get(i).hashOfPrevBlock == StringUtil.applySha256(this.blockchain.get(i).hash)) {
                    continue;
                } else {
                    System.out.println("Invalid block at " + i);
                    break;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        for (int i = 0; i < 5; i++) {
            blockchain.generateBlock();
            System.out.println("Block:");
            System.out.println("Id: " + blockchain.blockchain.get(i).blockId);
            System.out.println("Timestamp: " + blockchain.blockchain.get(i).timestamp);
            System.out.println("Hash of the previous block:");
            System.out.println(blockchain.blockchain.get(i).hashOfPrevBlock);
            System.out.println("Hash of the block:");
            System.out.println(blockchain.blockchain.get(i).hash);
            System.out.println();

            blockchain.validateBlockchain();
        }
    }
}