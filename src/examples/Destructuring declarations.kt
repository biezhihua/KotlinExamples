package examples

fun main(args: Array<String>) {
    val pair = Pair(1, "one")
    val (num, name) = pair
    println("num = $num, name = $name")
}

class Pair<out K, out V>(private val first: K, private val second: V) {

    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}
