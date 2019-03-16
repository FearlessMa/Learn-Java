
class Node<E> {
    private E data;
    private Node<E> next = null;

    public Node(E data) {
        this.data = data;
    };

    public E getdata() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

public class JavaDemo32 {
    public static void main(String args[]) {
        Node<String> n1 = new Node<>("n1");
        Node<String> n2 = new Node<>("n2");
        Node<String> n3 = new Node<>("n3");
        n1.setNext(n2);
        n2.setNext(n3);
        print(n1);
        // n1
        // n2
        // n3
    }

    public static void print(Node<?> node) {
        if (node.getdata() != null) {
            System.out.println(node.getdata());
        }
        if (node.getNext() != null) {
            print(node.getNext());
        }
    }
}