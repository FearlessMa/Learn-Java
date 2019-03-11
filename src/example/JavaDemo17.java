enum Sex {
    MAN("男"), FEMALE("女");
    private String title;

    private Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}

class Person {
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age + "、性别：" + this.sex;
    }
}

public class JavaDemo17 {
    public static void main(String[] args) {
        Person p = new Person("张三", 20, Sex.MAN);
        System.out.println(p.toString());
        //姓名：张三、年龄：20、性别：男
    }
}