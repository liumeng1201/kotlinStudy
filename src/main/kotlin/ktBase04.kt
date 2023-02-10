fun main() {
    // 函数的输入与输出声明区域
    val methodAction: () -> String
    // 上面函数的输入输出实现区域
    // 与下面的独立的函数定义功能相同
    methodAction = {
        "返回值内容"
        88
        true
        "返回值"// 匿名函数不需要写return，最后一行作为返回值，隐式返回
        val inputString = 4545454
        "${inputString} 返回值"
    }
    // 调用方式下面两种均可
    println(methodAction())
    // 但该方式仅限上面定义的函数（上面的定义是lambda描述的函数）
    println(methodAction.invoke())

    // methodAction2函数只能采用下面的调用方式
    println(methodAction2())
}


// 下方是函数声明区域
fun methodAction2(): String
// 下方是函数实现区域
{
    return "返回值内容"
}