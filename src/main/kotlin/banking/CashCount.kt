package banking

fun main() {
    println("Enter your Amount: ")
    val inputAmount = readLine()?.toIntOrNull() ?: 0

    val notes = listOf<Int>(1000, 500, 200, 100, 50, 20, 10, 5, 2, 1)

    if (inputAmount==0){
        println("Invalid Amount")
    }else{
        //this is solved with loop
        calculateTheSmalledAmount(inputAmount,notes)

        println("---------Alternative Solution---------")

        //recursion is followed
        calculateTheSmalledAmountAlternative(inputAmount,notes,0)

        //in the both approach complexity is O(n)

    }

}

fun calculateTheSmalledAmount(inputAmount: Int, notes: List<Int>) {
    var remainingAmount = inputAmount

    //need to check for each note and so loop is used
    notes.forEach{ note->
        //finding out the number of notes
        val countNotes = remainingAmount / note

        //remaining amount for breaking it to small notes
        remainingAmount %= note

        //printing the note numbers
        if (countNotes ==0 || countNotes >0){
            println("$countNotes Note(s) of $note")
        }
    }
}

fun calculateTheSmalledAmountAlternative(inputAmount: Int, notes: List<Int>, index: Int) {
    //break down point of the recursion
    if ( inputAmount== 0) return

    //getting the specific bank note
    val currentNote = notes[index]

    //finding out the number of notes
    val count = inputAmount / currentNote

    //remaining amount for breaking it to small notes
    val remainingAmount = inputAmount % currentNote

    //printing the note numbers
    if (count >0){
        println("$count Note(s) of $currentNote")
    }

    //instead of using the loop the recursion approach is followed
    //I mean the method is called again to do the calculation
    calculateTheSmalledAmountAlternative(remainingAmount,notes,index+1)
}


