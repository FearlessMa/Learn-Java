
interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e);
}

class LinkImpl<E> implements ILink<E> {

    private class Node { // 内部Node类 外部不可见 保存节点数据关系
        private E data; // 保存数据
        private Node next; // 保存下一个引用

        public Node(E data) {
            this.data = data;
        }
        //将节点保存在合适的位置
        public void addNode(Node newNode){
            if(this.next == null){ //如果当前节点next为空 保存
                this.next = newNode;
            }else{//调用当前next节点继续递归判断
                this.next.addNode(newNode);
            }
        }
        // ---------------没有添加getter 和 setter 方法 是因为内部类的私有属性也方便外部类直接访问-------
    }

    // ---------------Link类中结构定义的成员-------
    private Node root; // 保存根元素
    // ---------------Link类中结构定义的方法-------

    @Override
    public void add(E e) {
        if (e == null) {
            return; // 数据为空 直接返回
        }
        // 因为数据本身不具有关联性，所以要把数据封装在Node类中
        Node newNode = new Node(e);
        if (this.root == null) { //没有根节点
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
    }
}

public class JavaDemo33 {
    public static void main(String args[]) {

    }
}