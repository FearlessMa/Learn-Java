class Point<T> { // T是Type的简写,可以定义多个泛型
    private T x;
    private T y;

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }
}

public class JavaDemo12 {
    public static void main(String[] args) {
        Point<Integer> p = new Point<Integer>();
        p.setX(10);// 自动装箱
        p.setY(20);
        // 获取x，y
        // int x = (Integer) p.getX(); // 拆箱，向下转型获取数据
        // int y = (Integer) p.getY();
        int x = p.getX();
        int y = p.getY();
        System.out.println("x=" + x + "、y=" + y);
        // x=10、y=20
    }
}