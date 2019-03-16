
@FunctionalInterface
interface IMessage {
    public void send(String str);

    public default void print() {
        System.out.println("函数式接口要求只有一个抽象方法！");
    }
}

public class JavaDemo30 {
    public static void main(String args[]) {
        IMessage msg = str -> System.out.println("send " + str);
        msg.send("str"); // send str
        msg.print(); // 函数式接口要求只有一个抽象方法！
    }
}