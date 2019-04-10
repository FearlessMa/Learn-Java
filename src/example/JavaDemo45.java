
interface IMessage {
    public void send();
}

class SendMessage implements IMessage, AutoCloseable {

    private String msg;

    public SendMessage(String msg) {
        this.msg = msg;
    }

    public Boolean open() {
        System.out.println("【OPEN】链接成功");
        return true;
    }

    @Override
    public void send() {
        if (this.open()) {
            System.out.println("【SEN】发送消息");
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("【CLOSE】关闭通道");
    }
}

public class JavaDemo45 {
    public static void main(String[] args) {
        try (SendMessage msg = new SendMessage("msg")) {
            msg.send();
        } catch (Exception e) {
        }
        // 【OPEN】链接成功
        // 【SEN】发送消息
        // 【CLOSE】关闭通道
    }
}