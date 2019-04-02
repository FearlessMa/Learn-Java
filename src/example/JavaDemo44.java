
public class JavaDemo44 {
    // private static String str = "hello";
    private static StringBuffer buf = new StringBuffer("hello");

    public static void main(String[] args) {
        // concat(str);
        concat(buf);
        // System.out.println(str); //hello
        System.out.println(buf); //hello word
    }

    private static void concat(String temp) {
        temp += "word";
    }
    private static void concat(StringBuffer temp) {
        temp.append( " word");
    }

}