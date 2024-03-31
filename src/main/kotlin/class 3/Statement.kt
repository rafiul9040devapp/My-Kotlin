package `class 3`

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import javax.swing.text.DateFormatter

fun main(){
    val date = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("MMMM dd yyyy")
    val formattedDate = date.format(formatter)
    println(date)
    println(formattedDate)

    val dayOfWeek = date.dayOfWeek
    weekChecker(dayOfWeek)
    val month = date.month
    monthChecker(month)

    println("Enter The Day Number Of Week: ")
    val dayInWeek = readLine()!!
    weekChecker(dayInWeek.toInt())

    println("Enter The Day Number Of Month: ")
    val dayInMonth = readLine()!!
    monthChecker(dayInMonth.toInt())



}

fun monthChecker(month: Month?) {
    when(month){
        Month.JANUARY -> println("It's JANUARY")
        Month.FEBRUARY -> println("It's FEBRUARY")
        Month.MARCH -> println("It's MARCH")
        Month.APRIL -> println("It's APRIL")
        Month.MAY -> println("It's MAY")
        Month.JUNE -> println("It's JUNE")
        Month.JULY -> println("It's JULY")
        Month.AUGUST -> println("It's AUGUST")
        Month.SEPTEMBER -> println("It's SEPTEMBER")
        Month.OCTOBER -> println("It's OCTOBER")
        Month.NOVEMBER -> println("It's NOVEMBER")
        Month.DECEMBER -> println("It's DECEMBER")
        else -> {
            println("Invalid.....")
        }
    }
}

fun monthChecker(numberOfMonth: Int){

    when(numberOfMonth){
        1-> println("It's JANUARY")
        2-> println("It's FEBRUARY")
        3->  println("It's MARCH")
        4-> println("It's APRIL")
        5-> println("It's MAY")
        6-> println("It's JUNE")
        7-> println("It's JULY")
        8-> println("It's AUGUST")
        9-> println("It's SEPTEMBER")
        10-> println("It's OCTOBER")
        11-> println("It's NOVEMBER")
        12-> println("It's DECEMBER")
        else -> println("Invalid.....")
    }

}

fun weekChecker(week: DayOfWeek){

    when(week){
        DayOfWeek.MONDAY -> println("It's MONDAY")
        DayOfWeek.TUESDAY -> println("It's TUESDAY")
        DayOfWeek.WEDNESDAY -> println("It's WEDNESDAY")
        DayOfWeek.THURSDAY -> println("It's THURSDAY")
        DayOfWeek.FRIDAY -> println("It's FRIDAY")
        DayOfWeek.SATURDAY -> println("It's SATURDAY")
        DayOfWeek.SUNDAY -> println("It's SUNDAY")
    }
}

fun weekChecker(numberOfDay:Int){
    when(numberOfDay){
        1-> println("It's MONDAY")
        2-> println("It's TUESDAY")
        3-> println("It's WEDNESDAY")
        4-> println("It's THURSDAY")
        5-> println("It's FRIDAY")
        6-> println("It's SATURDAY")
        7-> println("It's SUNDAY")
        else -> println("Invalid......")
    }
}

