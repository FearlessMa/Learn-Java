
interface ISendMessage {
    static interface IChannel {
        public Boolean connect();
    }

    static interface IMessage {
        public void message();
    }

    public static void send(IChannel ic, IMessage msg) {
        if (ic.connect()) {
            msg.message();
        } else {
            System.out.println("链接失败");
        }
    }
}

class SendMessageImpl implements ISendMessage.IMessage, ISendMessage.IChannel {
    @Override
    public Boolean connect() {
        return true;
    }

    @Override
    public void message() {
        System.out.println("链接成功，发送消息");
    }
}

public class JavaDemo27 {
    public static void main(String[] args) {
        SendMessageImpl sendMsg = new SendMessageImpl();
        ISendMessage.send(sendMsg, sendMsg);//链接成功，发送消息
    }
}