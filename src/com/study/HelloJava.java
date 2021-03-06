package com.study;

public class HelloJava {
	public static void main(String[] args) {
		// System.out.println("Hello Java");
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;
		System.out.println(maxValue + 1);// 数据溢出
		long result = maxValue;
		System.out.println(result + 1); // long + int 1 = long 结果正常
		// 方法二
		long res = (long) maxValue + 1;
		System.out.println(res); // 结果正常
		// 大的数据类型转换为小的数据类型 需要强制转换 如 long -》 int
		// long num = 2147483648; //超出范围 数字默认是int型
		long num = 2147483648L; // 加L||l 代表long型
		System.out.println(num);
		int intNum = (int) num; // 强制转化
		System.out.println(intNum);
		int num1; // 未初始化赋值的变量会使用报错
		// int num2 = num1 +1 ;
		// System.out.println(num1 +0);
		// 浮点数 默认是double 使用float 需要强制转换
		float f1 = 1.1F;
		float f2 = 1.1f;
		float f3 = (float) 1.1;
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		boolean bool = false;
		System.out.println(0 == 0);
		// 字符
		char c = 'c'; // char 字符类型 单引号
		// 字符串
		String str = "asd"; // String 字符串使用双引号

		System.out.println(c);
		System.out.println(2 & 4);
		// 2 010
		// 4 100
		// 2 & 4 000
		// for (int x = 1; x < 10; x++) {
		// for (int y = 1; y <= x; y++) {
		// int z = x * y;
		// System.out.print(x + "*" + y + "=" + z+" ");
		// }
		// System.out.println();
		// }
		printMessage();
		printMessage1(11);

		Person person = new Person();
		person.say();
		person.name = "张三";
		person.age = 18;
		person.say();
		Person1 person1 = new Person1();
        person1.setName("张三pervaite");
        person1.setAge(-18);
        person1.tell();
        
        Person2 per2 = new Person2("lili",12);
        System.out.println(per2.getName());
        Dept dept = new Dept(12345L,"北京部门","北京");
        System.out.println(dept.getInfo());
	};

	public static void printMessage() {
		System.out.println("在主类中定义并由主类调用的方法-无参数无返回值");
	};

	public static String printMessage1(int num) {
		System.out.println("在主类中定义并由主类调用的方法-有参数有返回值,num=" + num);
		return "返回值" + num;

	};

}
class Dept { //类名称描述明确的某类事物
    private long deptno;
    private String deptname;
    private String loc;
    public Dept(){}//必须要提供有无参构造
    public Dept(long deptno, String deptname, String loc){
        this.deptno = deptno;
        this.deptname = deptname;
        this.loc = loc;
    }
    public void setDeptNo(long deptno){
        this.deptno = deptno ;
    }
    public void setDeptName(String deptname){
        this.deptname = deptname;
    }
    public void setLoc(String loc){
        this.loc = loc;
    }
    public long getDeptNo(){
        return this.deptno;
    }
    public String getDeptName(){
        return this.deptname;
    }
    public String getLoc(){
        return this.loc;
    }
    public String getInfo(){
        return "【部门信息】:"+"部门名称:"+this.deptname+"、部门编号"+this.deptno+"、部门位置"+this.loc;
    }

}

class Person2 {
	private String name;
    private int age;
    // 方法名称与类名称相同
    public Person2(String name , int age){//定义有参构造
        this.name = name;
        this.age = age;
    };
    public static void tell(){
        System.out.println("hello");
    };
    public String getName() {
    	System.out.println(this);
    	return this.name;
    }
}
class Person {
	String name;
	int age;

	public void say() {
		System.out.println("name=" + name + " age=" + age);
	}
}

class Person1 {
	private String name;
	private int age;

	public void setName(String a) {
		name = a;
	};

	public void setAge(int age1) {
		age = age1;
	};

	public String getName() {
		return name;
	};

	public int getAge() {
		return age;
	};

	public void tell() {
		System.out.println("name=" + name + " age=" + age);
	};
}
