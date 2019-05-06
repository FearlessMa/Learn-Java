import java.util.Optional;

// import java.util.UUID;

interface IMessage{
    public String getConnect();
}

class MessageImpl implements IMessage{
    @Override
    public String getConnect() {
        return "链接成功";
    }
}

class MessageUtil{
    private MessageUtil(){};
    //通过Optional包装对象进行对其验证
    public static  Optional<IMessage> getMessage(){
        return Optional.ofNullable(null);
    }
    public static void UseMessage(IMessage msg){
        // //预防null 自引用接收方被动进行判断
        // if(msg != null){
        //     System.out.println(msg.getConnect());
        // }

        // 使用Optional
        System.out.println(msg.getConnect());
    }
}

public class JavaDemo53{
    public static void main(String[] args) {
        // //获取UUID对象
        // UUID uid = UUID.randomUUID();
        // //输出UUID对象，默认调用toString输出字符串
        // System.out.println(uid);
        // //15f85631-b64f-4712-9e7e-e1e2e5b267d2

        //使用null会空指向异常 NullPointerException
        MessageUtil.UseMessage(MessageUtil.getMessage().orElse(new MessageImpl()));
        
    }
}