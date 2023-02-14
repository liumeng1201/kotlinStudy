class Body(_bodyInfo: String) {
    val bodyInfo: String = _bodyInfo

    fun show() {
        Head().show()
    }

    /**
     * inner 关键字修饰的是内部类
     * 内部的类 能访问 外部的类
     * 外部的类 能访问 内部的类
     * */
    inner class Head {
        fun show() {
            println("${bodyInfo} 的头")
        }
    }

    inner class Hand {
        inner class LeftHand {
            fun work() {
                println("${bodyInfo} 的左手开始工作")
            }
        }

        inner class RightHand {
            fun work() {
                println("${bodyInfo} 的右手开始工作")
            }
        }
    }

    /**
     * 嵌套类
     * 外部的类能访问内部嵌套类的成员
     * 内部嵌套的类不能访问外部类的成员
     * */
    class Heart {
        fun run() {
            println("心脏开始跳动")
            Body("hehe").show()
        }
    }
}

fun main() {
    Body("小米").show()
    Body("小米").Head().show()
    Body("小米").Hand().LeftHand().work()
    Body("小米").Hand().RightHand().work()

    Body.Heart().run()
}