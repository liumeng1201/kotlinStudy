open class Person34(val name: String) {
    fun personMethod() = "父类独有方法"
}

class Student34(private val stuName: String) : Person34(stuName) {
    fun studentMethod() = "子类独有方法"
}

fun main() {
    val p: Person34 = Student34("学生1")
    p.personMethod()

    (p as Student34)
    /**
     * 智能类型转换：通过 p as Student34 编译器会明白 p 现在已经被转换为 Student34 类型了，后面就可以调用 Student34 类中的独有方法了
     * */
    p.studentMethod()
}