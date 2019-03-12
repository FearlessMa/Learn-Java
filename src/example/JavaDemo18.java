public class JavaDemo18 {
    public static void main(String[] args) {
        System.out.println("【1】程序开始执行");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("【2】计算x/y=" + (x / y));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("是否异常都执行");
        }
        System.out.println("【3】程序执行结束");
        // 无参数 下标越界错误 java JavaDemo18
        // 【1】程序开始执行
        // java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        // at JavaDemo18.main(JavaDemo18.java:5)
        // 是否异常都执行
        // 【3】程序执行结束

        // 参数类型错误 java JavaDemo18 a b 
        // 【1】程序开始执行
        // java.lang.NumberFormatException: For input string: "a"
        // at
        // java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        // at java.base/java.lang.Integer.parseInt(Integer.java:652)
        // at java.base/java.lang.Integer.parseInt(Integer.java:770)
        // at JavaDemo18.main(JavaDemo18.java:5)
        // 是否异常都执行
        // 【3】程序执行结束

        // java JavaDemo18 10 0
        // 【1】程序开始执行
        // java.lang.ArithmeticException: / by zero
        // at JavaDemo18.main(JavaDemo18.java:5)
        // 是否异常都执行
        // 【3】程序执行结束
    }
}