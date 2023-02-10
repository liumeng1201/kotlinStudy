fun main() {
    action01("张三", 24)
    action02("王五")
    action03()

    /** 具名函数参数，在调用方法时可不按参数默认顺序而是明确指定各个参数的数值 */
    loginAction(age = 33, username = "zhangSan", password = "123456")
}

/**
 * 函数默认是public，因此不写修饰符时默认为public
 * 函数在定义时先有输入再有输出
 * */
private fun method01(age: Int, name: String): Int {
    println("name:${name},age:${age}")
    return 200
}

private fun action01(name: String, age: Int) {
    println("name=${name},age=${age}")
}

/** age: Int = 88 为默认参数，不传递给参数时则默认为88，传递该参数时会覆盖该值 */
private fun action02(name: String, age: Int = 88) {
    println("name=${name},age=${age}")
}

private fun action03(name: String = "默认名字", age: Int = 66) {
    println("name=${name},age=${age}")
}

private fun loginAction(username: String, password: String, age: Int) {
    println("username:${username},password:${password},age:${age}")
}

/**
 * Unit 不写默认也有
 * Unit 代表无参数返回，忽略类型 == Unit类类型
 * doWork() doWork2() 函数返回完全一样，均是Unit类型
 * */
private fun doWork(): Unit {
    println(123)
}

private fun doWork2() {
    println(123)
}

private fun show(number: Int) {
    when (number) {
        -1 -> TODO("没有这种分数")
        /** TODO()方法可以终止行为，抛出异常，对应的是Nothing类型 */
        in 0..59 -> println("不及格")
        in 60..70 -> println("及格")
        in 71..100 -> println("优秀")
    }
}

interface USB {
    fun insert()
}

class USBImpl : USB {
    override fun insert() {
        /** 下面这句话不是注释，内部有Nothing类型（抛出一个错误）让程序终止 */
        TODO("Not yet implemented")
    }

}