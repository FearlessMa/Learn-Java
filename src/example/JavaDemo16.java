
// enum Color {// 枚举
//     RED, GREEN, BLUE;
// }
// interface IMessage {
//     public String message();
// }

// enum Color implements IMessage {
//     RED("红色"), GREEN("绿色"), BLUE("蓝色");
//     private String title;

//     private Color(String color) {
//         this.title = color;
//     }

//     @Override
//     public String toString() {
//         return this.title;
//     }

//     @Override
//     public String message() {
//         return this.title;
//     }
// }

enum AsColor {
    RED("红色") {
        public String getMessage() {
            return this.toString();
        }
    },
    GREEN("绿色") {
        public String getMessage() {
            return this.toString();
        }
    },
    BLUE("蓝色") {
        public String getMessage() {
            return this.toString();
        }
    };
    private String title;

    private AsColor(String color) {
        this.title = color;
    }

    @Override
    public String toString() {
        return this.title;
    }

    public abstract String getMessage();
}

public class JavaDemo16 {
    public static void main(String[] args) {
        AsColor c = AsColor.RED;
        System.out.println(c.getMessage());//红色
        // Color r = Color.RED; // 获取实例化对象
        // System.out.println(r);
        // IMessage msg = Color.RED;
        // System.out.println(msg.message());// 红色
        // for (Color c : Color.values()) {
        // // System.out.println(c);
        // // RED
        // // GREEN
        // // BULE
        // // switch (c) {
        // // case RED:
        // // System.out.println("红色");
        // // break;
        // // case GREEN:
        // // System.out.println("绿色");
        // // break;
        // // case BLUE:
        // // System.out.println("蓝色");
        // // break;
        // // }
        // // 红色
        // // 绿色
        // // 蓝色
        // System.out.println(c.ordinal() + "-" + c.name() + "-" + c);
        // // 0-RED-红色
        // // 1-GREEN-绿色
        // // 2-BLUE-蓝色
        // }
    }
}