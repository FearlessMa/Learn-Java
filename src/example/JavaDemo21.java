public class JavaDemo21 {
    public static void main(String[] args) {
        try {
            throw new Exception("手动抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // java.lang.Exception: 手动抛出异常
        // at JavaDemo21.main(JavaDemo21.java:4)
    }
}