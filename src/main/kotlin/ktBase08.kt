import java.util.StringJoiner
import kotlin.math.log

fun main() {
    loginAPI("username", "password") { msg, code ->
        println("用户最终登录结果=${msg}，code=${code}")
    }

    test("username", "password",
        lambdafun1 = { msg, code ->
            println("${msg},code=$code")
        }, lambdafun2 = { msg ->
            println("$msg")
        })

    /**
     * 以下4种写法效果一样，是按照1、2、3、4的顺序依次改进来的
     * */
    // 写法一
    loginAPI3(responseResult = { msg, code ->
        ""
    })
    // 写法二
    loginAPI3({ msg, code ->
        ""
    })
    // 写法三
    loginAPI3() { msg, code ->
        ""
    }
    // 写法四
    loginAPI3 { msg, code ->
        ""
    }
}

fun loginAPI3(responseResult: (String, Int) -> Unit) {
}

const val USER_NAME_DB = "username"
const val USER_PWD_DB = "password"

/**
 * 函数中定义的参数是函数
 * responseResult: (String, Int) -> Unit    lambda的声明，相当于Java的接口
 * */
public fun loginAPI(username: String, password: String, responseResult: (String, Int) -> Unit) {
    /**
     * kotlin中 === 为引用的比较，相当于Java的==
     * kotlin中 == 为值的比较，相当于Java的equals
     * */
    if (username == null || password == null) {
        // 用户名密码校验不合格抛出异常
        TODO("用户名或密码为空")
    }

    // 模拟前端验证
    if (username.length > 3 && password.length > 3) {
        println("执行登录调用")
        if (webServiceLoginAPI(username, password)) {
            // 登录成功
            responseResult("login success data{...}", 200)
        } else {
            // 登录失败
            responseResult("login failed", 400)
        }
    } else {
        TODO("用户名或密码长度不大于3")
    }
}

private fun webServiceLoginAPI(username: String, password: String): Boolean {
    return if (username == USER_NAME_DB && password == USER_PWD_DB) true else false
}

public fun test(user: String, pwd: String, lambdafun1: (String, Int) -> Unit, lambdafun2: (String) -> Unit) {
    lambdafun1("第一个lambda表达式", 200)
    lambdafun2("第二个lambda表达式")
}