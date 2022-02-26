package blockchain;

import java.util.Date;
import java.util.Random;

class MessageBot implements Runnable {
    String name;
    BlockChain blockChain;
    int maxSleepDuration = 150;
    boolean isStopped = false;

    public MessageBot(String name, BlockChain blockChain) {
        this.name = name;
        this.blockChain = blockChain;
    }


    void SendRandomMessage() {
        blockChain.addMessage(name, generateRandomMessage());
    }

    String generateRandomMessage() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString() + " " + new Date().getTime();
    }

    void stop() {
        isStopped = true;
    }

    @Override
    public void run() {
        long sleepTimer = new Random().nextInt(maxSleepDuration);

        while (!isStopped) {
            SendRandomMessage();
            try {
                Thread.sleep(sleepTimer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}