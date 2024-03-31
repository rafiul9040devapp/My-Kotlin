package coroutine

class User {
    private suspend fun getAllUser() : List<String> = buildList {
        add(getUser(1))
        add(getUser(2))
        add(getUser(3))
    }

    private suspend fun getUser(id:Int): String{
        return "User $id"
    }
}




