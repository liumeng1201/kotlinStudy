const val PI1 = 3.1415
const val PI2 = 3.1415925f
const val age = 99

// 阅读kotlin反编译后JVM规范
fun main() {
    val name = "BHawK"

    /**
     * Java有两种数据类型：基本类型和引用类型（包装类型）
     *
     * Kotlin只有一种数据类型：引用类型，最终会转换为Java基本类型并编译为字节码
     * */

    // range表达式，范围从哪里到哪里
    val score = 148
    if (score in 10..59) {
        println("不及格")
    } else if (score in 0..9) {
        println("不及格且分数过低")
    } else if (score in 60..100) {
        println("及格")
    } else if (score !in 0..100) {
        println("分数不在0~100之间")
    }

    // when表达式
    val week = 1
    val result = when (week) {
        1 -> "星期一"
        2 -> "星期二"
        3 -> 99
        4 -> 3.124f
//        5 -> println("哈哈哈") //Unit类型
        else -> "不知道星期几"
    }
    println(result)

    // Kotlin语言的String模板
    val garden = "游乐场"
    val time = 6
    println("今天天气很好，去" + garden + "玩了" + time + "小时")
    // String模板的写法
    println("今天天气很好，去${garden}玩了${time}小时")

    val isLogin = false
    println("response result:${if (isLogin) "登录成功" else "登录失败"}")
}