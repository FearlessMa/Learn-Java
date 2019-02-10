
interface IMessage{
    public abstract String getInfo();
}
interface IChannel{
    public abstract boolean channel();
}
interface IServers extends IMessage,IChannel{
    public abstract String server();
}

class MessageServersImpl implements IServers{
    @Override
    public String getInfo(){
        return "MessageServersImpl";
    }
    @Override
    public boolean channel(){
        return true;
    }
    @Override
    public String server(){
        return "链接成功";
    }
}
public class JavaDemo06 {
    public static void main(String [] args){

    }
}