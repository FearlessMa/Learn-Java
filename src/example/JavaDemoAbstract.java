abstract class Message { // 抽象类
    private String type;

    public Message (String type){
        this.type = type;
    }

    public abstract String getConnect(); // 抽象方法

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}

// 子类继承抽象类 普通方法，覆写抽象方法 新子类实例化要向上转型
class ChildMessgae extends Message {
    public ChildMessgae (String type){
        super(type);
    }
    @Override
    public String getConnect() {
        return "ChildMessgae";
    }
}

public class JavaDemoAbstract {
    public static void main(String[] args) {
        Message cldMsg = new ChildMessgae("cldMsg");
        System.out.println(cldMsg.getType());
        // ChildMessgae cldMsg = new ChildMessgae();
        // cldMsg.setType("cldMsg");
        // System.out.println(cldMsg.getType());
        // Message msg = new Message(); //Message是抽象的; 无法实例化
    }
}