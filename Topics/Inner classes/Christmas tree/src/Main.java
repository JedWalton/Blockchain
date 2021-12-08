class ChristmasTree {

    private String color;

    public ChristmasTree(String color) {
        this.color = color;
    }


    // create method putTreeTopper()
    public void putTreeTopper(String color) {
        ChristmasTree.TreeTopper tt = new ChristmasTree.TreeTopper(color);
        tt.sparkle();
    }

    class TreeTopper {

        private String color;

        public TreeTopper(String color) {
            this.color = color;
        }

        public void sparkle() {
            System.out.println("Sparkling " + this.color + " tree topper looks stunning with " + ChristmasTree.this.color
                    + " Christmas tree!");
        }
    }
}

// this code should work
class CreateHoliday {

    public static void main(String[] args) {

        ChristmasTree christmasTree = new ChristmasTree("green");
        christmasTree.putTreeTopper("silver");
    }
}


/*


    Vehicle car = new Vehicle();
    Vehicle.Engine motor = car.new Engine();
        motor.start();


 */