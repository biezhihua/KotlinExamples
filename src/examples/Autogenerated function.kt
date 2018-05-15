package examples


fun main(args: Array<String>) {
    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser : ${user == secondUser}")
    println("user == thirdUser : ${user == thirdUser}")

    // copy function
    println(user.copy())
    println(user.copy(name = "biezhihua"))
    println(user.copy(id = 2))
    println(user.copy(name = "max", id = 2))


}