class RxJavaCoreValue<T>(var value: T)

inline fun <CREATE_OUTPUT> create(createAction: () -> CREATE_OUTPUT): RxJavaCoreValue<CREATE_OUTPUT> {
    val createResult = createAction()
    return RxJavaCoreValue(createResult)
}

inline fun <INPUT, OUTPUT> RxJavaCoreValue<INPUT>.map(mapAction: INPUT.() -> OUTPUT): RxJavaCoreValue<OUTPUT> {
    val mapResult = mapAction(this.value)
    return RxJavaCoreValue(mapResult)
}

inline fun <INPUT> RxJavaCoreValue<INPUT>.observer(observerAction: INPUT.() -> Unit): Unit {
    observerAction(this.value)
}

fun main() {
    create {
        "*初始的内容*"
    }.map {
        "||格式变换$this"
    }.map {
        "&&再次变换$this"
    }.observer {
        println("最终消费 $this")
    }
}