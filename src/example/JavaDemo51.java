import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaDemo51 {

    public static void main(String[] args) {
        // String str = "12";
        // System.out.println(isDouble(str));
        // if (isDouble(str)) {
        // double num = Double.parseDouble(str);
        // System.out.println(num);
        // }

        // String dStr = "2019-04-23 21:12:12";
        // System.out.println(isDate(dStr));
        // if (isDate(dStr)) {
        // try {
        // Date d = new SimpleDateFormat("yyyy-MM-dd").parse(dStr);
        // System.out.println(d);
        // } catch (Exception e) {
        // }
        // }

        // String pNum = "(010)-60451234";
        // String regex = "(010|\\(010\\)-)?\\d{8}";
        // System.out.println(pNum.matches(regex));

        // String strs = "ajdadh^*&@$%YGDGA*&@h320";
        // Pattern p = Pattern.compile("[^a-zA-Z]+");
        // String[] s = p.split(strs);
        // for (String item : s) {
        // System.out.print(item + "、");
        // }
        // // ajdadh、YGDGA、h、

        // String m = "123";
        // String regexM = "\\d+";
        // Pattern pm = Pattern.compile(regexM);//编译正则表达式
        // Matcher mat = pm.matcher(m);
        // System.out.println(mat.matches());//true

        // 要求取出#{内容} 标记中所有内容
        String str = "INSERT INTO dept(deptno,dname,loc) VALUES (#{deptno},#{dname},#{loc})";
        String regex = "#\\{\\w+\\}";
        Pattern p = Pattern.compile(regex); // 编译正则表达式
        Matcher mat = p.matcher(str);
        while (mat.find()) {// 是否有匹配成功的内容
            System.out.println(mat.group(0).replaceAll("#|\\{|\\}", ""));// 分组输出
        }
        // deptno
        // dname
        // loc

    }

    public static Boolean isDate(String str) {
        String regex = "\\d{4}-([0]\\d|[1][0-2])-([0-1]\\d|[2][0-8]|[3][0-1])\\s{1}([01]\\d|[2][0-4])(:[0-5]\\d){2}";
        return str.matches(regex);
    }

    public static Boolean isDouble(String str) {
        // String regex = "\\d+[.]?\\d+";
        String regex = "\\d+([.]\\d+)?";
        return str.matches(regex);
    }
}