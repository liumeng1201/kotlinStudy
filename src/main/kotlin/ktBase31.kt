/**
 * lateinit 是在使用的时候手动加载的懒加载方式
 * by lazy 是在使用的时候，自动加载的懒加载方式。惰性加载
 * */

class K31 {
    // val loadDataBase1: String = loadDatabaseAction()

    // 懒加载方式，仅在使用时才加载相关操作，未使用时不进行初始化
    val loadDataBase2 by lazy { loadDatabaseAction() }

    private fun loadDatabaseAction(): String {
        println("即将开始加载数据")
        println("数据加载中...")
        println("数据加载中...")
        println("数据加载完成")
        return "database load finish"
    }
}

fun main() {
    val p = K31()
    println("即将开始使用，等待3秒")
    Thread.sleep(3000)
    println("最终显示：${p.loadDataBase2}")
}