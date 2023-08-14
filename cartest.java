public class cartest {
    public static void main(String[] args) {
        // Create a Car object
        Cars2 myCar = new Cars2("Toyota", "Camry", 2021, "v8");

        // Call methods on the Car object

        myCar.drive();
        myCar.realcar();
        System.out.println(myCar.getMake());
        myCar.setMake("2022");
        System.out.println(myCar.getMake());
        myCar.setEngine("v6");
        System.out.println(myCar.getEngine());
    }

}

  