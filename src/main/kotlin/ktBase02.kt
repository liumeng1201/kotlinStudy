fun main() {
    /**
     * in is 是kotlin关键字，当调用Java中使用关键字定义的方法时需要加反引号
     * */
    ktBase02.`in`()
    ktBase02.`is`()

    `123123123`()
}

fun `123123123`() {
    println("可使用纯数字方法名来防止反编译后查看")
}