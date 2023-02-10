fun main() {
    listCreateAndGet()

    canChangeList()

    funMutator()

    readList()

    jiegou()
}

fun listCreateAndGet() {
    /**
     * list创建与元素获取
     * 取值方式：索引
     * */
    val list: List<String> = listOf("张三", "李四", "王五", "赵六")
    println(list[0])
    println(list.get(0))

    // 下面取值的方式不会出现空指针异常及下标越界异常
    println(list.getOrNull(0))
    println(list.getOrNull(10))
    println(list.getOrNull(10) ?: "访问越界了")
    println(list.getOrElse(10) { "访问越界" })
}

/******************************/

fun canChangeList() {
    /**
     * 可变list
     * 可完成增加、删除操作
     * */
    val list: MutableList<String> = mutableListOf("张三", "李四", "王五", "赵六")
    list.add("就起")
    list.removeAt(2)
    println(list)

    // list2为不可变list，无法增加、删除
    val list2: List<String> = listOf("张三", "李四", "王五", "赵六")
    // 将不可变集合转变为可变集合
    val list3 = list2.toMutableList()
    list3.add("hahaha")
    println(list3)

    // 将可变集合转变为不可变集合
    val list4 = list.toList()
}

/*****************************/

fun funMutator() {
    /**
     * mutator函数
     * mutator的特性 += -= 其实背后是运算符重载
     * */

    val list: MutableList<String> = mutableListOf("张三", "李四", "王五", "赵六")
    list += "哈哈"
    list -= "李四"
    println(list)

    /**
     * removeIf
     * list.removeIf{true} 如果是true则自动遍历整个可变集合并一个一个的删除
     * */
    // list.removeIf { true }
    list.removeIf {
        it.contains("张")
    }
    println(list)
}

/*******************************/

fun readList() {
    /**
     * 集合遍历操作
     * */
    val list: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(list)
    for (item in list) {
        println("item=${item}")
    }

    list.forEach {
        println("item=${it}")
    }

    list.forEachIndexed { index, i ->
        println("item${index}=${i}")
    }
}

/*********************/

fun jiegou() {
    /**
     * 结构语法过滤元素
     * */
    val list: List<String> = listOf("张三", "李四", "王五")
    val (v1: String, v2: String, v3: String) = list
    println("v1=${v1},v2=${v2},v3=${v3}")

    // _ 不是变量，是用来过滤结构赋值的，拒收值。可以节约性能
    val (_: String, n2: String, n3: String) = list
}