import java.util.*;

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class JavaDemo55 {
    public static void main(String[] args) {
        // Timer t = new Timer();
        // TimerTask ts = new MyTimerTask();
        // t.scheduleAtFixedRate(ts, 500, 500);
        String str1 = "abc";
        String str = "测试信息" + "{" + str1 + "}";
        byte[] b = Base64.getEncoder().encode(str.getBytes());
        String bStr = new String(b);
        System.out.println(bStr);// 5rWL6K+V5L+h5oGv
        byte[] res = Base64.getDecoder().decode(bStr);
        System.out.println(new String(res));
        // 5rWL6K+V5L+h5oGv
        // 测试信息
    }
}