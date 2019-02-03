
class Channel {
    public void connect(){
        System.out.println("channel 的父类 的链接");
    }
}

class DataBaseChannel extends Channel{//子类 连接
    public void connect(){
        super.connect();
        System.out.println("DataBaseChannel 进行数据库连接");
    }
}

public class JavaDemo {
    public static void main(String [] args ){
        Channel channel = new Channel();
        channel.connect();
        DataBaseChannel dbChannel = new DataBaseChannel();
        dbChannel.connect();
    }
}