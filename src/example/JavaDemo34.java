
interface ILink<E> { // 设置泛型避免安全隐患
    public void add(E e);

    public int size();// 获取数据个数

    public Boolean isEmpty(); // 判断是否为空

    public Object[] toArray(); // 返回数据集合

    public E get(int index); // 获取指定索引数据

    public void set(int index, E data); // 修改指定数据

    public Boolean contains(E data);// 判断指定数据是否存在

    public void remove(E data); // 数据的删除

    public void clean(); // 清空链表
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

    @Override
    public void clean() {
        this.root = null;
        this.count = 0;
    }
}

interface Pet {
    public String getName();

    public String getColor();
}

class PetShop {
    private ILink<Pet> allPets = new LinkImpl<>();// 保存多个宠物

    public void add(Pet pet) { // 增加宠物
        this.allPets.add(pet);
    }

    public void delete(Pet pet) {// 删除
        this.allPets.remove(pet);
    }

    public ILink<Pet> search(String keyWord) {
        ILink<Pet> res = new LinkImpl<>();
        Object result[] = this.allPets.toArray();
        if (result != null) {
            for (Object obj : result) {
                // if (((Pet) obj).getName().contains(keyWord) ||
                // ((Pet) obj).getColor.contains(keyWord)) {
                // res.add((Pet) obj);
                // }
                if ((((Pet) obj).getColor().contains(keyWord)) || (((Pet) obj).getName().contains(keyWord))) {
                    res.add((Pet) obj);
                }
            }
        }
        return res;
    }
}

class Cat implements Pet {
    private String name;
    private String color;

    public Cat(String name, String color) {
        this.color = color;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "宠物猫：名字是" + this.name + "、颜色：" + this.color;
    }
}

class Dog implements Pet {
    private String name;
    private String color;

    public Dog(String name, String color) {
        this.color = color;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "宠物狗：名字是" + this.name + "、颜色：" + this.color;
    }
}

public class JavaDemo34 {
    public static void main(String[] args) {
        PetShop shop = new PetShop();
        shop.add(new Cat("黄猫", "黄色"));
        shop.add(new Dog("花狗", "黄斑色"));
        shop.add(new Cat("梨花猫", "黄黑色"));
        shop.add(new Dog("黑狗", "黑色"));
        Object[] res = shop.search("黄").toArray();
        if (res != null) {
            for (Object obj : res) {
                System.out.println(((Pet) obj).toString());
            }
        }
        System.out.println("黄色".equals("黄"));
        fun();
    }
    public static void fun(){
        System.out.println(1);
    }
}