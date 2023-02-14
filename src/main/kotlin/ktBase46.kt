interface IUSB {
    var versionInfo: String
    var deviceInfo: String
    fun insertUSB()
}

class Mouse(
    override var versionInfo: String = "USB3.0",
    override var deviceInfo: String = "鼠标"
) : IUSB {
    override fun insertUSB() {
        println("设备${deviceInfo}，版本${versionInfo}，插入了USB口")
    }
}

class KeyBoard : IUSB {
    override var versionInfo: String = "USB3.0"
        get() {
            println("获取版本号${field}")
            return field
        }
        set(value) {
            println("设置版本号${value}")
            field = value
        }

    override var deviceInfo: String = "键盘"
        get() {
            println("获取设备信息${field}")
            return field
        }
        set(value) {
            println("设置设备信息${value}")
            field = value
        }

    override fun insertUSB() {
        println("设备${deviceInfo}，版本号${versionInfo}，插入了USB口")
    }

}

/**
 * 接口里的所有成员和接口本身都是 public open 的，不需要额外设置，接口是开放的
 * 接口不能有主构造，定义接口时不能加 ()
 * 实现类不仅要重写接口方法，也要重新接口的成员
 * 接口实现代码区域，全部都要增加 override 关键字来修饰
 * */

fun main() {
    val mouse: IUSB = Mouse()
    mouse.insertUSB()

    val keyBoard: IUSB = KeyBoard()
    keyBoard.insertUSB()
}


/**
 * 接口应当只定义规则，不进行实现
 * 在声明时可以对接口进行默认实现，但这样是不规范的
 * */
interface IUSB2 {
    val versionInfo: String
        get() = "xxx"
}