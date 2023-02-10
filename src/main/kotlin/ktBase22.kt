import java.io.File

fun main() {
    funArray()
}

fun funArray() {
    /**
     * 数组类型，数组虽然是引用类型，背后可以编译为Java基本类型
     * IntArray intArrayOf
     * ...
     * BooleanArray booleanArrayOf
     *
     * Array    arrayOf 数组对象
     * */

    val intArray: IntArray = intArrayOf(10, 20, 30, 40, 50)
    println(intArray)

    println(intArray[0])
    // println(intArray[10]) // 越界奔溃
    println(intArray.elementAtOrElse(0) { -1 })
    println(intArray.elementAtOrElse(10) { -1 })
    println(intArray.elementAtOrNull(0) ?: "越界了")
    println(intArray.elementAtOrNull(10) ?: -1)

    val list: List<Char> = listOf('a', 'b', 'c', 'd', 'e')
    val charArray = list.toCharArray()
    println(charArray)

    // 对象数组
    val objectArray:Array<File> = arrayOf(File(""), File(""), File(""))
}