/**
 * 在kotlin中，所有类都隐式继承了 :Any()
 * 在Java中，所有类都隐式继承了 extends Object
 * Any类 在kotlin设计中只提供标准，看不到实现，实现在各个系统平台处理
 * 在kotlin中 Any? == Object 这样描述最准确
 * */
class Obj1 : Any()
class Obj2 : Any()
class Obj3 : Any()

fun main() {
    println(Obj1().toString())
}