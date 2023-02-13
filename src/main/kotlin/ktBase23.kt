fun main() {
    createMap()

    readMap()

    bianliMap()

    canChangeMap()
}

fun createMap() {
    /**
     * Map的创建
     * */
    // 第一种方式
    val map1: Map<String, Double> = mapOf<String, Double>("key1" to (1.22), "key2" to 2.2)
    println(map1)

    // 第二种方式
    val map2: Map<String, Double> = mapOf(Pair("k1", 2.2), Pair("k2", 3.12))
    println(map2)
}

fun readMap() {
    println()
    /**
     * Map的读取
     * */
    val map: Map<String, Int> = mapOf("key1" to 123, "key2" to 234)
    println(map)

    // 方式一
    println(map["key1"])
    // get与[] 完成等价
    println(map.get("key1"))
    println(map["xxxx"]) // map找不到对应的值时不会奔溃，会返回null

    // 方式二，能获取到则返回值，获取不到则返回-1
    println(map.getOrDefault("key1", -1))
    println(map.getOrDefault("key11", -1))

    // 方式三
    println(map.getOrElse("key1") { -1 })
    println(map.getOrElse("key11") { -1 })

    // 方式四，与Java一样获取不到数据会奔溃，尽量不要使用
    map.getValue("key1")
    // map.getValue("key11")
}

fun bianliMap() {
    println()
    /**
     * 遍历Map
     * */
    val map: Map<String, Int> = mapOf(Pair("key1", 123), "Key2" to 345, "key3" to 567)
    // 第一种方式
    map.forEach {
        // it 代表map中的每一个元素
        println("key=${it.key}, value=${it.value}")
    }
    // 第二种方式
    map.forEach { (key, value) ->
        // 用 key,value 来覆盖默认的it
        println("key=${key}, value=${value}")
    }
    // 第三种方式，与第一种方式等价，将it替换为item
    for (item: Map.Entry<String, Int> in map) {
        println("key=${item.key}, value=${item.value}")
    }
}

fun canChangeMap() {
    println()
    /**
     * 可变Map
     * */
    // 对map的操作 += -= [] put
    val map: MutableMap<String, Int> = mutableMapOf("k1" to 123, "k2" to 234, "k3" to 345)
    map += "AAA" to 456
    map += Pair("BBB", 567)
    map -= "k2"

    map["CCC"] = 678
    // map[] 与 map.put 等价
    map.put("DDD", 789)

    println(map)

    // map.getOrPut 如果整个map里没有key为“FFF”的元素，就先添加此元素("FFF", 555)到map中去，然后再从map中获取key为”FFF“的元素
    val vv = map.getOrPut("FFF") { 555 }
    println(vv)
    println(map)
    // 当能获取到key对应的元素时则不再进行添加并直接返回key对应的value
    val vn = map.getOrPut("CCC") { 666 }
    println(vn)
    println(map)
}