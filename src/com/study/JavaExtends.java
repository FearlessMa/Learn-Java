class PersonExtends {
    private String name;
    private int age;

    // public PersonExtends(String name, int age) {
    // this.name = name;
    // this.age = age;
    // }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getInfo() {
        System.out.println("name=" + this.name + "、age=" + this.age);
    }
}

class Student extends PersonExtends {
    private String school;

    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        getInfo();
        return this.school;
    }
    public Student(String name, int age, String school) {
        // super(name, age);
        this.school = school;
        setName(name);
        setAge(age);
    }
    // public Student(String school){
    //     this.school = school;
    // }

    // public void getInfo() {
    // System.out.println("school = " + this.school + "、name=" + this.name + "、age"
    // + this.age);
    // }
}

public class JavaExtends {
    public static void main(String[] args) {
        // PersonExtends per1 = new PersonExtends("name", 12);
        // per1.getInfo();
        Student std = new Student("MA",12,"school");
        // Student std = new Student("school");
        // std.setName("ma");
        // std.setAge(11);
        std.getInfo();
        // std.setSchool("school");
        System.out.println(std.getSchool());
    }

}