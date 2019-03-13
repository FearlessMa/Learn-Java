class MyMath {
    // 这里可能会产生异常，如果产生异常调用出处理
    public static int div(int x, int y) throws Exception {
        int temp = 0;
        System.out.println("计算开始");
        try {
            temp = x / y;
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("计算结束");
        }
        return temp;
    }
}

public class JavaDemo20 {
    public static void main(String[] args) throws Exception {
        System.out.println(MyMath.div(10, 0));
    }
}