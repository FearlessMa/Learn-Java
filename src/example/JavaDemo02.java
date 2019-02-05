class Person {
    public void print(){
        System.out.println("Person");
    }
    public void fire(){
        System.out.println("fire");
    }
    public Person (){
        System.out.println("无参构造被调用");
    }
}

class SuperMan extends Person{
    public void fire(){
        System.out.println("i can fire");
    }
}

public class JavaDemo02{
    public static void main(String [] args){
        // System.out.println("-------------person-----");
        // Person per = new SuperMan(); //向上转型
        // // Person per = new Person(); //向上转型
        // per.print();
        // per.fire();
        // System.out.println("-------------向下转型称为SuperMan-----");
        // SuperMan man = (SuperMan) per; //向下转型
        // man.fire();
        System.out.println("-------------向上转型SuperMan-----");
        Person per = new SuperMan(); //向上转型
        System.out.println(per instanceof SuperMan); //true
        System.out.println(per instanceof Person); //true
        System.out.println("-------------向下转型SuperMan-----");
        SuperMan man = (SuperMan) per ;
        System.out.println(man instanceof SuperMan); //true
        System.out.println(man instanceof Person); //true
        System.out.println("-------------正常继承Person-----");
        Person per1 = new Person(); 
        System.out.println(per1 instanceof SuperMan); //false
        System.out.println(per1 instanceof Person); //true
    }
}