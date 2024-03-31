package comeBack

class Teacher(name:String,age:Int,var department: String):HumanImpl(name, age) {
    override fun info() {
        super.info()
        println("Your Department is: $department")
    }
}