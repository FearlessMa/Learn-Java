class Message<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}

public class JavaDemo13 {
    public static void main(String args[]) {
        Message<String> c = new Message<String>();
        c.setContent("content");
        fun(c);
        // Message<Integer> d = new Message<Integer>();
        // d.setContent(111);
        // fun(d);
    }

    public static void fun(Message<? super String> temp) {
        System.out.println(temp.getContent());
    }
}