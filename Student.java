// Student.java
public class Student extends Human {
    private String major;

    public Student() {
        super();
        major = "no major";
    }

    public Student(String str, int n, String m) {
        super(str, n);
        major = m;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String m) {
        major = m;
    }

    public void greeting() {
        System.out.println("Hello, I am a Student, and my name is " + getName());
    }
}