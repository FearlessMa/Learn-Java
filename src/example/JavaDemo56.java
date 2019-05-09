
import java.util.Arrays;
import java.util.Comparator;

// class Person implements Comparable<Person> {
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + this.name + "、age:" + this.age;
    }

    public int getAge() {
        return age;
    }

    // @Override
    // public int compareTo(Person p) {
    // return p.age - this.age;
    // }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person p, Person p2) {
        return p.getAge() - p2.getAge();
    }
}

public class JavaDemo56 {
    public static void main(String[] args) {
        // 对象数组
        // Integer data[] = new Integer[] { 10, 2, 5, 3, 9 };
        // String data[] = new String[] { "23", "3", "9", "1" };
        Person data[] = new Person[3];
        data[0] = new Person("张三", 32);
        data[1] = new Person("李四", 11);
        data[2] = new Person("王五", 22);
        // 对象数组排序
        Arrays.sort(data,new PersonComparator());
        System.out.println(Arrays.toString(data));
        // [name:李四、age:11, name:王五、age:22, name:张三、age:32]

        // Exception in thread "main" java.lang.ClassCastException: class Person cannot
        // be cast to class java.lang.Comparable (Person is in unnamed module of loader
        // 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
        // at
        // java.base/java.util.ComparableTimSort.countRunAndMakeAscending(ComparableTimSort.java:320)
        // at java.base/java.util.ComparableTimSort.sort(ComparableTimSort.java:188)
        // at java.base/java.util.Arrays.sort(Arrays.java:1249)
        // at JavaDemo56.main(JavaDemo56.java:24)
    }
}