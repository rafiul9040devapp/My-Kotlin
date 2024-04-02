package task

data class Task(
    val taskName: String?,
    var isCompleted: Boolean = false
)

fun main() {
    var taskList = mutableListOf<Task>()
    while (true) {
        showMenuOptions()
        when (readLine()?.toIntOrNull() ?: 0) {
            1 -> {
                if (taskList.isNotEmpty()) showTaskList(taskList) else println("Empty Task List")
            }
            2 -> addTask(taskList)
            3 -> {
                if (taskList.isNotEmpty()) removeTask(taskList) else println("Empty Task List")
            }
            4 -> {
                if (taskList.isNotEmpty()) updateTaskStatus(taskList) else println("Empty Task List")
            }
            5 -> return
        }
    }
}

fun showMenuOptions() {
    println("Choose An Option....")
    println("1.Show The Task List ")
    println("2.Add Task")
    println("3.Remove Task")
    println("4.Update Task Status")
    println("5.Exit")
}

fun showTaskList(taskList: MutableList<Task>) {
    println("------------Task List-------------")
    println("ID  TASK       Status")
    taskList.forEachIndexed { index, task ->
        val status = if (task.isCompleted) "COMPLETED" else "PENDING"
        println("${index + 1}. ${task.taskName?.uppercase()}        $status")
    }
}

fun addTask(taskList: MutableList<Task>) {
    println("Enter TASK name:")
    val nameOfTask = readLine() ?: " "
    if (nameOfTask.isNotEmpty() || nameOfTask.isNotBlank()) {
        taskList.add(Task(nameOfTask))
        println("$nameOfTask is added Successfully")
    } else {
        println("Invalid Task Name")
    }
}

fun removeTask(taskList: MutableList<Task>) {
    println("Enter Task Name or ID: ")
    val removeTask = readLine() ?: ""

    val taskIndex = removeTask.toIntOrNull()
    val taskToRemove = if (taskIndex != null) {
        val index = taskIndex - 1
        if (index in taskList.indices) taskList[index] else null
    } else {
        taskList.find { task -> task.taskName.equals(removeTask, ignoreCase = true) }
    }

    if (taskToRemove != null) {
        taskList.remove(taskToRemove)
        println("${taskToRemove.taskName} is removed")
    } else {
        println("Task not found")
    }
}


fun updateTaskStatus(taskList: MutableList<Task>) {
    println("Enter TASK name:")
    val nameOfTask = readLine() ?: " "

    if (nameOfTask.isNotEmpty() || nameOfTask.isNotBlank()) {
        val updatedTask = taskList.find { task ->
            task.taskName.equals(nameOfTask, false)
        }
        if (updatedTask != null) {
            println("Enter The Status Of The Task")
            println("For Completed Enter: C")
            println("For Pending Enter: P")
            val statusOfTask = readLine() ?: ""
            when (statusOfTask.uppercase()) {
                "C" -> {
                    updatedTask.isCompleted = true
                    println("Task Status is Updated")
                }
                "P" -> updatedTask.isCompleted = false
                else -> println("Invalid Input")
            }
        } else {
            println("$nameOfTask is not found")
        }
    }
}

//fun removeTaskOriginal(taskList: MutableList<Task>) {
//    println("Enter Task Name OR ID: ")
//    val removeTask = readLine() ?: " "
//    val taskIndex = removeTask.toIntOrNull()
//
//    if (taskIndex != null) {
//        val index = taskIndex - 1
//        if (index in 0 until taskList.size) {
//            val taskIsRemoved = taskList.removeAt(index)
//            println("${taskIsRemoved.taskName} is removed")
//        } else {
//            println("Invalid Index $taskIndex")
//        }
//    } else if (removeTask.isNotEmpty() || removeTask.isNotBlank()) {
//        val isTaskFound = taskList.find { task ->
//            task.taskName.equals(removeTask, false)
//        }
//        if (isTaskFound != null) {
//            taskList.remove(isTaskFound)
//            println("${isTaskFound.taskName} is removed successfully")
//        } else {
//            println("$removeTask is not found")
//        }
//    } else {
//        println("Invalid Input")
//    }
//}





