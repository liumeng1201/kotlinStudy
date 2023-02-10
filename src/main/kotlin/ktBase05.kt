fun main() {
    /**
     * 函数输入输出声明及实现
     * */
    val actionMethod: (Int, Int, Int) -> String = { number1, number2, number3 ->
        "number1=${number1},number2=${number2},number3=${number3}"
    }

    /**
     * 函数调用，变量所描述的函数
     * */
    println(actionMethod(1, 2, 3))
}

fun actionMethod2(number1: Int, number2: Int, number3: Int): String {
    return "number1=${number1},number2=${number2},number3=${number3}"
}