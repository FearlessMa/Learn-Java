
class Parent {
    @Override
    public String toString() {
        System.out.println("parent  toString");
        return super.toString();
    }
}

class Child extends Parent {
    @Override
    public String toString() {
        System.out.println("child  toString");
        return super.toString();
    }
}

public class JavaDemo19 {
    public static void main(String [] args){
        Parent c = new Child();
        // Child c = new Child();
        // Parent p = new Parent();
        System.out.println(c.toString());
        // System.out.println(p.toString());

    }
}