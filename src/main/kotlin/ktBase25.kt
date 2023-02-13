/**
 * 主构造函数
 * 按照规范参数应当为 _xxx 的形式，并且这些参数是临时的输入类型，不能直接使用，需要接收下来成为变量才能使用
 * */
class Students(_name: String, _sex: Char, _age: Int, _info: String) {
    private var name: String = _name
        get() = field  // get 不允许被私有化
        set(value: String) {
            field = value
        }

    private val sex: Char = _sex
        get() = field
    // set(value) {}   val只读类型没有set方法

    private val age: Int = _age
        get() = if (field < 0 || field > 200) -1 else field

    private val info: String = _info
        get() = field.capitalize()

    fun show() {
        // println(_name) 这种使用方式是不允许的
        println(name)
        println(sex)
        println(age)
        println(info)
    }
}

fun main() {
    val student = Students("张三", '男', 18, "大学生")
    student.show()
}