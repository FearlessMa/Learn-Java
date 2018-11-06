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
	};

	public static void printMessage() {
		System.out.println("在主类中定义并由主类调用的方法-无参数无返回值");
	};

	public static String printMessage1(int num) {
		System.out.println("在主类中定义并由主类调用的方法-有参数有返回值,num=" + num);
		return "返回值" + num;

	};

}

class Person {
	String name;
	int age;

	public void say() {
		System.out.println("name=" + name + "age=" + age);
	}
}
