package comeBack

open class HumanImpl(var name:String, var age: Int): Human {

   open fun info(){
        println("Your name is: $name. Your age is : $age")
    }

    override fun eatingFood() {
        TODO("Not yet implemented")
    }

    override fun walkingAround() {
        TODO("Not yet implemented")
    }

    override fun havingFun() {
        TODO("Not yet implemented")
    }
}