fun main() {
    innerFunLet()

    innerFunRun()

    innerFunWith()

    innerFunAlso()

    innerFunTakeIf()

    innerFunTakeUnless()
}

/**
 * apply函数  函数的返回永远是调用者本身，函数内部持有this、this是调用者本身，链式调用
 * let函数    函数的返回根据最后一行的变化而变化，函数内部持有it、it是调用者本身
 * run函数    函数的返回根据最后一行的变化而变化，函数内部持有this、this是调用者本身
 * with函数   函数的功能与run函数一样，仅使用方式不同，函数的返回根据最后一行的变化而变化，函数内部持有this、this是调用者本身
 * also函数   函数的返回永远是调用者本身，函数内部持有it、it是调用者本身，链式调用
 * */

fun innerFunLet() {
    /**
     * let 内置函数
     * let 函数的返回根据最后一行的变化而变化
     * 函数内部持有it，it是调用者本身
     * */

    // 普通方式 对集合中第一个元素相加
    val list: List<Int> = listOf(1, 2, 3, 4, 5)
    val value1 = list.first()
    println(value1 + value1)

    // let方式
    val result = listOf(1, 2, 3, 4, 5).let {
        it.first() + it.first()
    }
}

// 普通判null写法
fun get1(value: String): String {
    return if (value == null) {
        "你传递的value是null"
    } else {
        "欢迎${value}"
    }
}
// 上面的简化写法
fun get2(value: String) = if (value == null) "你传递的value是null" else "欢迎${value}"

// let判null写法
fun get3(value: String): String {
    return value?.let {
        "欢迎${it}"
    } ?: "你传递的value是null"
}
// 上面的简化写法
fun get4(value: String) = value?.let { "欢迎${it}" } ?: "你传递的value是null"

/************************/
fun innerFunRun() {
    /**
     * run 内置函数
     * run函数的返回根据最后一行的变化而变化
     * 函数内部持有this，this是调用者本身
     * */

    val str: String = "hello world"
    val r1: Double = str.run {
        true
        55
        'C'
        123.33
    }
    println(r1)

    // 具名函数判断长度 isLong
    // 匿名函数写法
    str.run {
        if (this.length > 5)
            true
        else
            false
    }
    // 具名函数+run函数
    str.run(::isLong).run(::showText).run(::mapText).run {
        println("最终的结果是：${this}")
    }
    // 上面的匿名写法
    str.run {
        if (this.length > 5) true else false
    }.run {
        if (this) "字符串符合要求" else "字符串太短"
    }.run {
        "【${this}】"
    }.run {
        println(this)
    }
}

fun isLong(value: String): Boolean = if (value.length > 5) true else false
fun showText(isLong: Boolean): String = if (isLong) "字符串符合要求" else "字符串太短"
fun mapText(returnString: String): String = "【${returnString}】"

/********************/
fun innerFunWith() {
    /**
     * 写法：with(xxx)
     * with的功能和run函数一样，仅使用方法不同
     * 函数的返回根据最后一行的变化而变化
     * 内部持有this，为被调用者本身
     * */

    val str = "孙悟空"
    val result1 = with(str, ::getLenAction)
    val result2 = with(result1, ::getLenInfoAction)
    with(result2, ::showTextAction)

    with(str) {
        println("str字符的长度是：${this.length}")
    }
}

fun getLenAction(str: String): Int = str.length
fun getLenInfoAction(len: Int): String = "字符串的长度是：${len}"
fun showTextAction(info: String) = println(info)

/***********************/
fun innerFunAlso() {
    /**
     * also 内置函数
     * xxx.also 函数的返回永远都是xxx，即调用者本身
     * 函数内部持有it，it==xxx 即调用者本身
     * 链式调用
     * */
    val str: String = "username"
    val r1: String = str.also {
        true
        'A'
        123123
    }
    str.also {
        println("str的原始值：${it}")
    }.also {
        println("str转换为大写：${it.toUpperCase()}")
    }.also {
        println("操作结束")
    }
}

/*********************/
fun innerFunTakeIf() {
    /**
     * xxx.takeIf{}
     * 当 takeIf 函数值为true时返回xxx本身，为false时返回null
     * 使用时会配合空合并操作符
     * */

    val result: String? = checkPermissionAction("root", "rootroot")
    println(if (result != null) "欢迎${result}" else "权限不足")

    println(checkPermissionAction2("user01", "password"))
}

// 该函数返回值为string或null
public fun checkPermissionAction(username: String, password: String): String? {
    // username.takeIf{ true/false } 当参数为true时返回username本身，为false时返回null
    return username.takeIf { checkPermissionSystemServer(username, password) }
}

public fun checkPermissionAction2(username: String, password: String): String {
    return username.takeIf { checkPermissionSystemServer(username, password) } ?: "权限不足"
}

private fun checkPermissionSystemServer(username: String, password: String): Boolean {
    return if (username == "root" && password == "rootroot") true else false
}

/**************************/
fun innerFunTakeUnless() {
    /**
     * 和takeIf功能是相反的，其他特点全部一样
     * xx.takeUnless{true/false} true时返回null，false时返回xx本身
     * */

}