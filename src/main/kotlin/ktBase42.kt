// 普通类
class Student42(val name: String, val age: Int, val sex: Char) {
    /**
     * 解构声明
     * 顺序必须是 component1,component2,component3... 和成员一一对应顺序下来
     * component0 是不行的
     * */
    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = sex
}

// 数据类 会自动生成解构
data class Student42Data(val name: String, val age: Int, val sex: Char)

fun main() {
    val (name, age, sex) = Student42("小李", 15, '男')
    println("普通类 解构后：name=$name, age=$age, sex=$sex")

    // 解构时使用 _ 表示拒收相应的成员，可以降低资源消耗
    // 下方表示只接收 age ，对name和sex拒收
    val (_, aGe, _) = Student42("小李", 15, '男')

    val (n, a, s) = Student42Data("小张", 16, '女')
    println("普通类 解构后：name=$n, age=$a, sex=$s")
}