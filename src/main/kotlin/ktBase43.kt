class AddClass(val n1: Int, val n2: Int) {
    // 对 + 号 运算符重载，在kotlin中 plus 代表 +
    // operator fun AddClass.  可以快速查看可重载的运算符在kotlin中是用哪些关键字表示的
    operator fun plus(p1: AddClass): Int {
        return n1 + p1.n1 + n2 + p1.n2
    }

}

fun main() {
    println(AddClass(1, 1) + AddClass(2, 2))
}