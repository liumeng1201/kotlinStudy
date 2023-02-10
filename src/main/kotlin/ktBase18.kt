fun main() {
    val info: String = "Derry Is Successfull"
    println("info字符串的长度是：${info.length}")
    println("info字符串最后一个字符是：${info[info.length - 1]}")
    println("info字符串全部转换为小写是：${info.toLowerCase()}")

    /**
     * apply 内置函数
     * apply函数始终返回info本身，不管在apply函数实现中做什么操作均会返回调用者本身
     * */
    val info2: String = info.apply {
        // 一般情况下，匿名函数都会持有一个it，但是apply函数不会持有it，却会持有 this
        // info == this  this == info ，谁点出apply函数，this==谁
        println(this)
        8
        true

        println("info字符串的长度是：${this.length}")
        println("info字符串的长度是：${length}") // this可以省略
        println("info字符串最后一个字符是：${this[this.length - 1]}")
        println("info字符串最后一个字符是：${this[length - 1]}")
        println("info字符串全部转换为小写是：${this.toLowerCase()}")
    }
    println("apply的返回值是：${info2}")

    /**
     * apply函数真正的用法：链式调用
     * info.apply函数始终返回info本身，所以可以链式调用，功能分层
     * */
    info.apply {
        println("info字符串的长度是：${this.length}")
    }.apply {
        println("info字符串最后一个字符是：${this[this.length - 1]}")
    }.apply {
        println("info字符串全部转换为小写是：${this.toLowerCase()}")
    }
}