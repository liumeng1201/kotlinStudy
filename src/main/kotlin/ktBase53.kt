/**
 * out 协变，生产者
 * 表示次泛型只能被读取、获取不能进行修改
 * */
interface Producer<out T> {
    // fun set(value: T)  不允许对 T 进行修改

    // 仅允许获取 T
    // fun get(): T
    fun producer(): T
}

/**
 * in 逆变，消费者
 * 表示次泛型只能被修改、更新、插入，不能被读取
 * */
interface Consumer<in T> {
    // 仅允许修改
    // fun set(value: T)
    fun consumer(item: T)

    // fun get(): T  不能被读取
}

open class AnimalClass
open class HumanClass : AnimalClass()
class ManClass : HumanClass()
class WomanClass : HumanClass()

class AnimalProducer : Producer<AnimalClass> {
    override fun producer(): AnimalClass = AnimalClass()
}

class HumanProducer : Producer<HumanClass> {
    override fun producer(): HumanClass {
        return HumanClass()
    }
}

class ManProducer : Producer<ManClass> {
    override fun producer(): ManClass {
        return ManClass()
    }
}

class WomanProducer : Producer<WomanClass> {
    override fun producer(): WomanClass {
        return WomanClass()
    }
}

class AnimalConsumer : Consumer<AnimalClass> {
    override fun consumer(item: AnimalClass) {
        println("消费者${item}")
    }
}

class HumanConsumer : Consumer<HumanClass> {
    override fun consumer(item: HumanClass) {
        println("消费者${item}")
    }
}

class ManConsumer : Consumer<ManClass> {
    override fun consumer(item: ManClass) {
        println("消费者${item}")
    }
}

class WomanConsumer : Consumer<WomanClass> {
    override fun consumer(item: WomanClass) {
        println("消费者${item}")
    }
}

fun main() {

    /**
     * 默认情况下
     * 泛型的子类对象 不可以赋值给 泛型的父类对象
     * 泛型具体处的子类对象 不可以赋值给 泛型声明处的父类对象（与上句意思一样，不同的叫法）
     * List<CharSequence> list = new ArrayList<String>();            错误
     * List<? extends CharSequence> list = new ArrayList<String>();  正确
     * ? extends T 就相当于kotlin中的 out T，所以上面的赋值才成立（子类对象赋值给父类对象）
     *
     * 协变
     * 泛型声明处父类 接收 泛型具体处子类
     * */
    val p1: Producer<AnimalClass> = AnimalProducer()
    val p2: Producer<out AnimalClass> = HumanProducer()
    val p3: Producer<AnimalClass> = ManProducer()
    val p4: Producer<AnimalClass> = WomanProducer()
    // 另外一种写法，在使用处添加 out
    // val p5: Producer<out AnimalClass> = HumanProducer()

    /**
     * List<? super String> list = new ArrayList<CharSequence>();
     * ? super T 就相当于kotlin中的 in T，所以泛型的父类对象 赋值给 泛型子类对象
     *
     *
     * 逆变
     * 泛型声明处子类 接收 泛型具体处父类
     * 泛型具体处的父类对象 可以赋值给 泛型声明处的子类对象
     * */
    val p11: Consumer<AnimalClass> = AnimalConsumer()
    val p12: Consumer<ManClass> = AnimalConsumer()
    // 另外一种写法，在使用处添加 out
    // val p15: Consumer<in ManClass> = AnimalConsumer()
}

/**
 * 协变 out(? extends T)  父类=子类
 * 当泛型类里的方法只能读取不能修改时可使用协变 out
 *
 * 逆变 in(? super T)   子类=父类
 * 当泛型类里的方法只能设置、修改不能被读取时可以使用逆变 in
 * */