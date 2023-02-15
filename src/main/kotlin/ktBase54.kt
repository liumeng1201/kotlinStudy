class Object1
class Object2
class Object3

/**
 * reified 关键字，真泛型类型的监测
 * */
inline fun <reified T> showTypeInfo(item: T) {
    if (Object1() is T) {
        println("类型Object1")
    } else if (Object2() is T) {
        println("类型Object2")
    } else if (Object3() is T) {
        println("类型Object3")
    } else {
        println("不是类型Object1、Object2、Object3，传递进来的类型是 ${T::class.java.simpleName}")
    }
}

fun main() {
    showTypeInfo("字符串")
    showTypeInfo(123)
    showTypeInfo('C')
    showTypeInfo(true)
    showTypeInfo(Object1())
}