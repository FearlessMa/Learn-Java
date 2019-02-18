interface IUSB { // 定义usb标准
    public boolean check(); // 检查usb接口

    public String work();
}

class Computer {
    public void plugin(IUSB usb) {
        if (usb.check()) {
            System.out.println("硬件检查通过");
            System.out.println(usb.work());
        }else{
            System.out.println("硬件检未查通过");
        }
    }
}

class Keyboard implements IUSB {
    @Override
    public boolean check() {
        return true;
    }

    @Override
    public String work() {
        return "键盘可以使用";
    }
}

class Print implements IUSB{
    @Override
    public boolean check(){
        return false;
    }
    @Override
    public String work(){
        return "打印机可以使用";
    }
}

public class JavaDemo09 {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.plugin(new Keyboard());//链接键盘
        c.plugin(new Print());//链接打印机
        // 硬件检查通过
        // 键盘可以使用
        // 硬件检未查通过
    }
}