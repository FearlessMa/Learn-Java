interface IFood {
    public void eat();
}

class Bread implements IFood {
    @Override
    public void eat() {
        System.out.println("吃面包");
    }
}

class Milk implements IFood {
    @Override
    public void eat() {
        System.out.println("喝牛奶");
    }
}

class Factory {
    public static IFood getInstance(String className) {
        switch (className) {
        case "bread":
            return new Bread();
        case "milk":
            return new Milk();
        default:
            return null;
        }
    }
}

public class JavaDemo10 {
    public static void main(String args[]) {
        IFood food = Factory.getInstance(args[0]);
        food.eat();
        // java JavaDemo10 milk
        // 喝牛奶
        // java JavaDemo10 bread
        // 吃面包
    }
}