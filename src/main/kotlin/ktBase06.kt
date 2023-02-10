fun main() {
    /**
     * it关键字
     * it只针对一个参数，如果是多个参数it就不会自动增加
     * */

    val actionMethod: (Int, Int, Int) -> String = { n1, n2, n3 -> // 参数数量大于3，就不会有it
        // 输入参数会自动去找前面的输入类型定义
        "n1=$n1, n2=$n2, n3=$n3"
    }
    println(actionMethod(1, 2, 3))

    val actionMethod2: (String) -> String = {// 参数只有1个，默认用it来表示参数
        "it=$it"
    }
    println(actionMethod2("参数"))

    /**
     * fun1 为变量，不是匿名函数，fun1来接收匿名函数的返回值
     * 不声明匿名函数的输入类型、输出类型，由类型断定来自动确定类型
     * */
    val fun1 = { v1: String, v2: Float, v3: Int -> // 输入参数除了名称外还需要指定类型
        "输出结果：v1=$v1，v2=$v2，v3=$v3"
    }
    println(fun1("123", 1.23f, 2))
}