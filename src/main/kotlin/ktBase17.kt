import kotlin.math.roundToInt

fun main() {
    // kotlin substring 用法
    val INFO = "data_is_success_result"
    val indexOf = INFO.indexOf('i')
    println(INFO.subSequence(0, indexOf))
    println(INFO.substring(0 until indexOf))

    // kotlin split 用法
    val jsonText = "data1,data2,data3,data4"
    val list: List<String> = jsonText.split(',')
    println(list)
    list.forEach() { println(it) }
    val (v1, v2, v3, v4) = list
    println("结构四个只读变量的值分别是：v1=${v1},v2=${v2},v3=${v3},v4=${v4}")

    // kotlin replace 用法
    val sourceText = "ABCDEFGHAHBSJIJKLMNOPQRSTUVWXYZ"
    println("原始内容：${sourceText}")
    val secretText = sourceText.replace(Regex("[BJMPIS]")) {
        println("it=${it.value}")
        when (it.value) {
            "B" -> "1"
            "J" -> "2"
            "M" -> "3"
            "P" -> "4"
            "I" -> "5"
            "S" -> "6"
            else -> it.value
        }
    }
    println("加密后内容：${secretText}")

    /**
     * kotlin语言的 == 与 === 比较操作
     * == 值内容的比较，相当于Java的equals
     * === 引用的比较，相当于Java的 ==
     * */
    val n1: String = "Derry"
    val n2: String = "Derry"
    // n1.equals(n2) 等价于 n1==n2 都是属于值的比较
    println(n1.equals(n2)) // Java写法的风格
    println(n1 == n2) // Kotlin写法的风格
    // 结果为 true ，因为n1、n2都指向字符串常量池中的同一个
    println(n1 === n2)
    val n4: String = "derry".capitalize()
    // 结果为 false，因为n4的实际引用是derry，只是将首字母d改成大写，并不是复用Derry字符串常量
    println(n4 === n1)

    /**
     * kotlin 字符串遍历
     * */
    val str: String = "SDHIWNDGSDYGIWOPD"
    str.forEach {
        println("字符是：${it}")
    }

    /**
     * kotlin 语言中数字类型的安全转换函数
     * 在进行字符串转数值操作时尽量使用 toIntOrNull方法 并配合 合并操作符 可尽量减少奔溃
     * */
    val number: Int = "666".toInt()
    println(number)
    // 如果字符串中是Double类型则无法转换为Int类型，会报错奔溃
    // val number2:Int = "666.66".toInt()
    // 若想要转换并不奔溃可使用下面的方法，如果转换Int成功则返回Int，如果转换失败则返回null，因此变量的类型需要对应调整为 Int?
    val number2: Int? = "666.66".toIntOrNull()
    println(number2)
    println(number2 ?: "转换失败，没有拿到Int数值") // 可配合 ?: 合并操作符使用，如果成功则输出number2，否则输出后面的提示内容

    /**
     * kotlin中Double转Int
     * toInt 在进行转换时没有四舍五入效果
     * roundToInt 在进行转换时有四舍五入效果
     * */
    println(13.231.toInt()) // 13
    println(13.831.toInt()) // 13
    println(13.231.roundToInt()) // 13
    println(13.831.roundToInt()) // 14
    println("%.3f".format(3.1415926)) // 保留3位小数，有四舍五入效果
}