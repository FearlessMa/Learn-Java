# Math数学计算类

## Math类

* Math是提供数学计算的类，提供有基础数学计算公式和常量E，PI，Math类构造方法私有化了，该类之中的所有方法都是static方法

```java
class MathUtil {
    private MathUtil() {
    };

    // 实现四舍五入
    // num要进行操作的数字
    // scale保留的小数位数
    public static double Round(double num, int scale) {
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }
}

public class JavaDemo48 {
    public static void main(String[] args) {
        System.out.println(MathUtil.Round(19.86273, 2));
        System.out.println(MathUtil.Round(19.86573, 2));
        // 19.86
        // 19.87
    }
}
```

* Math里提供的都是基础的数学公式，需要更多的计算需要自己重新整合。

## 课时34 Random随机数生成类

* 生成随机数，主要依靠内部提供的方法来完成

    * 重点方法 (不大于边界的正整数)：public int nextInt​(int bound)

```java

import java.util.Random;

class MathUtil {
    private MathUtil() {
    };

    // 生成随机数 通过 java.util.Random 实现 包含0单不大于num
    public static int[] MathNextInt(int num, int count) {
        int[] intArr = new int[count];
        Random rm = new Random();
        for (int i = 0; i < count; i++) {
            intArr[i] = rm.nextInt(num);
        }
        return intArr;
    }
}

public class JavaDemo48 {
    public static void main(String[] args) {
        int[] arr = MathUtil.MathNextInt(10, 10);
        for (int num : arr) {
            System.out.print(num + "、");
        }
        // 3、5、2、3、4、3、7、8、9、9、
    }
}
```

* 36选7不重复

```java

import java.util.Random;

class RandomNSelectM {

    private int[] arr;
    private int max;
    private int count;
    private int index;

    public RandomNSelectM(int max, int count) {
        this.count = count;
        this.arr = new int[count];
        this.max = max;
    }

     public int[] newRandom() {
        Random rn = new Random();
        while (this.index  < this.count) {
            int num = rn.nextInt(this.max) + 1;
            if (this.isUse(num, this.arr)) {
                this.arr[this.index++] = num;
            }
        }
        return this.arr;
    }

    private boolean isUse(int num, int[] arr) {
        for (int i : arr) {
            if (i == num) {
                return false;
            }
        }
        return true;
    }
}

public class JavaDemo48 {
    public static void main(String[] args) {
        // 实现36选7数字随机生成，不重复。
        RandomNSelectM rs = new RandomNSelectM(36, 7);
        int[] arr1 = rs.newRandom();
        for (int num : arr1) {
            System.out.print(num + "、");
        }
    }

}
```
