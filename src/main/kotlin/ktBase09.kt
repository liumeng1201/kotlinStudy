fun main() {
    /**
     * 函数有使用lambda作为参数，尽量使用inline关键字修饰，这样内部会做优化减少函数开辟、对象开辟等损耗
     * */

    /**
     * 函数没有使用内联，在调用端会生成多个对象来完成lambda的调用（会造成性能的损耗）
     * */
    loginAPI4() { msg, code ->
        ""
    }

    /**
     * 函数使用内联，在调用端，类似C++定义宏，会把代码替换到调用处，好处没有任何函数开辟、对象开辟等消耗
     * */
    loginAPI5 { msg, code ->
        ""
    }
}

fun loginAPI4(responseResult: (String, Int) -> Unit) {
}

inline fun loginAPI5(responseResult: (String, Int) -> Unit) {
}