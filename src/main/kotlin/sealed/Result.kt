package sealed

sealed class Result

class Success(val message: String):Result()
class Error(val error: Throwable):Result()

