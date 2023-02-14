import java.io.File

/**
 * is 判断对象是否是类的实例
 * as 将对象的类型进行转换
 * */
open class Person33(private val personName: String) {
    fun showName1(): String {
        return "父类 名字是：${personName}"
    }

    open fun myPrint() {
        println(showName1())
    }
}

class Student33(private val studentName: String) : Person33(studentName) {
    fun showName2() = "子类 名字是：${studentName}"

    override fun myPrint() {
        println(showName2())
    }
}

fun main() {
    val stu: Person33 = Student33("李雷")
    stu.myPrint()

    // is 关键字用来判断对象是否是类的实例
    println(stu is Student33)
    println(stu is Person33)
    println(stu is File)

    (stu as Student33).myPrint()
    (stu as Person33).myPrint()
}