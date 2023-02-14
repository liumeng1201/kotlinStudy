/**
 * 泛型类
 * */
class K48<T>(private val obj: T) {
    fun show() = println("你的输入是${obj}")
}

class K482<T>(private val isReturn: Boolean, private val obj: T) {
    fun getObj(): T? = obj.takeIf { isReturn }
}

data class Student481(val name: String, val age: Int, val sex: Char)
data class Student482(val name: String, val age: Int, val sex: Char)
data class Teacher481(val name: String, val age: Int, val sex: Char)
data class Teacher482(val name: String, val age: Int, val sex: Char)

fun main() {
    K48<Student481>(Student481("小张", 18, '男')).show()
    K48(Student482("小李", 12, '女')).show()
    K48(Teacher481("小张", 18, '男')).show()
    K48(Teacher482("小刘", 18, '男')).show()

    K48("123").show()
    K48('女').show()
    K48(123123).show()

    println(K482(true, Student481("小张", 18, '男')).getObj())
    println(K482(false, Teacher482("小张", 18, '男')).getObj() ?: "返回值是null")

    val returnResult: Any = K482(true, Teacher482("小张", 18, '男')).getObj()?.run {
        println("返回值是${this}")
        123.33
    } ?: println("返回值是null")
    println(returnResult)

    val resturnResult2: Teacher482? = K482(true, Teacher482("小张", 18, '男')).getObj()?.apply { }

    show("hehe")
    show(123)
    show(Teacher482("小张", 18, '男'))
    show(null)
}

/**
 * 泛型函数
 * */
fun <T> show(item: T) {
    item?.also {
        println("输入数据是$it")
    } ?: println("输入数据为null")
}