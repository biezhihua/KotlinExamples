package examples

import kotlin.properties.Delegates

class User3 {
    var name: String by Delegates.notNull<String>()

    fun init(name: String) {
        this.name = name;
    }
}

fun main(args: Array<String>) {

    val user = User3()
    user.init("biezhihua")
    println(user.name)
}