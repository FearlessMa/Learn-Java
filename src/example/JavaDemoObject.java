class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name :" + this.name + "、age:" + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) { // 不是本类 实例
            return false;
        }
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Person per = (Person) obj;
        return this.name == per.name && this.age == per.age;
    }
}

public class JavaDemoObject {
    public static void main(String[] args) {

        Person perA = new Person("张三", 18);
        Person perB = new Person("张三", 18);
        System.out.println(perA.equals(perB)); //true
        System.out.println(perA.equals(perA)); //true
        System.out.println(perA.equals(null)); //false
        System.out.println(perA.equals("其他类"));//false
        // Person per = new Person("张三", 18);
        // System.out.println(per); // name :张三、age:18

        // Object obj = new int[] { 1, 2, 3 }; // 向上转型
        // if (obj instanceof int[]) {
        // int[] arr = (int[]) obj; // 向下转型
        // for (int item : arr) {
        // System.out.println(item);
        // }
        // }
    }
}