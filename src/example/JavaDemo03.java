//抽象类应用 模板设计模式
// * 机器人：不休息，可工作，需要补充能量。
// * 人： 需要休息，可工作，需要补充能量。
// * 猪： 需要休息，不工作，需要补充能量.

abstract class Action {
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 10;

    // 行为操作command方法
    public void command(int code) {
        switch (code) {
        case EAT:
            this.eat();
            break;
        case SLEEP:
            this.sleep();
            break;
        case WORK:
            this.work();
            break;
        }
    }

    // 行为的抽象
    public abstract void eat();

    public abstract void sleep();

    public abstract void work();
}

class Robot extends Action {
    @Override
    public void eat() {
        System.out.println("robot充电");
    }

    @Override
    public void sleep() {
        System.out.println("robot不休息");
    }

    @Override
    public void work() {
        System.out.println("robot--start work");
    }
}

class Person extends Action {
    @Override
    public void eat() {
        System.out.println("Person 吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("Person休息");
    }

    @Override
    public void work() {
        System.out.println("Person--start work");
    }
}

class Pig extends Action {
    @Override
    public void eat() {
        System.out.println("Pig休息");
    }

    @Override
    public void sleep() {
        System.out.println("Pig睡觉");
    }

    @Override
    public void work() {
        System.out.println("Pig--not work");
    }
}

public class JavaDemo03 {
    public static void main(String[] args) {
        System.out.println("-----robot-----");
        Action robot = new Robot();
        robot.command(Action.EAT);
        robot.command(Action.SLEEP);
        robot.command(Action.WORK);
        System.out.println("-----person-----");
        Action person = new Person();
        person.command(Action.EAT);
        person.command(Action.SLEEP);
        person.command(Action.WORK);
        System.out.println("-----pig-----");
        Action pig = new Pig();
        pig.command(Action.EAT);
        pig.command(Action.SLEEP);
        pig.command(Action.WORK);

        // -----robot-----
        // robot充电
        // robot不休息
        // robot--start work
        // -----person-----
        // Person 吃饭
        // Person休息
        // Person--start work
        // -----pig-----
        // Pig休息
        // Pig睡觉
        // Pig--not work
    }
}