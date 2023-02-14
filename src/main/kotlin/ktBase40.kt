/**
 * 普通类
 * */
class ResponseBean1(msg: String, code: Int, data: String)

/**
 * 数据类
 * 在普通类的基础上增加部分功能并重写了部分功能
 * 数据类型使用条件：1.服务器请求、响应的JavaBean 基本上可使用数据类
 *               2.数据类至少必须有一个参数的主构造函数
 *               3.数据类必须有参数，参数需要使用 var val修饰
 *               4.数据类不能使用 abstract open sealed inner 等修饰，数据量只做数据载入、存储
 *               5.有以下需求可使用数据类  equals、copy、toString、解构等
 * */
data class ResponseBean2(val msg: String, val code: Int, val data: String)

fun main() {
    // 调用Any的equals方法进行比较，在不同平台有不同实现，大部分平台为引用的比较，结果为false
    println(ResponseBean1("msg", 200, "this is data")
            == ResponseBean1("msg", 200, "this is data"))

    // 重写了equals方法，进行值的比较，结果为true
    println(
        ResponseBean2("msg", 200, "this is data")
                == ResponseBean2("msg", 200, "this is data")
    )
}