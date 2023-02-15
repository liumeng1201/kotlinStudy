/**
 * 泛型扩展函数
 * 所有类型都是泛型，对泛型的扩展可被所有调用（函数、null也可以）
 * */
fun <T> T.showContentPrint() =
    println(if (this is String) "字符串${this}的长度是${(this as String).length}" else "不是字符串，是${this}")

fun <T> T.showTypeAction() =
    when (this) {
        is String -> "字符串类型"
        is Int -> "整型"
        is Unit -> "无返回函数类型"
        else -> "未知类型"
    }

fun sample() {}

/**
 * private          私有声明
 * inline           函数中使用了lambda，通过inline进行优化可提高性能
 *fun <I, O>        在函数中声明两个泛型，I 输入泛型，O 输出泛型
 * I.mLet           对输入泛型进行函数扩展，所有类型都支持调用mLet函数
 * action: (I) -> O I输入类型，O输出类型，lambda表达式的最后一行作为输出，由用户决定输出的类型
 * : O              mLet函数输出类型
 * action(this)     this==I，是调用者本身
 * */
private inline fun <I, O> I.mLet(action: (I) -> O): O = action(this)

fun main() {
    null.showContentPrint()
    "heihei".showContentPrint()
    123456.showContentPrint()
    'C'.showContentPrint()
    sample().showContentPrint() // 函数也可以调用扩展函数
    false.showContentPrint()

    println(null.showTypeAction())
    println("heihei".showTypeAction())
    println(123456.showTypeAction())
    println('C'.showTypeAction())
    println(sample().showTypeAction())
    println(false.showTypeAction())

    "stringcontent".mLet {
        println("自己实现的mLet函数调用，由${it}发起调用")
    }
    123.mLet {
        println("自己实现的mLet函数调用，由${it}发起调用")
    }
}