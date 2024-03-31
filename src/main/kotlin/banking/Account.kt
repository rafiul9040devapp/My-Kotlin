package banking

open class Account(var accountName: String, var balance: Double) //it is the constructor & the attribures of the
// class
{
    open fun deposite(amount: Double) {
        balance += amount
        println("After add $amount in the $accountName New Balance is: $balance")
    }

    open fun withdral(amount: Double) {
        if (amount > balance) {
            println("Insufficient Amount")
        } else {
            balance -= amount
            println("After withdrawing: $amount")
            println("New Balance is: $balance")
        }
    }

    open fun printBalance(){
        println("Balance of $accountName is : $balance")
    }
}