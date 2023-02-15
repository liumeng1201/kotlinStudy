/**
 * vararg 动态参数
 * */

class K51<T>(vararg objects: T, val isMap: Boolean) {
    // out T只能被读取，不能修改
    private val objectArray: Array<out T> = objects

    fun showObj(index: Int): T? = objectArray[index].takeIf { isMap }

    fun <O> mapObj(index: Int, mapAction: (T?) -> O): O = mapAction(objectArray[index].takeIf { isMap })

    fun <O> mapObj2(index: Int, mapAction: (T?) -> O): O {
        return mapAction(objectArray[index].takeIf { isMap })
    }
}

fun main() {
    val p: K51<Any?> = K51("字符串", 123, 123.12, 123.12f, 'C', true, 'A', "hehe", isMap = true)
    p.showObj(0)
    p.showObj(1)

    val p2: K51<String> = K51("str1", "str2", "str3", "str4", isMap = true)
    p2.mapObj(0) {
        println("$it")
    }
}