/**
 * companion object 伴生对象
 * 伴生对象的由来：在kotlin中是没有（Java的static静态），伴生很大程度上和（Java的static静态）差不多
 * 不管 K38() 构建对象多少次，伴生对象只有一次加载
 * 不管 K38.showInfo() 调用多少次，伴生对象只有一次加载
 * 伴生对象只会初始化一次
 * */
class K38 {
    companion object {
        val name: String = "歌手"
        val info: String = "歌曲名"
        fun showInfo() {
            println("显示信息 name=${name}, info=${info}")
        }
    }
}

fun main() {
    println(K38.name)
    println(K38.info)
    K38.showInfo()
}