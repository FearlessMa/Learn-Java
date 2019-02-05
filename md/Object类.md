# Object类

* Object类不存在继承关系，所有类的默认父类都是Object
    * class Person {} 相当于 class Person extends Object {}
* 使用Object类可以接收所有的数据类型。

```java
    public class JavaDemoObject {
        public static void main(String[] args) {
            Object obj = new int[] { 1, 2, 3 }; //向上转型
            if (obj instanceof int[]) {
                int[] arr = (int[]) obj; //向下转型
                for (int item : arr) {
                    System.out.println(item);
                }
            }
        }
    }
```

* 获取对象信息 : toString()
    * toString方法： 可以获取对象的默认信息。输出对象(print)，默认调用toString
    * 覆写toString
    ```java
        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "name :" + this.name + "、age:" + this.age;
            }
        }
    
        public class JavaDemoObject {
            public static void main(String[] args) {
                Person per = new Person("张三", 18);
                System.out.println(per); //name :张三、age:18
            }
        }
    ```

* 对象比较 ： equals()
    * 比较两个对象的内容是否相同
    * public boolean equals​(Object obj) 默认是地址比较
    ```java
        public boolean equals(Object obj){
            return (this == obj);
        }
    ```
    * 栗子
    ```java
        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "name :" + this.name + "、age:" + this.age;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof Person)) { // 不是本类 实例
                    return false;
                }
                if (obj == null) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                Person per = (Person) obj;
                return this.name == per.name && this.age == per.age;
            }
        }

        public class JavaDemoObject {
            public static void main(String[] args) {
                Person perA = new Person("张三", 18);
                Person perB = new Person("张三", 18);
                System.out.println(perA.equals(perB)); //true
                System.out.println(perA.equals(perA)); //true
                System.out.println(perA.equals(null)); //false
                System.out.println(perA.equals("其他类"));//false
            }
        }

    ```