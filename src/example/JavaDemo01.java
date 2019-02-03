
class Channel {
    String info = "Channel";
    public void connect(){
        System.out.println("channel 的父类 的链接");
    }
}

class DataBaseChannel extends Channel{//子类 连接
    String info = "DataBaseChannel";
    public String getParentClassInfo(){
        return super.info;
    }
    public void connect(){
        super.connect();
        System.out.println("DataBaseChannel 进行数据库连接");
    }
}

public class JavaDemo01 {
    public static void main(String [] args){
        DataBaseChannel dbChannel = new DataBaseChannel();
        System.out.println(dbChannel.info);
        //DataBaseChannel
        System.out.println(dbChannel.getParentClassInfo());
        //Channel
    }
}