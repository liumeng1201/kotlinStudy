open class K37 {
    open fun add(info: String) {
        println("K37类 add info=${info}")
    }

    open fun del(info: String) {
        println("K37类 del info=${info}")
    }
}

class K37Impl : K37() {
    override fun add(info: String) {
        // super.add(info)
        println("具名对象 add info=${info}")
    }

    override fun del(info: String) {
        // super.del(info)
        println("具名对象 del info=${info}")
    }
}

interface RunnableKT {
    fun run()
}

fun main() {
    /**
     * 匿名 对象表达式 方式
     * object :   对象表达式
     * */
    val p: K37 = object : K37() {
        override fun add(info: String) {
            // super.add(info)
            println("匿名对象 add info=${info}")
        }

        override fun del(info: String) {
            // super.del(info)
            println("匿名对象 del info=${info}")
        }
    }
    p.add("haha")
    p.del("hehe")

    val p2: K37 = K37Impl()
    p2.add("小明")
    p2.del("小王")


    /**
     * Java接口，有两种写的方式，（object: 对象表达式）、（简洁版写法）
     * Kotlin接口，只有（object: 对象表达式）写法
     * */
    val p3: Runnable = object : Runnable {
        override fun run() {
            println("Java接口实现，方式一...")
        }
    }
    p3.run()

    val p4: Runnable = Runnable {
        println("Java接口实现，方式二，简洁版写法...")
    }
    p4.run()

    val p5: RunnableKT = object : RunnableKT {
        override fun run() {
            println("Kotlin接口实现...")
        }
    }
    p5.run()
}

