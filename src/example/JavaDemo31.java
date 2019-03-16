import java.util.function.*;

@FunctionalInterface
// P 参数 R 返回值
interface IFunction<P, R> {
    public R change(P p);
}

@FunctionalInterface
interface IUpper<R> {
    public R upper();
}

@FunctionalInterface
interface ICompare<P> {
    public int comp(P p1, P p2);
}

@FunctionalInterface
interface ICreate<R, P1, P2> {
    public R create(P1 p1, P2 p2);
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "name = " + this.name + "age = " + this.age;
    }
}

public class JavaDemo31 {
    public static void main(String agrs[]) {
        // IFunction<Integer,String> fun = String::valueOf;
        // String c = fun.change(100);
        // System.out.println( c + " 、" + c.length());
        // IUpper<String> u = "upper"::toUpperCase;
        // System.out.println(u.upper());//UPPER

        // ICompare<String> p = String::compareTo;
        // System.out.println(p.comp("A", "a")); // -32

        // ICreate<Person, String, Integer> p1 = Person::new;
        // Person per = p1.create("张三", 12);
        // System.out.println(per.toString()); //name = 张三age = 12

        // 使用 public boolean startsWith​(String prefix)
        // Function<String, Boolean> f = "**start"::startsWith;
        // System.out.println(f.apply("**")); //true

        // Consumer<String> pri = System.out::println;
        // pri.accept​("Consumer"); //Consumer

        // Supplier<String> sup = "AAA"::toLowerCase;
        // System.out.print(sup.get()); //aaa

        Predicate<String> pre = "aaa" :: equalsIgnoreCase;
        System.out.println(pre.test("AAA"));//false
    }
}