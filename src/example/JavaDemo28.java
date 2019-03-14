
class Outer {
    private String name = "outer";

    public void fun(int num) {
        class Inner {
            public void print() {
                System.out.println(Outer.this.name);
                // jdk 1.8 开始支持访问参数
                System.out.println(num);
            }
        }
        new Inner().print();
    }
}

public class JavaDemo28 {
    public static void main(String[] args) {
        new Outer().fun(123);
        // outer
        // 123
    }
}