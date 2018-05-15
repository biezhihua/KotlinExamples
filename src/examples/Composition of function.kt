package examples

fun main(args: Array<String>) {
    val oddLength = compose(::isOdd2, ::length2)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))
}

fun isOdd2(x: Int) = x % 2 != 0
fun length2(s: String) = s.length

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> val g1 = g(x)
        println(g1)
        val f1 = f(g1)
        println(f1)
        f1
    }
}