# JAVA 基础学

## 1.数据类型

* Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。

```java
byte：
byte 数据类型是8位、有符号的，以二进制补码表示的整数；
最小值是 -128（-2^7）；
最大值是 127（2^7-1）；
默认值是 0；
byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
例子：byte a = 100，byte b = -50。

short：
short 数据类型是 16 位、有符号的以二进制补码表示的整数
最小值是 -32768（-2^15）；
最大值是 32767（2^15 - 1）；
Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
默认值是 0；
例子：short s = 1000，short r = -20000。

int：
int 数据类型是32位、有符号的以二进制补码表示的整数；
最小值是 -2,147,483,648（-2^31）；
最大值是 2,147,483,647（2^31 - 1）；
一般地整型变量默认为 int 类型；
默认值是 0 ；
例子：int a = 100000, int b = -200000。

long：
long 数据类型是 64 位、有符号的以二进制补码表示的整数；
最小值是 -9,223,372,036,854,775,808（-2^63）；
最大值是 9,223,372,036,854,775,807（2^63 -1）；
这种类型主要使用在需要比较大整数的系统上；
默认值是 0L；
例子： long a = 100000L，Long b = -200000L。
"L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。

float
float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
float 在储存大型浮点数组的时候可节省内存空间；
默认值是 0.0f；
浮点数不能用来表示精确的值，如货币；
例子：float f1 = 234.5f。

double
double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；
浮点数的默认类型为double类型；
double类型同样不能表示精确的值，如货币；
默认值是 0.0d；
例子：double d1 = 123.4。

boolean：
boolean数据类型表示一位的信息；
只有两个取值：true 和 false；
这种类型只作为一种标志来记录 true/false 情况；
默认值是 false；
例子：boolean one = true。

char：
char类型是一个单一的 16 位 Unicode 字符；
最小值是 \u0000（即为0）；
最大值是 \uffff（即为65,535）；
char 数据类型可以储存任何字符；
例子：char letter = 'A';。

```

## 2.逻辑控制

* if...else... , switch , while , for

```java

//if..else...
if(表达式)else{}

// switch伪代码
switch( [ String, Char, int, 枚举类型 ] ){
    case 条件:
    break ;
    default:
    break;
}

//while do...while
while(表达式){}

do{}while(表达式);

// 循环控制
break；
continue；

```

## 3.方法

* 在主类中定义并由主类调用的方法

```java
public static 返回值类型[无返回值用void] 方法名 ([参数类型 变量名,....]){
    ...
    [return [返回值];]
}

```

* 方法重载
  * 方法名称必须相同。

  * 参数列表必须不同。

  * 方法的返回类型可以相同也可以不相同。

  * 仅仅返回类型不同不足以称为方法的重载。

```java
public class Demo {
    //一个普通得方法，不带参数，无返回值
    public void add(){
        //method body
    }

    //重载上面的方法，并且带了一个整形参数，无返回值
    public void add(int a){
        //method body
    }

    //重载上面的方法，并且带了两个整型参数，返回值为int型
    public int add(int a,int b){
        //method body
        return 0;
    }

```

## 4.面向对象

* 封装性

* 继承性

* 多态性（多种数据类型）

```java

OOA:面向对象分析
OOD:面向对象设计
OOP:面向对象编程

```

### 4.1对象的定义

* 声明并实例化对象：类名称 对象名称 = new 类名称()；
* 分步完成
  * 类名称 对象名称 = null ;
  * 对象名称 = new 类名称();
* 对象调用
  * 对象.属性；
  * 对象.方法()；

```java

class Person {
    String name;
    int age;
    public void say(){
        System.out.println("name="+name+" age="+ age);
    }
}

public class JavaDemo {
    public static void main(String[] args){
        //声明并实例化对象
        Person person = new Person();
        person.say();//name=null age=0
        person.name = "张三";
        person.age = 18;
        person.say();//name=张三 age=18
        //方法二
        Person person1 = null;
        person1 = new Person();
    }
}

```

### 4.2对象与内存分析

* <font color='red'>堆内存：保存对象的具体信息，在程序中堆内存的空间开辟是通过new完成的</font>

* <font color='red'>栈内存：保存一块堆内存的地址，即通过地址找到堆内存，而后找到对象内容。基本类型也保存在栈内存中</font>

<!-- ![tu]('/img/obj.jpg') -->

### 4.3内存的引用传递

* 同一块堆内存可以被不同的栈内存引用，也可以更换引用的栈内存

### 4.4 类成员属性的封装

* 在类外部可以调用并赋值。会造成属性不安全，需要室使用<font color='red'><b>private</b></font>关键字对属性进行封装处理.
* 属性封装后外部不能直接访问,对类的内部是可见的.
* 使用 <font color='red'><b>setter</b></font>或<font color='red'><b>getter</b></font>方法。

  * 设置属性 setXxx();例如 public Void setName(String n);
  * 获取属性 getXxx();例如 public getName()；
* <font color='red'><b>类中的大部分属性都要用private封装，需要访问就要有setter和getter方法。</b></font>

```java

//未封装
public class Person{
    String name;
    int age;
    public void tell(){
        System.out.print("name="+name+" age="+age);
    };
}

public class JavaDemo{
    //主函数
    public static void main(String[] args){
        Person person = new Person();
        person.name = "张三";
        person.age = 18;
        person.tell();
    }
}

// 使用private封装

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
		System.out.print("name=" + name + " age=" + age);
	};
}

public class JavaDemo{
    //主函数
    public static void main(String[] args){
        Person person1 = new Person1();
        person1.setName("张三");
        person1.setAge(18);
        person1.tell();
    }
}

```

### 4.5构造方法与匿名对象

* 构造方法：<font color='red'>可以通过构造方法实现实例化对象中的属性初始化</font>

* java中的构造方法：
  * 构造方法名称必须与类名称保持一致。
  * 构造方法不允许设置任何返回值类型，即:没有返回值定义
  * 构造方法是在使用关键字new实例化对象时自动调用的

* 构造方法重载，可以按照参数的个数排列。
* 构造方法是实例化时候初始属性值，setter可以设置属性值也可以修改属性值

* 构造方法为什么不允许设置任何返回值类型或viod
  * 如果有void或返回值结构就与普通函数完全相同，编译器无法区分,构造方法与普通方法最大的区别在于，一个是实例化时候调用，一个是实例化后调用。

```java

class Person {
    private String name;
    private int age;
    // 方法名称与类名称相同
    public Person(String n , int a){//定义有参构造
        name = n;
        age = a;
    };
    public static void tell(){
        System.out.println("hello");
    };
    public String getName() {
        return name;
    }
}

public class JavaDemo{
    public static void main(String[]arg){
        Person per = new Person("ZhangSan",14);
        per.getName()//ZhangSan
    }
}

```

* 匿名对象：使用一次后，将被GC回收♻️。
* 只要是方法就可以传递任意数据类型。

```java
new Person("李四",18).getName();//李四
```

## 5.this关键字

* this上下文执行环境
  * 当前类中的属性：this.属性；
  * 当前类中的方法：this.方法名()，this()调用构造方法;
  * this描述当前的对象

```java

class Person{
    private String name;
    private int age;
    public void setName(String namen){
        this.name=name;
    };
    public String getName(){
        return this.name;
    };

    public Person(String name, int age){
        this.setName(name);//this.name = name;
        this.age = age;
    };

}

public class JavaDemo{
    public static void main(String[]arg){
        Person per = new Person("张三",12);
    }
}

```

* this()的使用。实现代码复用。如多构造函数中.
  * 构造方法必须在实例化新对象的时候调用，所以this()的语句只允许出现在构造方法的首行。

```java

class Person{
    private String name;
    private int age;

    //无参数
    public Person(){
        System.out.println("一个新的实例对象生成");
    };

    // 单参数
    public Person(String name){
        this();//调用无参数
        this.name = name;
    };
    // 双参数
    public Person(String name, int age){
        this(name);//调用单参数
        this.age = age;
    };

    public void setName(String namen){
        this.name=name;
    };
    public String getName(){
        return this.name;
    };


}

public class JavaDemo{
    public static void main(String[]arg){
        Person per = new Person("张三",12);
    }
}

```

```java
//联系构造方法互相调用
class Emp{
    private String empName;
    private int empNo;
    private String empGroup;
    private double empSalary;

    public Emp(){
        this("无名氏",1000,null);
    }

    public Emp(String empName, int empNo, String empGroup){
        this(enpName,empNo,empGroup,2500.00);
    }

    public Emp(Sting empName, int empNo, String empGroup, double empSalary ){
        this.empName = empName;
        this.empNo = empNo;
        this.empGroup = empGroup;
        this.empSalary = empSalary;
    }

}

```