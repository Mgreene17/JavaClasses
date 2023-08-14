// CIS365Hw2InheritanceTest.java
public class CIS365Hw2InheritanceTest{
    // main
    public static void main(String[] args){
       Student student1 = new Student();
       Student student2 = new Student("John",18,"Computer Science"); 
      
      //first print for blank student and student john
      System.out.println("Student 1: " + student1.getName() + "," + student1.getAge() + " years old, " + student1.getMajor());
      System.out.println("Student 2: " + student2.getName() + "," + student2.getAge() + " years old, " + student2.getMajor());

      //set blank student to mary,22,math
      student1.setName("Mary");
      student1.setAge(22);
      student1.setMajor("Math");
      //divider
      System.out.println("******** After change ********");
      //print mary
      System.out.println("Student 1: " + student1.getName() + "," + student1.getAge() + " years old, " + student1.getMajor());
      //get computer science from john + set to mary
      student1.setMajor(student2.getMajor());
      
      System.out.println("Student 1: " + student1.getName() + "," + student1.getAge() + " years old, " + student1.getMajor());

      student1.greeting();
  }
}