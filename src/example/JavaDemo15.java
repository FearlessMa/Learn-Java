
public class JavaDemo15 {
    public static void main(String[] args) {
        Integer[] num = fun(1, 2, 3);
        for (int item : num) {
            System.out.println(item);
        }
    }

    public static <T> T[] fun(T... args) {
        return args;
    }
}