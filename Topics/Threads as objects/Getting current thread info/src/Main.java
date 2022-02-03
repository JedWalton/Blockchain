class Info {

    public static void printCurrentThreadInfo() {
        // get the thread and print its info


        System.out.println("name: " + Thread.currentThread().getName());
        System.out.println("priority: " + Thread.currentThread().getPriority());

    }
}