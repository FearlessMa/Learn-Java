
class BombException extends Exception {
    public BombException(String msg) {
        super(msg);
    }
}

class Food {
    public static void eat(int num) throws BombException {
        if (num > 10) {
            throw new BombException("吃多了");
        }
        {
            System.out.println("正常");
        }
    }
}

public class JavaDemo22 {
    public static void main(String[] args) throws Exception {
        Food.eat(11);
        // Exception in thread "main" BombException: 吃多了
        // at Food.eat(JavaDemo22.java:11)
        // at JavaDemo22.main(JavaDemo22.java:21)
    }
}