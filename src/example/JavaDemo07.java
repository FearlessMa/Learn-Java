class Parent {
    int a = 1;
}

class Child extends Parent{
    int a = 2;
}

public class JavaDemo07 {
    public static void main(String args []){
        Parent c = new Child();
        System.out.println(c.a);
        Child c2 = (Child) c ;
        System.out.println(c2.a);
        Child c1 = new Child();
        System.out.println(c1.a);
    }
}