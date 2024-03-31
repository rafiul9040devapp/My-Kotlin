package comeBack

class Worker(private var workerID: String, name: String, age: Int) : HumanImpl(name, age) {

    override fun info() {
        super.info()
        println("Your WorkerID is: $workerID")
    }

    override fun walkingAround() {
        println("They walk around the whole field")
    }

}