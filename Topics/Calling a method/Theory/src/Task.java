// You can experiment here, it won’t be checked
class Animal {

  protected int age;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}

class Pet extends Animal {

  protected String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class Cat extends Pet {

  protected String color;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}

public class Task {
  public static void main(String[] args) {
    // put your code here
    Cat cat = new Cat();
    cat.getAge();
    cat.setAge(5);
    cat.setColor("Gray");
    cat.getName();
    cat.getColor();
    cat.setName("Pharaoh");
  }
}
