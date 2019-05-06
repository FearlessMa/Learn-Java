
class Channel {
    private static final ThreadLocal<Message> THREADLOCAL = new ThreadLocal<>();

    private Channel() {
    }

    public static void setMessage(Message m) {
        THREADLOCAL.set(m);;
    }

    public static void send() {
        System.out.println(Thread.currentThread().getName() + "-" + THREADLOCAL.get().getInfo());
    }
}

class Message {
    private String info;

    /**
     * @param message the message to set
     */
    public void setInfo(String message) {
        this.info = message;
    }

    /**
     * @return the message
     */
    public String getInfo() {
        return info;
    }
}

public class JavaDemo54 {
    public static void main(String[] args) {
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("message1");
            Channel.setMessage(msg);
            Channel.send();// message
        }, "线程A").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("message2");
            Channel.setMessage(msg);
            Channel.send();// message
        }, "线程B").start();
        new Thread(() -> {
            Message msg = new Message();
            msg.setInfo("message3");
            Channel.setMessage(msg);
            Channel.send();// message
        }, "线程C").start();
        // 线程B-message2
        // 线程A-message2
        // 线程C-message3
    }
}