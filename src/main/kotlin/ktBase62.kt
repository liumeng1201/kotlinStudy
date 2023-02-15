/**
 * map {返回类型：String Int Boolean... 是把每一个元素加入到新集合，最后返回新集合List<T>}
 * flatMap {返回类型：每一个元素转变成集合... 把每一个集合加入到新集合，最后返回新集合List<List<T>>，但内部会做扁平化 List<T>}
 * flatMap 原理 就是把匿名函数最后一行的返回值（又是一个集合listof(...)）加入一个新的集合，并且返回集合
 * */

fun main() {
    val list: List<String> = listOf("张三", "李四", "王五", "赵六")
    val list2: List<String> = list.map {
        "你的名字是${it}"
    }.map {
        // println(it)
        "$it 你名字的长度是${it.length}"
    }.flatMap {
        // flatmap 返回是一个集合
        listOf("${it} 在学Java", "${it} 在学kotlin")
    }
    println(list2)
    /*
    [你的名字是张三 你名字的长度是7 在学Java, 你的名字是张三 你名字的长度是7 在学kotlin,

    你的名字是李四 你名字的长度是7 在学Java, 你的名字是李四 你名字的长度是7 在学kotlin,
    
    你的名字是王五 你名字的长度是7 在学Java, 你的名字是王五 你名字的长度是7 在学kotlin,

    你的名字是赵六 你名字的长度是7 在学Java, 你的名字是赵六 你名字的长度是7 在学kotlin]
    */
}