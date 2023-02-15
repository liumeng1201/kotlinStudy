/**
 * 泛型类型约束
 * */

open class MyAnyClass(name: String)
open class PersonClass(personName: String) : MyAnyClass(personName)
class TeacherClass(teacherName: String) : PersonClass(teacherName)
class StudentClass(studentName: String) : PersonClass(studentName)
class DogClass(name: String)
class CatClass(name: String)

/**
 * 此处的 <T : PersonClass> 相当于Java的 <T extends PersonClass>
 * 限制泛型的类型只能是 PersonClass 及其子类
 * 其他类及顶级父类均不兼容
 * */
class K50<T : PersonClass>(val input: T, val isReturn: Boolean = true) {
    fun getObj() = input.takeIf { isReturn }
}

fun main() {
    val myAny = MyAnyClass("顶级父类")
    val person = PersonClass("父类")
    val teacher = TeacherClass("老师子类")
    val student = StudentClass("学生子类")
    val dog = DogClass("其他类狗")
    val cat = CatClass("其他类猫")

    // K50(myAny).getObj() 类型限定，报错
    K50(person).getObj()
    K50(teacher).getObj()
    K50(student).getObj()
    // K50(dog).getObj() 类型限定，报错
    // K50(cat).getObj() 类型限定，报错
}