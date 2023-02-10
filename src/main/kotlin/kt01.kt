fun main(args: Array<String>) {
    println("Hello World!")

    // var 可读可改
    var name: String = "name string"
    name = "BHawK"
    println(name)

    // val 可读不可改
    val name2 = "can not change"
    println(name2)

    /**
     * kotlin数据类型
     * String   字符串
     * Char     单字符
     * Boolean  ture、false
     * Int      整数
     * Double   小数
     * List     元素集合
     * Set      无重的复元素集合
     * Map      键值对元素集合
     * */

    // 类型断定，kotlin可根据变量的值自动断定变量类型
    // 在使用中尽量使用类型断定
    val hello = "hello world"

    // kotlin的编译时常量
    // 只能是基本数据类型（String,Char,Double,Int,Float,Long,Short,Byte,Boolean）
    // 编译时常量不能放在函数里，因为函数在运行时才会执行，才可被赋值，就无法做到常量的功能
    // const val PI = 3.1415
}
// 编译时常量要放在函数外
const val PI = 3.1415