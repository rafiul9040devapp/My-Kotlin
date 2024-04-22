package safety

// ()  =
data class User(
    val id: Int,
    val name: String?,
    val email: String?
)

fun getEmailLength(user: User?): Int = user?.email?.takeIf {it.isNotBlank() }?.length ?: -1

fun printUserNameLength(user: User?) {
    user?.name.let {
        if (it.isNullOrBlank()) {
            println("Name is null")
        } else {
            println("Length Of User Name: ${it.length}")
        }
    }
}

fun getEmailOrPlaceholder(user: User?): String {
    user?.email.let {
        return if (it.isNullOrBlank()) {
            "No Email Provided"
        } else {
            it
        }
    }
}

fun main() {
    val user1 = User(1, "John Doe", "john@example.com")
    val user2 = User(2, null, "jane@example.com")
    val user3 = User(3, "Alice", null)

//    val user1 = User(1, "John Doe", "  ")
//    val user2 = User(2, "  ", "jane@example.com")
//    val user3 = User(3, "Alice", null)

    when (val emailLength = getEmailLength(user1)) {
        -1 -> println("No Email Provided")
        else -> println("Email Length: $emailLength")
    }
    printUserNameLength(user2)
    println("Email or Placeholder:  ${getEmailOrPlaceholder(user3)}")
}
