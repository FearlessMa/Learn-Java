interface IMessage{
    public String message();
    public default boolean connect(){
        System.out.println("接口中的普通方法要用default修饰");
        return true;
    }

    public static String getInfo(){
        return "接口的static方法";
    }
}

class MessageImpl implements IMessage{
    @Override
    public String message(){
        return "message";
    }
}

public class JavaDemo08{
    public static void main(String [] args){
        IMessage msg = new MessageImpl();
        if(msg.connect()){
            System.out.println(msg.message());
        }
        System.out.println(IMessage.getInfo());
        // 接口中的普通方法要用default修饰
        // message
        //接口的static方法
    }
}