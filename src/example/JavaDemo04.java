class IntClass {
    private int data = 10 ;
    public void setData(int data){
        this.data = data ;
    }
    public int getData(){
        return this.data;
    }
}

public class JavaDemo04{
    public static void main(String [] args){
        Object obj = 19.2 ; //自动装箱为Double，在向上转型为Object
        double num = (Double) obj ; //向下转型为Double，在自动拆箱
        System.out.println(num*2); //38.4

        // Integer obj = 10; //自动装箱
        // int num =obj;   //自动拆箱
        // obj++ ; //包装类对象可以直接参与数学运算
        // System.out.println(num * obj); //包装类对象可以直接参与数学运算

        // Integer intObj = new Integer(10); //装箱
        // int intObjVal = intObj.intValue();
        // System.out.println(intObjVal); //10
        // Double douObj = new Double(10.00);
        // double douObjVal = douObj.doubleValue();
        // System.out.println(douObjVal); //10.0
        // Boolean boolObj = new Boolean(true);
        // boolean boolObjVal = boolObj.booleanValue();
        // System.out.println(boolObjVal); //true

        // Object data = new IntClass(); //装箱
        // // int x = data.getData();
        // int x = ((IntClass) data ).getData(); //拆箱
        // System.out.println(x*2);
    }
}