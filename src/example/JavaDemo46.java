
public class JavaDemo46 {
    public static void main(String[] args) {
        long MB = 1024 * 1024;
        Runtime rn = Runtime.getRuntime(); // 获取实例化对象
        System.out.println(rn.availableProcessors());// 当前可用的进程数12
        System.out.println(MB);
        System.out.println("【1】最大内存空间:" + (rn.maxMemory() / MB) + "MB");
        System.out.println("【1】可用内存空间:" + (rn.totalMemory() / MB) + "MB");
        System.out.println("【1】空闲内存空间:" + (rn.freeMemory() / MB) + "MB");
        // 12
        // 1048576
        // 最大内存空间：4096MB
        // 可用内存空间256MB
        // 空闲内存空间254MB
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时" + (end - start));//操作耗时375 毫秒
        System.out.println("***************************");
        System.out.println("【2】最大内存空间:" + (rn.maxMemory() / MB) + "MB");
        System.out.println("【2】可用内存空间:" + (rn.totalMemory() / MB) + "MB");
        System.out.println("【2】空闲内存空间:" + (rn.freeMemory() / MB) + "MB");
        // 【2】最大内存空间:4096MB
        // 【2】可用内存空间:375MB
        // 【2】空闲内存空间:215MB
        rn.gc();
        System.out.println("***************************");
        System.out.println("GC清理后");
        System.out.println("【3】最大内存空间:" + (rn.maxMemory() / MB) + "MB");
        System.out.println("【3】可用内存空间:" + (rn.totalMemory() / MB) + "MB");
        System.out.println("【3】空闲内存空间:" + (rn.freeMemory() / MB) + "MB");
        // GC清理后
        // 【3】最大内存空间:4096MB
        // 【3】可用内存空间:8MB
        // 【3】空闲内存空间:7MB

        System.gc();
    }
}