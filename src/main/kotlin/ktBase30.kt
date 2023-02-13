class K30 {
    // lateinit val A:String 这种写法不允许，val是只读的，后面无法进行延迟初始化
    // responseResultInfo先进行定义，后面再进行初始化，所以没有赋值
    // 在使用 lateinit 延迟初始化字段时，一定要使用 if (::responseResultInfo.isInitialized) 来判断是否进行了初始化
    lateinit var responseResultInfo: String

    // 延时初始化，属于懒加载，用到的时候再进行初始化
    fun loadResponse() {
        responseResultInfo = "服务器加载成功"
    }

    fun showResponse() {
        // 如果使用此方法之前未完成初始化，此处会奔溃，因为responseResultInfo尚未初始化，无法被使用
        // if (responseResultInfo == null) println()

        if (::responseResultInfo.isInitialized){
            println("responseResultInfo初始化完成，可以使用")
        } else {
            println("responseResultInfo尚未初始化，不可使用")
        }
    }
}

fun main() {
    val p = K30()
    p.loadResponse()
    p.showResponse()
}