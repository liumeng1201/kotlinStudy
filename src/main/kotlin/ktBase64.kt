fun main() {
    val names = listOf("张三", "李四", "王五")
    val ages = listOf(12, 13, 14)

    /**
     * 函数式编程
     * */
    names.zip(ages).toMap().map {
        "名字是${it.key}, 年龄是${it.value}"
    }.map {
        println(it)
    }
}