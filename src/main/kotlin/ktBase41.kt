/**
 * 数据类型 copy toString hashCode equals 解构 等等。。。只管主构造，不管次构造
 * */
data class K41(val name: String, val age: Int) {
    var info: String = ""

    init {
        println("主构造被调用了")
    }

    constructor(name: String) : this(name, 99) {
        info = "我是在次构造中被赋值"
        println("次构造被调用了")
    }

    override fun toString(): String {
        return "name=$name, age=$age, info=$info"
    }
}

fun main() {
    val p1: K41 = K41("小刚")
    /**
     * 此处的输出为：
     * name=小刚, age=99, info=我是在次构造中被赋值
     * 因为调用了次构造方法新建对象，并且重写了toString方法，可以输出三个参数的值
     * */
    println(p1)

    val p2: K41 = p1.copy("小王", 18)
    /**
     * 此处的输出为：
     * name=小王, age=18, info=
     * 因为copy方法只管主构造，不管次构造，因此info的值未被设置，所以没有输出
     * */
    println(p2)
    /**
     * 此处输出为：name=xx, age=99, info=
     * 就算赋值时使用次构造，copy函数依然不会调用次构造
     * */
    p1.copy("xx")

}