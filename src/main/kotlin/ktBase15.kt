fun main() {
    try {
        var name = "BHawK"
        checkException(name)

        // xx?.yy 表示当xx不为null时执行后面yy对应的操作
        println("你的名字的长度为：${name?.length}")

        // xx!!.yy 表示不管xx是否为null均执行后面yy对应的操作
        println("你的名字的长度为：${name!!.length}")
    } catch (e: Exception) {
        println("异常信息：$e")
    }
}

// 异常处理
fun checkException(info: String) {
    // xxx ?: yyy 表示当 xxx 不为null时才会执行 yyy 部分的代码
    info ?: throw CustomException()
}

// 自定义异常
class CustomException : IllegalArgumentException("代码存在问题")