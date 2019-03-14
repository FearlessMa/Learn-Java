
interface IChannel {
    public void send(IMessage msg);

    interface IMessage {
        public String getConnect();
    }
}

class ChannelImpl implements IChannel {
    public void send(IMessage msg) {
        System.out.println("send " + msg.getConnect());
    }

    class MessageImpl implements IMessage {
        public String getConnect() {
            return "connect";
        }
    }
}

public class JavaDemo25 {
    public static void main(String[] args) {
        IChannel ch = new ChannelImpl();
        ch.send(((ChannelImpl) ch).new MessageImpl()); // send connect
        // ((ChannelImpl) ch) -> new ChannelImpl()
        // ((ChannelImpl) ch).new MessageImpl() -> ChannelImpl.MessageImpl msg1 = new ChannelImpl().new MessageImpl();
        ChannelImpl.MessageImpl msg1 = new ChannelImpl().new MessageImpl();
        ch.send(msg1);//send connect
    }
}