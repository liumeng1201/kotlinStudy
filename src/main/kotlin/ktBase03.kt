fun main() {
    var nameLength : Int = "BHawK".count()
    println("BHawK名字长度是:${nameLength}")

    nameLength = "BHawK".count(){
        /**
         * "string".count(){}  表示是一个匿名函数
         * 会依次给这个函数传递Char类型变量 B H a w K
         * 由于没有名字，会默认给这个Char一个名字，一般情况下，在kotlin中都是it
         * 因此可以在函数中直接使用 it 变量名
         * */
        it == 'a' // 如果it等于字符a则返回ture并进行计数
    }
    println("BHawK 重新匿名函数count后 符合a的 长度是${nameLength}")
}