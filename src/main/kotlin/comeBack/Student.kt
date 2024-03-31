package comeBack

class Student(var rollNumber: Int, name: String, age: Int) : HumanImpl(name, age) {

    override fun info() {
        super.info()
        println("Your Roll Number is : $rollNumber")
    }

    override fun eatingFood() {
        println("Students are going to eat healthy.....")
    }
}