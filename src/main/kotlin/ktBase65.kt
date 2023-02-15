@file:JvmName("Stu")
// 上面的注解可以修改kotlin文件生成的Java类的名字，类名会变更为 Stu

class Person65 {
    /**
     * 不加JvmField注解时在Java中要通过 Person65().getNames 方法来获取值
     * 加入注解后则可通过 Person65().names 来获取值
     * */
    @JvmField
    val names = listOf("a", "bb", "ccc")

    companion object {
        /**
         * 加入JvmStatic注解后，在Java代码中即可直接调用该方法，而不再需要通过内部类的方式进行调用
         * */
        @JvmStatic
        fun showAction(name: String) = println(name)
    }
}

/**
 * 通过 JvmOverloads 该注解为Java重载一个 sex参数带默认值的test方法
 * 不加JvmOverloads注解，在Java中调用时必须传递全部两个参数的值
 * */
@JvmOverloads
fun test(msg: String, sex: Char = 'M') {
}

fun main() {
    val info1 = ktBase65Java().info1

    /**
     * kotlin在与Java交互时，若返回的数据类型带有！则表示有为null的可能，在接收时使用 类型? 的形式
     * */
    val info2: String? = ktBase65Java().info2

    println(info1.length)
    println(info2?.length)
}