package examples

fun main(args: Array<String>) {
    val map = hashMapOf<String, Int>()
    map["one"] = 1
    map["two"] = 2

    for ((key, value) in map) {
        println("key = $key value = $value")
    }

}