fun main() {
    // kotlin语言的安全调用操作符
    var name: String? = "zhangsan"
    name = null
    // ? 表示如果真的为null，则后续区域不执行，不会导致程序奔溃
    name?.capitalize()


    name = "zhangsan"
    name = ""
    name = null
    // 如果name的值真的为null，则?后面的部分不执行
    val r: String? = name?.let {
        // it == name本身，是String类型的
        if (it.isBlank()) {
            // 当name的值是“”空内容时
            "Default"
        } else {
            "[$it]"
        }
        // 如果能够进入let里面的代码，代表it绝对是有值，有值才能进来
    }
    println(r)


    // !!断言，不管name是不是null，都执行.capitalize，会发生空指针异常
    name = "1qazz"
    name!!.capitalize()


    // 通过if判断来解决null问题
    if (name != null) {
        name.capitalize()
    } else {
        println("name is null")
    }


    /**
     * kotlin空合并操作符
     * xxx?:    如果xxx等于null，就会执行?:后面的代码
     * */
    var info: String? = "李小龙"
    info = null
    println(info ?: "原来你是null啊")
    // let函数+空合并操作符
    println(info?.let { "info的内容是${it}" } ?: "原来你是null啊2")
}