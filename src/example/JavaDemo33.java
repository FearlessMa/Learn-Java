
interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e);

    public int size();// 获取数据个数

    public Boolean isEmpty(); // 判断是否为空

    public Object[] toArray(); // 返回数据集合

    public E get(int index); // 获取指定索引数据

    public void set(int index, E data); // 修改指定数据

    public Boolean contains(E data);// 判断指定数据是否存在

    public void remove(E data); // 数据的删除
}

class LinkImpl<E> implements ILink<E> {

    private class Node { // 内部Node类 外部不可见 保存节点数据关系
        private E data; // 保存数据
        private Node next; // 保存下一个引用

        public Node(E data) {
            this.data = data;
        }

        // 将节点保存在合适的位置
        public void addNode(Node newNode) {
            if (this.next == null) { // 如果当前节点next为空 保存
                this.next = newNode;
            } else {// 调用当前next节点继续递归判断
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode() {
            LinkImpl.this.nodeList[LinkImpl.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }

        public E getIndex(int index) {
            if (LinkImpl.this.foot++ == index) {
                return this.data;
            } else {
                return this.next.getIndex(index);
            }
        }

        public void setIndex(int index, E data) {
            if (LinkImpl.this.foot++ == index) {
                this.data = data;
            } else {
                this.next.setIndex(index, data);
            }
        }

        public Boolean equalsNode(E data) {
            if (data.equals(this.data)) {
                return true;
            } else {
                if (this.next == null) {
                    return false;
                }
                return this.next.equalsNode(data);
            }
        }

        public void removeNode(Node preNode, E data) {
            if (this.data.equals(data)) {
                preNode.next = this.next;
            } else {
                if (preNode.next != null) {
                    this.next.removeNode(this, data);
                }
            }
        }
        // ---------------没有添加getter 和 setter 方法 是因为内部类的私有属性也方便外部类直接访问-------
    }

    // ---------------Link类中结构定义的成员-------
    private Node root; // 保存根元素
    private int count;
    private Object[] nodeList;
    private int foot;
    // ---------------Link类中结构定义的方法-------

    @Override // 增加node
    public void add(E e) {
        if (e == null) {
            return; // 数据为空 直接返回
        }
        this.count++;
        // 因为数据本身不具有关联性，所以要把数据封装在Node类中
        Node newNode = new Node(e);
        if (this.root == null) { // 没有根节点
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
    }

    @Override // 获取node个数
    public int size() {
        return this.count;
    }

    @Override
    public Boolean isEmpty() {
        return this.count == 0;
        // return this.root == null;
    }

    @Override
    public Object[] toArray() {
        this.foot = 0;
        if (this.count == 0) {
            return null;
        } else {
            this.nodeList = new Object[this.count];
            this.root.toArrayNode();
            return this.nodeList;
        }
    }

    @Override
    public E get(int index) {
        if (index >= this.count) {
            return null;
        }
        // return (E) this.toArray()[index];
        this.foot = 0;
        return this.root.getIndex(index);
    }

    @Override
    public void set(int index, E data) {
        if (index > this.count) {
            System.out.println("参数不合法");
        } else {
            this.foot = 0;
            this.root.setIndex(index, data);
        }
    }

    @Override
    public Boolean contains(E data) {// 判断指定数据是否存在
        if (data == null)
            return false;
        return this.root.equalsNode(data);
    }

    @Override
    public void remove(E data) { // 数据的删除
        if (this.contains(data)) {
            // this.foot = 0;
            if (this.root.data.equals(data)) {
                this.root = this.root.next;
            } else {
                if (this.root.next != null) {
                    this.root.next.removeNode(this.root, data);
                }
            }
            this.count--;
        }
    }
}

public class JavaDemo33 {
    public static void main(String args[]) {
        LinkImpl<String> n = new LinkImpl<>();
        System.out.println("【增加之前】 链表个数= " + n.size() + "、是否为空" + n.isEmpty());
        n.add("No1");
        n.add("No2");
        n.add("No3");
        // for (Object item : n.toArray()) {
        // System.out.println((String) item);
        // }
        n.set(1, "修改index=1的数据");
        n.remove("No3");
        System.out.println("【增加之后】 链表个数= " + n.size() + "、是否为空" + n.isEmpty());
        System.out.println(n.get(0));
        System.out.println(n.get(1));
        System.out.println(n.get(2));
        System.out.println(n.contains("No3"));
        System.out.println(n.contains("No4"));
        System.out.println(n.contains(null));
    }
}