public class Car {
    // Properties
    private String make;
    private String model;
    private int year;

    public Car(){
        make = "no make";
        model = "no model";
        year = 0;
    }

    // Constructor
    public Car(String m, String mo, int y) {
        make = m;
        model = mo;
        year = y;
    }

    // Methods
    public void startEngine() {
        System.out.println("Starting engine...");
    }

    public void stopEngine() {
        System.out.println("Stopping engine...");
    }

    public void drive() {
        System.out.println("Driving...");
    }

    // Getter and Setter methods
    public String getMake() {
        return make;
    }

    public void setMake(String m) {
        make = m;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String mo) {
        model = mo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int y) {
        year = y;
    }
}
