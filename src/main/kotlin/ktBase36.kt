/**
 * object 对象声明
 * object K36 既是单例的实例，又是类名，只有一个创建，这就是典型的单例
 * */
object K36 {
    // object对象类不能再重新构造方法
    init {
        println("K36 init...")
    }

    fun show() {
        println("这是K36的show函数")
    }

    /*
     object对象类(单利模式) 背后做的事情
     public static final K36 INSTANCE;
     private K36() {} // 废除主构造方法
     // 这个区域是 object 不同点
     static {
        K36 var0 = new K36();
        INSTANCE = var0;
        // 将 init 代码块在这里执行（因为主构造被私有化，相当于废除，init代码块无法在主构造中执行所以搬到这里执行）
        String var1 = "K36 init...";
        System.out.println(var1);
     }
     public final void show() {
        String var1 = "这是K36的show函数";
        System.out.println(var1);
     }
     */
}

fun main() {
    K36.show()

    // K36是单利模式，不管被调用多少次其指向的均是同一个实例
    println(K36)
    println(K36)
}