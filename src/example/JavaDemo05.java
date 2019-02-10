
interface IMessage { // 接口名
    public static final String INFO = "info";// 全局常量

    public abstract String getInfo(); // 抽象方法
}

interface IChannel {
    public abstract boolean connect();
}

abstract class  BaseDataAbstract {
    public abstract boolean connection();
}

// implements 实现接口子类
class MessageImpl extends BaseDataAbstract implements IMessage, IChannel {
    @Override
    public String getInfo() {
        if (this.connect()) {
            return "覆写方法getInfo";
        }
        return "覆写方法getInfo成功，通道链接失败";
    }

    @Override
    public boolean connect() {
        System.out.println("通道链接成功");
        return true;
    }

    @Override 
    public boolean connection(){
        return true;
    }
}

public class JavaDemo05 {
    public static void main(String[] args) {
        // IMessage msg = new MessageImpl(); // 向上转型
        // IChannel chl = (IChannel) msg ;
        // System.out.println(chl.connect());
        // 通道链接成功
        // true
        Object msg = new MessageImpl(); // 向上转型
        System.out.println(((IMessage) msg).getInfo());
        // 通道链接成功
        // 覆写方法getInfo
    }
}