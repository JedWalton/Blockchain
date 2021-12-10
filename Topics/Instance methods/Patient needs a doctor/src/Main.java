
class Patient {

    String name;

    // write your method here
    public void say() {
        name = name.format("Hello, my name is %s, I need a doctor.", this.name);
        System.out.println(name);
    }
}