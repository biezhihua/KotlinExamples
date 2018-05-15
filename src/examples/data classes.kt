package examples

data class User(val name: String, val id: Int)

fun getUser(): User {
    return User("biezhihua", 18)
}

fun main(args: Array<String>) {
    val user = getUser()
    println("name = ${user.name} id = ${user.id}")

    val (name, id) = getUser()
    println("name = $name id = $id")

    println("name = ${getUser().component1()} id = ${getUser().component2()}")
}