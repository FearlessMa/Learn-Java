
public class JavaDemo44 {
    // private static String str = "hello";
    private static StringBuffer buf = new StringBuffer("hello");

    public static void main(String[] args) {
        // concat(str);
        // concat(buf);
        // // System.out.println(str); //hello
        // System.out.println(buf); //hello word
        // String str = "aa" + "bb" + "cc";
        // StringBuffer str1 = new StringBuffer(str);
        // StringBuffer buf = new StringBuffer();
        // buf.append("aa").append("bb").append("cc");
        // System.out.println(str.equals(buf.toString()));
        CharSequence str = "abc"; //子类实例向父接口转型
    }

    private static void concat(String temp) {
        temp += "word";
    }

    private static void concat(StringBuffer temp) {
        temp.append(" word");
    }

}