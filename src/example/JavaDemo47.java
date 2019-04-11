import java.lang.ref.Cleaner;
import java.lang.reflect.Constructor;

class Member implements Runnable {
    public Member() {
        System.out.println("构造方法，生成实例对象");
    }

    @Override
    public void run() {// 执行清除操作
        System.out.println("在被回时候执行输出了这句话");
    }
}

// 实现清除处理
class MemberCleaning implements AutoCloseable {
    // 创建一个清除处理
    private static final Cleaner cleaner = Cleaner.create();
    private Member member;
    private Cleaner.Cleanable cleanable;

    public MemberCleaning() {
        this.member = new Member();
        // 注册使用的对象
        this.cleanable = this.cleaner.register(this, this.member);
    }

    @Override
    public void close() throws Exception {
        // 启动多线程，进行清除的处理
        this.cleanable.clean();
    }
}

class MClone implements Cloneable {
    private String name;

    public MClone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();// 调用父类中的clone
    }
}

public class JavaDemo47 {
    public static void main(String[] args) throws CloneNotSupportedException {

        MClone mc = new MClone("mc");
        MClone cl = (MClone) mc.clone();
        System.out.println(mc);
        System.out.println(cl);
        // MClone@7960847b
        // MClone@6a6824be
        // try (MemberCleaning mc = new MemberCleaning()) {
        // } catch (Exception e) {
        // }
        // 构造方法，生成实例对象
        // 在被回时候执行输出了这句话

        // Member m = new Member();
        // // 构造方法，生成实例对象
        // m = null;
        // System.gc();
        // 手动调用gc才会输出下面内容
        // 在被回时候执行输出了这句话
    }
}