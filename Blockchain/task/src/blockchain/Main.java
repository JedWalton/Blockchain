package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter how many zeros the hash must start with: ");
        final var zeros = new Scanner(System.in).nextInt();
        System.out.println();
        final var blockchain = Blockchain.getInstance(zeros);
        blockchain.generateBlocks(5);
        System.out.println(blockchain);
    }
}