package examples

fun main(args: Array<String>) {
    val numbers = listOf<Int>(1, 2, 3)
    println(numbers.filter(::isOdd))
    println(numbers.filter {
        it % 2 != 0
    })
}

fun isOdd(x: Int) = x % 2 != 0