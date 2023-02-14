abstract class Activity {
    fun onCreate() {
        setContentView(getLayoutID())
        initView()
        initData()
    }

    private fun setContentView(layoutID: Int) = println("加载${layoutID}布局xml")

    abstract fun getLayoutID(): Int
    abstract fun initView()
    abstract fun initData()
}

class MainActivity : Activity() {
    override fun getLayoutID(): Int = 123123

    override fun initView() = println("初始化view")

    override fun initData() = println("初始化data")

    fun show() = super.onCreate()
}

fun main() {
    var mainActivity: MainActivity = MainActivity()
    mainActivity.show()
}