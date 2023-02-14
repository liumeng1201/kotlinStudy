enum class Exam {
    Fraction1,
    Fraction2,
    Fraction3,
    Fraction4;
}

class Teacher(private val exam: Exam) {
    fun show(): String {
        // 使用枚举值进行判断，这个就属于代数数据类型，不再需要写else，因为when表达式可以判断是否已将所有可能列出
        // exam 代数数据类型
        return when (exam) {
            Exam.Fraction1 -> "分数较差"
            Exam.Fraction2 -> "分数及格"
            Exam.Fraction3 -> "分数良好"
            Exam.Fraction4 -> "分数优秀"
        }
    }
}

/**
 * 枚举类：在于控制状态数量可控
 * 密封类：在于控制子类数量可控，以免被非法继承
 * */

/**
 * 密封类
 * 成员必须有类型（object、class） 并且继承本类
 * */
sealed class Exams {
    object Fraction1 : Exams()
    object Fraction2 : Exams()
    object Fraction3 : Exams()
    class Fraction4(val studentName: String) : Exams()
}

class Teacher2(private val exams: Exams) {
    fun show(): String {
        return when (exams) {
            is Exams.Fraction1 -> "分数较差"
            is Exams.Fraction2 -> "分数及格"
            is Exams.Fraction3 -> "分数良好"
            is Exams.Fraction4 -> "分数优秀，该学生名字${exams.studentName}"
        }
    }
}

fun main() {
    println(Teacher(Exam.Fraction3).show())

    println(Teacher2(Exams.Fraction4("小五")).show())
}