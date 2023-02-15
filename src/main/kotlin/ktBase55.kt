class K55(val name: String, val age: Int, val sex: Char, val info: String)

/**
 * 扩展函数
 * 假设 K55 类是另外一个库中的类，通过扩展函数可直接为其添加方法，同时也可获取其中的成员信息
 * 扩展函数不允许重复定义，但对于kotlin中内置的扩展函数可以重新，并且在调用时会直接调用重新的扩展函数
 * 扩展函数默认公开，若不想被其他人员使用可定义为私有
 * */
fun K55.show() {
    println("我是K55类的扩展函数，name=${name}, age=${age}, sex=${sex}, info=${info}")
}

// 给K55类增加扩展函数
fun K55.getInfo(): String = "info信息的内容是：$info"

// 给String类增加扩展函数
// this 指代调用者本身
fun String.addExtAction(number: Int) = this + "@".repeat(number)
/*
背后的Java代码实现
   public static final String addExtAction(@NotNull String $this$addExtAction, int number) {
      Intrinsics.checkNotNullParameter($this$addExtAction, "$this$addExtAction");
      return $this$addExtAction + StringsKt.repeat((CharSequence)"@", number);
   }
*/

data class ResponseResult1(val msg: String, val code: Int)

// 对 Any 最超类进行扩展
fun Any.showPrintContent() = println("打印的内容是：${this}")

fun main() {
    K55("hehe", 14, '男', "info信息").show()
    println("heihei".addExtAction(4))

    ResponseResult1("hehe", 200).showPrintContent()
    K55("hehe", 14, '男', "info信息").showPrintContent()
    "stringcontent".showPrintContent()
}