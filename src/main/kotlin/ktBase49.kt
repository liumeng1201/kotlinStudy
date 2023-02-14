fun <I, O> map(inputType: I, isReturn: Boolean = true, mapAction: (I) -> O) =
    if (isReturn) mapAction(inputType) else null

fun main() {
    val r: String? = map(123) {
        "这是数据返回${it}"
    }

    val r1: Int? = map("123") {
        it.toInt()
    }
}