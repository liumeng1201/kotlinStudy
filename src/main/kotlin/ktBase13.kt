fun main() {
    // 默认是不可空类型，不能给null，否则编译不通过
    var name1: String = "haha"
    println(name1)
    println("name1的长度=${name1.length}")

    // kotlin可空特性
    // 声明时在类型后加入?指定为可空类型
    var name2: String? = "init"
    name2 = null
    name2 = "Name"
    println(name2)
    name2 = null
    // name2? 表示name2真的为空的时候不执行后面的区域
    println("name2的长度=${name2?.length}")
}