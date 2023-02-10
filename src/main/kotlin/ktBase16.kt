fun main() {
    var value1: String? = null
    var value2: Boolean = false

    // 数据为null时会抛出 IllegalStateException(message.toString()) 异常
    checkNotNull(value1)
    // 数据为null是会抛出 IllegalArgumentException(message.toString()) 异常
    requireNotNull(value1)

    require(value2)
    require(value2) { "你的value2是false啊" }

     test()
}

fun method000(): String {
    return "haha"
}
fun method0001(): Unit {
    "haha"
}
fun method0002(): Any {
    return -1
    return ""
    return true
}
fun method0003(): Any? {
    return null
}

fun method001(name: String): Unit {
    val doWork: (String, Int) -> Unit
    doWork = { msg, code ->
        "这里对msg：${msg}，code：${code}，参数的值进行使用"
    }
    println(doWork("msg的内容", 200))

    val doWork1: (Int) -> Any? = {
        when (it) {
            1 -> "haha"
            2 -> 100
            3 -> true
            else -> null
        }
    }
    println("doWork1函数的返回值=${doWork1(5)}")

    method0011("method0011函数", 19)
}
fun method0011(name: String, age: Int) {
    println("name=${name}, age=${age}")

    method002("张三", 18) { msg ->
        println("这是method002函数的第3个参数的实现，该参数为函数类型，该函数有一个输入参数，参数的值为：${msg}")
    }
    method002("李四", 19, ::doWorkImpl)
    val method002Result = method002("李四2", 119, ::doWorkImpl)
}
fun doWorkImpl(msg: String): Unit {
    println("这是一个对doWork函数类型参数具体实现的函数，该函数的参数msg的值为：${msg}")
}
fun method002(name: String, age: Int, doWork: (String) -> Unit): Int {
    println("name=${name}, age=${age}")
    doWork("name=${name}, age=${age}")
    return 1
}

fun test() {
    val method003Result = method003("嘿嘿", 15)
    method003Result("method003处理完成", 200)

    println(method0031("哈哈", 16)("method0031Return函数实现", 200))
}

fun method003(name: String, age: Int): (String, Int) -> Any {
    println("这是method003方法的具体逻辑处理部分，其输入参数name=${name},age=${age}")
    return { msg, code ->
        println("这是method003的方法的返回值，该方法返回一个函数类型，这是函数里具体做的操作->msg=${msg},code=${code}")
    }
}
fun method0031(name: String, age: Int): (String, Int) -> Any {
    println("这是method0031方法的具体逻辑处理部分，其输入参数name=${name},age=${age}")
    return ::method0031Return
}
fun method0031Return(msg: String, code: Int): Any {
    return "${msg},${code}"
}
