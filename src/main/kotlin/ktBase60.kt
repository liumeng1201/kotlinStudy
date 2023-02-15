/**
 * fun INPUT.()  对INPUT泛型扩展一个匿名函数
 * fun INPUT.abc() 对INPUT泛型扩展一个具名函数
 *
 * private 私有化
 * inline lambda优化
 * fun <INPUT> 函数中声明一个泛型
 * INPUT.myApply 让所有类型都可以调用myApply方法
 * INPUT.() -> Unit 让匿名函数里面持有this，在lambda里面不需要返回值，因为永远都是返回INPUT本身
 * action() 以便具体实现的lambda表达式可以被执行
 * : INPUT 因为永远返回调用者本身
 * */
private inline fun <INPUT> INPUT.myApply(action: INPUT.() -> Unit): INPUT {
    action()
    return this
}

private inline fun <INPUT> INPUT.myApply2(action: (INPUT) -> Unit): INPUT {
    action(this)
    return this
}

fun main() {
    "string_content".myApply {
        println("可在此处执行具体操作1")
    }.myApply {
        println("可在此处执行具体操作2")
    }

    "string_content".myApply2 {
        println("可在此处执行具体操作1")
    }.myApply2 {
        println("可在此处执行具体操作2")
    }
}