class Outer { 
    private String name = "outer";

    //无法再外部实例化 Inner类
    private class Inner {
        private String name = "inner";

        public void print() {
            System.out.println(Outer.this.name);
        }
    }
}

public class JavaDemo24 {
    public static void main(String[] args) {
        // 先实例化Outer 才能访问 Outer的非静态属性
        Outer.Inner in = new Outer().new Inner();
        in.print();
        // JavaDemo24.java:16: 错误: Outer.Inner 在 Outer 中是 private 访问控制
        // Outer.Inner in = new Outer().new Inner();
        // ^
        // JavaDemo24.java:16: 错误: Outer.Inner 在 Outer 中是 private 访问控制
        // Outer.Inner in = new Outer().new Inner();
    }
}