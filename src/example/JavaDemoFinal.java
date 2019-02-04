// //错误: 无法为最终变量NAME分配值
// //this.NAME = "change";
// class Channel{
//     private final String NAME = "Channel";
//     public void connect(){
//         this.NAME = "change";
//     }
// }
//     //错误: DatabaseChannel中的connect()无法覆盖Channel中的connect()
//     //public void connect(){
//     //             ^
//     //被覆盖的方法为final
// class DatabaseChannel extends Channel{
//     public void connect(){

//     }
// }
class Channel {
    public void connect(){
        System.out.println("Channel");
    }
}

class DatabaseChannel extends Channel {
    public void connect() {
        System.out.println("DatabaseChannel");
    }
}
class WebServerChannel extends Channel {
    public void connect() {
        System.out.println("WebServerChannel");
    }
}

public class JavaDemoFinal {
    public static void main(String[] args) {

        fun(new DatabaseChannel()); //DatabaseChannel
        fun(new WebServerChannel()); //WebServerChannel
    }
    //fun 接收一个类参数，都被向上转型为父类
    public static void fun(Channel channel){
        channel.connect();
    }
}