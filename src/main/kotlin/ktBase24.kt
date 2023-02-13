class Student {
    var name: String = "Derry"

    /**
     * 下面的代码创建类时默认就会添加，不用再手写，如需修改get、set的功能可以重写
     * field是kotlin的关键字
     * */
    /*
        get() = field
        set(value) {
            field = value
        }
    */
    /* 实际做的是如下的事情
    @NotNull
    private String name = "Derry";
    public void setName(@NotNull String name) {
        this.name = name;
    }
    @NotNull
    public String getName() {
        return this.name;
    }
    */

    var info: String = "hello world"
        // 重写了get、set方法
        get() = field.capitalize()
        set(value) {
            field = "**[$value]**"
        }
}

class Derry {
    val number: Int = 0
    /* 之所以是只读是因为仅有get方法，没有set方法
        private int number = 0;
        public int getNumber() {
            return this.number;
        }
     */

    // 计算属性 field (field永远描述的是变量的值)
    // number2 没有 field 了，因为number2压根就没有值，所以就没有field
    val number2: Int
        get() = (1..1000).shuffled().first()
    /* 背后的隐式代码
        为什么没有number2的定义？
        因为计算属性的功能导致没有field，就没有number2了
    public int getNumber2(){
        return 99;
    }
     */

    /**
     * 防范竟态条件
     * 当调用的成员可能为null、空值时，就必须采用防范竟态条件，这是kotlin编程的规范化
     * 尽量使用 ? + 内置函数 + 空合并操作符
     * */
    var info: String? = null
    fun getStudentInfo(): String {
        return info?.let {
            if (it.isBlank()) {
                "原来你是空值"
            } else {
                "你的值是：${it}"
            }
        } ?: "原来你是null"
    }
}

fun main() {
    // 下面的语句可以执行是因为默认是调用了Student的set方法来进行值的设置
    // 背后的隐式代码： new Student().setName("xxx")
    Student().name = "xxx"
    // 下面语句背后的隐式代码： System.out.println(new Student().getName())
    println(Student().name)

    println(Derry().number2)

    println(Derry().getStudentInfo())
    val derry:Derry = Derry()
    derry.info = "haha"
    println(derry.getStudentInfo())
}