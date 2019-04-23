
import java.util.Date;
import java.text.SimpleDateFormat;

public class javaDemo49 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);// Tue Apr 16 22:06:55 CST 2019
        System.out.println(d.getTime());// 1555423424315
        System.out.println(d.getYear() + 1900);// 年
        System.out.println(d.getMonth() + 1);// 月
        System.out.println(d.getDate()); // 日
        // System.out.println(d.getDay());
        System.out.println(d.getHours());// 时
        System.out.println(d.getMinutes());// 分
        System.out.println(d.getSeconds());// 秒
        System.out.println((1900 + d.getYear()) + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日" + d.getHours()
                + "时" + d.getMinutes() + "分" + d.getSeconds() + "秒");
        // 2019年4月16日22时21分22秒

        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String dString = simple.format(new Date());
        System.out.println(dString);// 2019-04-16 22:41:28.726
        Date date = null;
        try {
            date = simple.parse("2019-04-16 22:41:28.726");
        } catch (Exception e) {

        }
        System.out.println(date);//Tue Apr 16 22:41:28 CST 2019

        System.out.println(date.getTime());//1555425688726

    }
}