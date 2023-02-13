// 在调用K29类的次构造函数时的执行顺序
// 第一步：生成 val sex:Char
class K29(_name: String, val sex: Char) {    // 主构造
    // 第二步：生成 name
    val name: String = _name    // 类成员
    // 类成员和init代码块优先级是同一级，谁在前谁先执行

    // 第三步：执行init代码块细节
    init {
        val nameValue = _name
        println("init代码块打印 nameValue=${nameValue}")
    }

    constructor(name: String, sex: Char, age: Int) : this(name, sex) {
        // 第五步：执行次构造函数
        println("次构造函数被执行 name=${name}, sex=${sex}, age=${age}")
    }

    // 第四步：生成 derry
    val derry: String = "Derry is successful"   // 类成员
}

fun main() {
    K29("李思思", '女', 19)
}