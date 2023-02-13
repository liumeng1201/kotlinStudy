/**
 * 主构造函数里定义属性
 * 属性操作一步到位，更推荐这种写法
 * */
class Students2(var name: String, val sex: Char, val age: Int, val info: String) {

    fun show() {
        println(name)
        println(sex)
        println(age)
        println(info)
    }
}

fun main() {
    val students = Students2(name = "张三", sex = '男', age = 19, info = "个人信息")
    students.show()
}