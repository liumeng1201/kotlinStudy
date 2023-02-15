// 导入扩展文件
import lm.utils.randomItemValue as g // 重命名扩展，名字过长、表述不准确、容易写错等情况均可进行重命名
import lm.utils.randomItemValuePrint

fun main() {
    val list: List<String> = listOf("李隆基", "李元霸", "李小龙", "李连杰")
    val set: Set<Int> = setOf(12, 13, 14, 15, 15)

    // 第一种方式：随机获取一个集合中的元素
    println(list.shuffled().first())
    println(set.shuffled().first())
    println()
    // 第二种方式：通过扩展文件里的方法来完成功能
    list.randomItemValuePrint()
    set.randomItemValuePrint()

    // 使用重命名之后的扩展文件里的方法，下面两个写法的功能一致
    // list.randomItemValue()
    println(list.g())
    println(set.g())
}