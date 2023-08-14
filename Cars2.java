public class Cars2 extends Car {
    private String engine;

    public Cars2() {
        super();
        engine = "no engine";
    }
    public Cars2(String m, String mo, int y, String e) {
        super(m,mo,y);
        engine = e;
    }
    public String getEngine(){
        return engine;
    }
    public void setEngine(String e){
        engine = e;
    }
    public void realcar() {
        System.out.println("Car is" + getModel() + getMake() + getYear() + getEngine());
    }
}