class Account {

    private long balance = 0;

    public synchronized boolean withdraw(long amount) {
        return false;
    }

    public synchronized void deposit(long amount) {
        // do something useful
    }

    public long getBalance() {
        return balance;
    }
}