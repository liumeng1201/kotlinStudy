fun main() {
    /**
     * 方式一：这种方式属于把匿名函数给了responseResult变量lambda的声明
     */
    login("username", "password") { msg, code ->
        println("用户登录成果：msg=${msg}，code=${code}")
    }

    /**
     * 方式二：responseResult声明处这里的lambda属于函数类型的对象
     * 需要把responseResultImpl实实在在的函数通过“函数引用” :: 来变成函数类型的对象
     * :: 可以把普通函数变成函数类型的引用
     * 下面两种调用方式效果一样
     * */
    val funObject1 = ::responseResultImpl
    login("username", "password", funObject1)
    login("username", "password", ::responseResultImpl)
}

fun responseResultImpl(msg: String, code: Int): Unit {
    println("用户登录成果：msg=${msg}，code=${code}")
}

const val USER_NAME = "username"
const val USER_PWD = "password"

inline fun login(name: String, pwd: String, responseResult: (String, Int) -> Unit) {
    if (USER_NAME == name && USER_PWD == pwd) {
        responseResult("登录成功", 200)
    } else {
        responseResult("登录失败", 400)
    }
}