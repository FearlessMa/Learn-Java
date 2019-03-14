
interface IChannel {
    public void send();

    class ChannelImpl implements IChannel {
        public void send() {
            System.out.println("send");
        }
    }

    public static ChannelImpl getInstance() {
        return new ChannelImpl();
    }
}

public class JavaDemo26 {
    public static void main(String[] args) {
        IChannel.getInstance().send();
    }
}