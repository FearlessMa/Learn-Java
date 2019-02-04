# Annotation注解

* jdk1.5之后提出的一个新的开发技术结构。利用Annotation可以有效的减少程序配置代码，并且可以利用Annotation进行一些结构化的定义Annotaion是以一种注解的形式实现的程序开发。
    * 程序开发 三个阶段
        * 阶段一 ： 在程序定义的时候将所有可能使用到的资源全部定义在程序代码之中——维护不方便
        * 阶段二 ： 引入配置文件，在配置文件中配置全部的要使用配置的服务器资源——在配置项不多时方便使用，配置文件过多会引起问题。
        * 阶段三 ： 将配置信息重新写回到程序里，利用一些特殊的标记与程序代码进行分离。——注解的作用，全部使用注解开发难度过高。
    * 现在阶段开发是配置文件与注解一起使用。
    * java的基本注解：
        * @Override : 准确覆写
        * @Deprecated :过期声明
        * @SuppressWarnings: 压制警告

* @Override(准确覆写)
    * 覆写：发现父类功能不足时，在子类中重写父类中同名方法
        * 问题一： 覆写父类方法忘记extends 继承父类,代码编译不会报错
        * 问题二： 方法名写错。
    * 为了防止以上问题，可以使用注解
    * 注解在程序编译的时候检查出程序的错误。
    ```java
        class Channel {
            public void connect(){
                System.out.println("channel 的父类 的链接");
            }
        }

        class DataBaseChannel extends Channel{
            //覆写
            @Override //明确表示覆写方法
            public void connect(){
                System.out.println("DataBaseChannel 进行数据库连接");
            }
        }
        public class JavaDemo {
            public static void main(String [] args ){
                DataBaseChannel dbChannel = new DataBaseChannel();
                dbChannel.connect();
            }
        }
    ```
* @Deprecated (过期操作)
    * 在项目开发迭代过程中，可能有一个方法或类考虑不周，导致新版本会有不适用。老版本无影响，需要一个过渡时间，采用过期声明。老系统会使用，新功能不建议使用
    ```java
        class Channel {
            @Deprecated //老系统会使用，新功能不建议使用
            public void connect(){
                System.out.println("channel 的父类 的链接");
            }
        }

        public class JavaDemo {
            public static void main(String [] args ){
                new Channel().connect(); //channel 的父类 的链接
            }
        }
    ```
* @SuppressWarnings (压制警告)

    * 不出现md编译的警告提示