//错误: 无法为最终变量NAME分配值
//this.NAME = "change";
class Channel{
    private final String NAME = "Channel";
    public void connect(){
        this.NAME = "change";
    }
}
    //错误: DatabaseChannel中的connect()无法覆盖Channel中的connect()
    //public void connect(){
    //             ^
    //被覆盖的方法为final
class DatabaseChannel extends Channel{
    public void connect(){
        
    }
}
public class JavaDemoFinal{
    public static void main(String [] args){

    }
}