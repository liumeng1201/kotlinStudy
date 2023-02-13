// 主构造函数
class Person(name: String) {// 唯一的主构造
init {
    println("主构造函数 name=${name}")
}

    // 如果想完成多个构造函数重载的话，就需要用次构造函数
    // 两个参数的次构造函数，必须调用主构造函数，否则不通过
    // 次构造必须调用主构造是因为主构造统一管理，为了更好的初始化设计
    constructor(name: String, sex: Char) : this(name) {
        println("两个参数的次构造函数 name=${name} sex=${sex}")
    }

    // 三个参数的次构造函数
    constructor(name: String, sex: Char, age: Int) : this(name) {
        println("三个参数的次构造函数 name=${name} sex=${sex} age=${age}")
    }

    // 四个参数的次构造函数
    constructor(name: String, sex: Char, age: Int, info: String) : this(name, sex, age) {
        println("四个参数的次构造函数 name=${name} sex=${sex} age=${age} info=${info}")
    }
}


fun main() {
    // 调用的时候的原则，优先寻找主构造函数，主构造函数没有才寻找次构造
    //

    val p = Person("李小龙")
    println()
    Person("王二毛", '男')
    println()
    // 调用三个参数的次构造时，先调用主构造，在主构造的代码执行完毕之后才执行次构造里的代码
    Person("haha", '女', 18)
    println()
    // 调用四个参数的次构造，顺序为 主构造->三个参数的次构造->四个参数的次构造
    Person("hehe", '男', 18, "学习中")
}