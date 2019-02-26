interface IMessage<T> {
    public String echo(T t);
}

class MessageImpl implements IMessage<String> {
    @Override
    public String echo(String t) {
        return "【echo】" + t;
    }
}

public class JavaDemo14 {
    public static void main(String[] args) {
        IMessage<String> msg = new MessageImpl();
        System.out.println(msg.echo("123"));
    }
}