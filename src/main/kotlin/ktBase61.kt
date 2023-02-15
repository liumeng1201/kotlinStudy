import java.io.File

/**
 * DSL 领域专用语言（Domain Specified Language） Gradle、JSON、XML
 * */

class Context {
    val info: String = "我是Context类的info信息"
    val name: String = "我是Context类的name信息"

    fun toast(msg: String) {
        println("打印信息$msg")
    }
}

/**
 * apply5函数就是DSL编程范式，定义输入输出等规则(语言规范)
 * 1. 定义整个lambda 输入标准，必须是Context这个类的实例才有资格调用apply5函数，匿名函数里面持有 this==Context 调用者本身  it==String
 * 2. 定义整个lambda 输出标准，始终返回Context本身，所以可以链式调用
 * */
// lambda: (Context.(String) -> Unit)
// Context.(String)  会让lambda表达式的输入为调用者
inline fun Context.apply5(lambda: (Context.(String) -> Unit)): Context {
    // lambda(this, this.info)  和下面一句功能一样 this 可以省略
    lambda(info)
    return this
}

inline fun File.applyFile(action: (String, String?) -> Unit): File {
    action(this.name, this.readText())
    return this
}

fun main() {
    /**
     * main函数根据DSL编程范式标准规则来写具体实现，DSL编程范式
     * */
    Context().apply5 {
        // this 对应的为调用者本身，也就是Context
        // it 对应的为String，也就是this.info
        // this.toast(it)
        toast(it)
        this.toast(name)
    }.apply5 { }

    File("").applyFile() { fileName, data ->
        println("$fileName, $data")
    }.applyFile() { fileName, data -> }
}