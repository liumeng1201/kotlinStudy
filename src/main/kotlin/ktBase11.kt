fun main() {
    val result = showReturnFun("我是函数的输入参数")
    // result的返回类型 (String, Int) -> String
    println(result("hahaha", 38))

    val rObject: (String) -> (String, Int) -> String = ::showReturnFun
    // rObject2的 :: 函数对象类型是什么类型？  (String) -> (String, Int) -> String
    val rObject2 = ::showReturnFun
    println(rObject("11")("hehehe", 22))
}

// 函数类型作为返回类型
fun showReturnFun(info: String): (String, Int) -> String {
    println("我是show函数的info=${info}")
    // 返回了一个匿名函数
    return { msg, code ->
        "我是返回数据msg=${msg}，code=${code}"
    }
}