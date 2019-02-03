
class Person {
    private String name;
    private String addr;
    private String sex;
    private int age;

    public Person() {
        this("1", "1", "1", 1);
    }

    public Person(String name, String addr, String sex, int age) {
        this.name = name;
        this.addr = addr;
        this.sex = sex;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("name = " + this.name + "addr = " + this.addr + "sex= " + this.sex + "age=" + this.age);
    }
}

class Student extends Person {
    private double math;
    private double english;

    public Student() {
        this(0.00, 0.00);
    }

    public Student(double math, double english) {
        super();
        this.math = math;
        this.english = english;
    }

    public Student(String name, String addr, String sex, int age, double math, double english) {
        super(name, addr, sex, age);
        this.math = math;
        this.english = english;
    }

    public void getInfo() {
        super.getInfo();
        System.out.println("override");
    }

}

public class Exercise {
    public static void main(String[] args) {
        Student stu = new Student("ma","bj","man",1,100.00,0.00);
        stu.getInfo();
    }
}