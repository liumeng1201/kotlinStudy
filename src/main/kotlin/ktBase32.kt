/**
 * kotlin中继承与重载的open关键字
 * kotlin所有类，默认是final修饰的，不能被继承，与Java相反
 * kotlin所有函数，默认是final修饰的，不能被重载，与Java相反
 * 需要使用open去除final修饰
 * */
open class Person32(private var userName: String) {
    // var userName 使用private修饰之后在子类中就无法直接使用了
    
    private fun showName(): String = "父类 用户名是：${userName}"

    // 如果不加open关键字则转换为Java代码是 public final void myPrint()
    open fun myPrint() {
        println(showName())
    }
}

// 转换为Java代码是 public final class Student32 extends Person32
class Student32(private var studentName: String) : Person32(studentName) {
    private fun showName(): String = "子类 学生名是：${studentName}"

    override fun myPrint() {
        println(showName())
    }
}

fun main() {
    val p: Person32 = Student32("小明")
    p.myPrint()
}