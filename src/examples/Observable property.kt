package examples

import kotlin.properties.Delegates

class User2 {
    var name: String by Delegates.observable("no name", { prop, old, new ->
        println("prop $prop old - $old new - $new")
    })

    var name2: String by Delegates.vetoable("no name2", { prop, old, new ->
        println("prop $prop old - $old new - $new")
        true
    })
}

fun main(args: Array<String>) {
    val user = User2()
    user.name = "Carl"

    user.name2 = "Bzh"

    println(user.name + " " + user.name2)
}