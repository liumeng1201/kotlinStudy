fun main() {
    // 匿名函数
    showPersonInfo("詹三", 18, "学习kotlin中") {
        println("匿名函数 显示结果：$it")
    }

    // 具名函数
    showPersonInfo("詹四", 28, "学习中", ::showResultImpl)
}

fun showResultImpl(it: String) {
    println("具名翰视 显示结果：$it")
}

inline fun showPersonInfo(name: String, age: Int, study: String, showResult: (String) -> Unit) {
    val str = "name=$name, age=$age, study=$study"
    showResult(str)
}