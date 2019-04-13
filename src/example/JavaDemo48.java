
import java.util.Random;

class MathUtil {
    private MathUtil() {
    };

    // 实现四舍五入
    // num要进行操作的数字
    // scale保留的小数位数
    public static double Round(double num, int scale) {
        return Math.round(num * Math.pow(10, scale)) / Math.pow(10, scale);
    }

    // 生成随机数
    public static int[] MathNextInt(int num, int count) {
        int[] intArr = new int[count];
        Random rm = new Random();
        for (int i = 0; i < count; i++) {
            intArr[i] = rm.nextInt(num);
        }
        return intArr;
    }
}

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

    public int[] randomRes() {
        if (this.arr[this.count - 1] != 0) {
            return this.arr;
        }
        Random rand = new Random();
        int num = rand.nextInt(this.max) + 1;
        if (this.index == 0) {
            this.arr[this.index] = num;
            this.index++;
        } else {
            for (int i : this.arr) {
                if (i == num) {
                    this.randomRes();
                }
            }
            this.arr[this.index] = num;
            if (this.index < this.count - 1) {
                this.index++;
            }
        }
        return this.randomRes();
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
        // System.out.println(MathUtil.Round(19.86273, 2));
        // System.out.println(MathUtil.Round(19.86573, 2));
        // // 19.86
        // // 19.87

        // int[] arr = MathUtil.MathNextInt(10, 10);
        // for (int num : arr) {
        // System.out.print(num + "、");
        // }
        // 3、5、2、3、4、3、7、8、9、9、

        // 实现36选7数字随机生成，不重复。
        RandomNSelectM rs = new RandomNSelectM(36, 5);
        // int[] arr1 = rs.randomRes();
        int[] arr1 = rs.newRandom();
        for (int num : arr1) {
            System.out.print(num + "、");
        }
    }

}