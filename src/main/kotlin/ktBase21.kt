fun main() {
    funSet()

    canChangeGet()

    funFransform()
}

fun funSet() {
    /**
     * set
     * set集合不会出现重复元素
     * */
    val set: Set<String> = setOf("zhangsan", "lisi", "wangwu", "zhaoliu", "lisi", "zhaoliu")
    println(set)

    // set集合不能使用普通方式进行数据访问或越界奔溃，可以使用 set.elementAt(index) 来访问
    println(set.elementAt(0))
    println(set.elementAt(1))
    // set.elementAt(9) 这样访问依然会越界奔溃
    // 尽量使用下面的方式防止奔溃
    println(set.elementAtOrElse(0) { "找不到此元素" })
    println(set.elementAtOrElse(10) { "找不到此元素" })
    println(set.elementAtOrNull(0) ?: "找不到此元素了")
    println(set.elementAtOrNull(10) ?: "找不到此元素了")
}

fun canChangeGet() {
    /**
     * 可变set
     * 如果需要对set集合进行添加、删除等可变操作时才用 MutableSet 否则均使用 Set
     * */
    val set: MutableSet<String> = mutableSetOf("张三", "李四")
    set += "王五"
    set += "赵六"
    set -= "李四"
    set.add("呵呵")
    set.remove("赵六")
    println(set)
}

/***********************/
/**
 * list 去重
 * */
fun funFransform() {
    // list 集合可以有重复
    val list: MutableList<String> = mutableListOf("Derry", "Derry", "zhangsan", "lisi", "zhangsan", "wangwu")
    println(list)

    // 将list转为set可自动去重
    val set = list.toSet()
    println(set)

    val list2 = list.toSet().toList()
    println(list2)

    // 快捷函数去重
    println(list.distinct())
}