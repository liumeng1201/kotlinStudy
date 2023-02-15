fun funfilter() {
    val names: List<String> = listOf("aa1", "bb1", "cc1", "aa2", "bb2", "cc2", "aa22", "bb22", "cc22")
    println(names.filter {
        // it 是每一个元素的值
        it == "aa1" // 把过滤后的元素加入新集合，当为true的时候加入新集合，为false直接返回
    })

    println(names.filter {
        it.contains("cc")
    }.filter {
        it.contains("2")
    })
}

/**
 * zip 合并函数
 * */
fun funzip() {
    println()

    val names = listOf("张三", "李四", "王五")
    val ages = listOf(12, 13, 14)
    val nList: List<Pair<String, Int>> = names.zip(ages)
    println(nList)
    println(nList.toMap())
    println(nList.toMutableList())

    nList.forEach() {
        println(it.first + it.second)
    }
}

fun main() {
    funfilter()
    funzip()
}