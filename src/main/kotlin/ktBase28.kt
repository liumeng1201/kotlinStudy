class K28(name: String, sex: Char, age: Int) {
    init {
        /**
         * 不是Java的 static{}
         * 相当于是Java的 {} 构造代码块
         * 在kotlin中叫初始化快、init代码块、主构造代码块
         * */
        println("主构造函数被调用了 name=${name}, sex=${sex}, age=${age}")

        // 用来检测数据
        // 可在此处检测必须传递的值有有效数据
        require(name.isNotBlank()) { "name的值是空的，抛出异常" }
        require(age > 0) { "age的值异常" }
        require(sex == '男' || sex == '女') { "sex的值异常" }
    }

    constructor(name: String) : this(name, '女', 18) {
        // 次构造函数，次构造可以比主构造参数少
        println("次构造函数被调用了")
    }
}

fun main() {
    K28("hanmeimei", '女', 21)
    K28("李思思", '男', 21)
    K28("lisisi", '女', 19)

    K28("王子")
}