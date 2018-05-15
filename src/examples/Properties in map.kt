package examples

class User4(map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main(args: Array<String>) {
    val name = "name" to "John Doe"
    val name1 = "name" to "John Doe 1"
    val age = "age" to 25
    val age1 = "age" to 26
    val map = mapOf(name, age, name1, age1)
    val user = User4(map)

    println("name = ${user.name}, age = ${user.age}")
}