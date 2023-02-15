/**
 * infix 关键字
 * 自定义的中缀表达式+扩展函数 一起使用
 * 中缀表达式可以简化代码
 * */
private infix fun <C1, C2> C1.go(c2: C2) {
    println("${this}调用了go中缀表达式，第二个参数的内容是${c2}")
}

fun main() {
    123.go("hello")
    true go 123
    "hhhh".go("OK")
}