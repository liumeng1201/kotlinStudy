package lm.utils

/**
 * 扩展文件
 * 可以把常用的操作，写在一个地方，在使用的时候引入过来
 * */

fun <T> Collection<T>.randomItemValue() = this.shuffled().first()
fun <T> Collection<T>.randomItemValuePrint() = println(this.shuffled().first())