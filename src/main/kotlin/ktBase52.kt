class K52<INPUT>(vararg objects: INPUT, val isR: Boolean = true) {
    // out 关键字开启INPUT只读模式，只能读取不能修改
    private val objectArray: Array<out INPUT> = objects

    /**
     * 五种返回类型说明
     * */
    fun getR1(): Array<out INPUT>? = objectArray.takeIf { isR }
    fun getR2(): Any = objectArray.takeIf { isR } ?: ""
    fun getR3(): Any? = objectArray.takeIf { isR } ?: "" ?: null
    fun getR4(index: Int): INPUT? = objectArray[index].takeIf { isR }
    fun getR5(index: Int): Any? = objectArray[index].takeIf { isR } ?: "" ?: 123 ?: null

    /**
     * [] 运算符重载
     * */
    operator fun get(index: Int): INPUT? = objectArray[index].takeIf { isR }
}

/**
 * 泛型可以接收null，因此在处理泛型数据时需要进行补救
 * 如：将泛型转换为 类型? 的形式以便对null的情况进行处理
 * */
fun <INPUT> putObject(item: INPUT) {
    println((item as String?)?.length ?: "传递进来的泛型是null")
}

fun main() {
    val p1: K52<String?> = K52("张三", "李四", "王五", "赵六", null)
    p1[0]
    p1[1]
    println(p1[3])
    println(p1[4])
}