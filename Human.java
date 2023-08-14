// Human.java
public class Human {
        private String name;
        private int age;
        public Human() {
              name="no name";
              age=0;
}
public Human(String str,int n) {
name=str;
age=n;
}
public String getName() {
return name;
}
public int getAge() {
return age;
}
public void setAge(int num) {
age=num;
}
public void setName(String s) {
name=s;
}
public void greeting() {
System.out.println("Hello, I am a Human. My name is "+name);
}
}