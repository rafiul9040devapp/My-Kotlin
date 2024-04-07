package equality

fun main() {
    println("How much lines you want to print?")
    val lines = readLine()?.toIntOrNull() ?: 0

    if (lines != 0 && lines > 0) {
        printingLines(lines)
    } else {
        println("Invalid Input")
    }
}

fun printingLines(lines: Int) {
    var isOddPrintedOnce = true
    for (i in 1..lines) {
        if (isEvenNumber(i)) {
            println("+-+-+")
        } else {
            isOddPrintedOnce = if (isOddPrintedOnce) {
                println("-----")
                false
            } else {
                println("-+-+-")
                true
            }
        }
    }
}

fun isEvenNumber(number: Int): Boolean = number % 2 == 0
