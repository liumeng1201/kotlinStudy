// 在kotlin中枚举也是一个类
enum class Week {
    星期一,
    星期二,
    星期三,
    星期四,
    星期五,
    星期六,
    星期日
}

data class BodyInfo(var name: String, var length: Int)

// private val bodyInfo: BodyInfo  主构造参数private 私有化，是因为永远都是内部调用主构造，不给外界调用，所以可以写成 private
enum class BodyEnum(private val bodyInfo: BodyInfo) {
    RIGHT_HAND(BodyInfo("右手", 51)),
    LEFT_HAND(BodyInfo("左手", 52)),
    RIGHT_FOOT(BodyInfo("右脚", 112)),
    LEFT_FOOT(BodyInfo("左脚", 112))
    ; // 枚举结束标志

    fun show() = println("部位=${bodyInfo.name}, 长度=${bodyInfo.length}")

    fun updateBodyInfo(info: BodyInfo) {
        println("更新前信息 部位=${bodyInfo.name}, 长度=${bodyInfo.length}")
        this.bodyInfo.name = info.name
        this.bodyInfo.length = info.length
        println("更新后信息 部位=${bodyInfo.name}, 长度=${bodyInfo.length}")
    }
}

fun main() {
    // 输出 星期一
    // 枚举的值就是枚举本身
    println(Week.星期一)
    println(Week.星期三)

    // 输出 true
    println(Week.星期三 is Week)


    /**
     * 对于枚举使用时按照如下方式进行调用
     * 枚举类的主构造参数不需要关注，由枚举值来负责实例化并调用主构造方法
     * */
    BodyEnum.RIGHT_HAND.show()
    BodyEnum.LEFT_HAND.show()
    BodyEnum.RIGHT_FOOT.show()
    BodyEnum.LEFT_FOOT.show()

    BodyEnum.RIGHT_HAND.updateBodyInfo(BodyInfo("右手2", 55))

}