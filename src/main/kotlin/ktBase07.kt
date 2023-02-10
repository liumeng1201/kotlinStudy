fun main() {
    /**
     * 之前例子里的匿名函数是正确的，但是随着匿名函数里面的特性越来越多，其实特性是lambda的，所以就慢慢的转变为lambda表达式
     * */

    /**
     * addResult变量的类型：输入是Int、Int，输出是String
     * */
    val addResult = { number1: Int, number2: Int ->
        "两个数相加的结果是${number1 + number2}"
    }

    /**
     * weekResultFun变量的类型：输入是Int，输出是Any
     * Any?（包含null值）
     * Any（不包含null值）
     * */
    val weekResultFun /* : (Int) -> Any */ = { week: Int ->
        when (week) {
            1 -> "星期一"
            2 -> "星期二"
            3 -> "星期三"
            else -> -1
        }
    }
}