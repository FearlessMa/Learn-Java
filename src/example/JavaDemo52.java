import java.util.Locale;
import java.util.ResourceBundle;

public class JavaDemo52 {
    public static void main(String[] args) {
        // Locale l = new Locale("zh","CN");//中文环境
        // Locale l = Locale.getDefault();//获取默认环境
        // Locale l = Locale.CHINA;//获取常量环境
        // System.out.println(l.getLanguage());//zh
        // Locale l1 = Locale.ENGLISH;//获取常量环境
        // System.out.println(l1.getLanguage());//en
        // Locale l = Locale.getDefault();
        // System.out.println(l);
        // String lan;
        // if (l.getLanguage().matches("[zh].*")) {
        //     lan = "_zh_CN";
        // } else {
        //     lan = "_en_US";
        // }
        Locale l = Locale.US;
        // .properties文件 可以在读的时候不加入文件后缀
        // 若果资源没有在包里，直接编写资源名称即可
        ResourceBundle rb = ResourceBundle.getBundle("package/word/language/message",l);
        String info = rb.getString("info");
        System.out.println(info);
        // en_US英文;
    }
}