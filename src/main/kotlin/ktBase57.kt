fun main() {
    /**
     * apply 函数内部持有this，this为调用者本身，返回永远为调用者本身，适合链式调用
     * also 函数内部持有it，it为调用者本身，返回永远为调用者本身，适合链式调用
     * */
    val r1: String = "strstr".apply {
        this.length
        123
        true
    }
    val r2 = "strstr".also {
        it.length
        123
        true
    }

    /**
     * let 函数，内部持有it，it是调用者本身，返回由最后一行数据决定
     * run 函数，内部持有this，this是调用者本身，返回由最后一行数据决定
     * with 函数，与run一样，仅调用方式不同
     * */
    val r3: Boolean = "strstr".let {
        it.length
        123
        true
    }
    val r4: Boolean = "strstr".run {
        this.length
        123
        true
    }
    val r5: Boolean = with("strstr") {
        this.length
        123
        true
    }

    kuozhan()

    kekongkuozhan()
}

/**
 * 扩展属性
 * 对String类增加 myInfo 扩展属性
 * */
val String.myInfo
    get() = "我是${this}的扩展属性"

/**
 * 扩展函数
 * 对String类增加 showPrintln 扩展函数
 * */
fun String.showPrintln(): String {
    println("${this}在${System.currentTimeMillis()}时间，调用了扩展函数")
    return this
}

fun kuozhan() {
    "李元霸".myInfo.showPrintln().showPrintln()
}

/**
 * 可空类型扩展函数
 *
 * String? = String 小范围可以赋值给大范围
 * String = String? 大范围不能给小范围赋值
 * */
fun String?.outputStringValue(defaultValue: String) = println(this ?: defaultValue)
fun String?.getStringValue(defaultValue: String): String = this ?: defaultValue
fun kekongkuozhan() {
    val str: String? = null
    str.outputStringValue("字符串为null了")
    "hello".outputStringValue("我是默认值")
    println(null.getStringValue("我是默认值"))
    println("hello".getStringValue("我是默认值"))
}