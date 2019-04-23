
public class JavaDemo50 {
    public static void main(String[] args) {
        // String str = "23456";
        // if (isNumber(str)) {
        //     int num = Integer.parseInt(str);
        //     System.out.println(num * 2);
        // }
        // if(str.matches("\\d+")){
        //     int num = Integer.parseInt(str);
        //     System.out.println(num * 2);

        // }

        // 删除非字母和数字
        String str = "as&Y(HSHLHLJAKJ^&*()#*&%$sagdadaah128763562";
        String str1 = str.replaceAll("[^a-zA-Z0-9]*","");
        System.out.println(str1);
        //asYHSHLHLJAKJsagdadaah128763562
        // 拆分字母
        String str2 = "a1b22c333d4444e55555f666666g";
        // String regex = "[^a-zA-Z]";
        // String [] arr = str2.replaceAll(regex,"").split("");
        String [] arr = str2.split("\\d+");
        for(String i : arr){
            System.out.print(i+"、");
        }
        //a、b、c、d、e、f、g、
    }

    public static Boolean isNumber(String str) {
        char[] arr = str.toCharArray();
        for (char item : arr) {
            if (item < '0' || item > '9') {
                return false;
            }
        }
        return true;
    }
}