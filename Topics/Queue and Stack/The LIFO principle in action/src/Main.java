
class Main {
    public static void main(String[] args) {
        java.util.Deque<Integer> myStack = new java.util.ArrayDeque<>();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        scanner.nextLine();
        while (scanner.hasNextInt()) {
        myStack.offerLast(scanner.nextInt());
        }
        while (!myStack.isEmpty()) {
            System.out.println(myStack.pollLast());
        }
    }
}
