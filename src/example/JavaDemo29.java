
interface ISendMessage {
    public void send(String msg);

    public static ISendMessage getInstance() {
        return new ISendMessage() {

            @Override
            public void send(String msg) {
                System.out.println(msg);
            }
        };
    }
}

class SendMessageImpl implements ISendMessage {
    public void send(String msg) {
        System.out.println(msg);
    }
}

public class JavaDemo29 {
    public static void main(String[] args) {
        ISendMessage msg = new SendMessageImpl();
        msg.send("send"); // send
        ISendMessage msg1 = new ISendMessage() {
            public void send(String msg) {
                System.out.println(msg);
            }
        };
        msg1.send("匿名内部类"); // 匿名内部类

        ISendMessage.getInstance().send("与static结合的匿名内部类");//与static结合的匿名内部类
    }
}