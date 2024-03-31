package shopping

import java.util.*

fun main() {
    val shoppingList = ShoppingList()
    val productList = shoppingList.getShoppingList()
    askForShowingProductList(productList)
    askForProductEnteringPermission(productList)
    askForShowingProductList(productList, true)
    askForProductRemovingPermission(productList)
    //showProduct(productList)
}


fun askForShowingProductList(productList: MutableList<ShoppingItem>, isUpdatedList: Boolean = false) {
    if (isUpdatedList) {
        println("Want To See The Updated Product List: (Y/N)")
    } else {
        println("Want To See Product List: (Y/N)")
    }
    when (readLine()?.uppercase(Locale.ROOT) ?: "") {
        "Y" -> showProduct(productList)
        "N" -> println("Thanks for the feedback")
        else -> println("Invalid Input")
    }
}

fun askForProductEnteringPermission(productList: MutableList<ShoppingItem>) {
    println("Want To ADD Product: (Y/N)")
    when (readLine()?.uppercase(Locale.ROOT) ?: "") {
        "Y" -> enterProduct(productList)
        "N" -> println("Thanks for the feedback")
        else -> println("Invalid Input")
    }
}

fun askForProductRemovingPermission(productList: MutableList<ShoppingItem>) {
    println("Want To REMOVE Product: (Y/N)")
    when (readLine()?.uppercase(Locale.ROOT) ?: "") {
        "Y" -> removeProduct(productList)
        "N" -> println("Thanks for the feedback")
        else -> println("Invalid Input")
    }
}


fun showProduct(productList: MutableList<ShoppingItem>) {
    println("------------Shopping List-------------")
    productList.forEach { shoppingItem ->
        if (shoppingItem.productQuantity != null) {
            println("Name: " + shoppingItem.productName)
            println("Price: " + shoppingItem.productPrice + "/-")
            println("Quantity: " + shoppingItem.productQuantity)
        }
    }
}

fun enterProduct(productList: MutableList<ShoppingItem>) {
    println("Enter Product Name: ")
    val productName = readLine() ?: " "

    println("Enter Product Price: ")
    val productPrice = readLine()?.toDouble() ?: 0.0

    println("Enter Product Quantity: ")
    val productQuantity = readLine()?.toInt() ?: 0

    if (productName.contains(" ") || productPrice <= 0.0 || productQuantity <= 0) {
        println("Invalid Input")
    } else {
        productList.add(
            ShoppingItem(
                productName = productName,
                productPrice = productPrice,
                productQuantity = productQuantity
            )
        )
        println("Product is Added successfully")
    }
}

fun removeProduct(productList: MutableList<ShoppingItem>) {
    println("Enter The Product Name: ")
    val nameOfRemovedProduct = readLine()?.uppercase() ?: " "
    var isProductRemoved = false
    val updatedProductList = mutableListOf<ShoppingItem>()

    productList.forEach { shoppingItem ->
        if (shoppingItem.productName.uppercase().contains(nameOfRemovedProduct)) {
            isProductRemoved = true
        } else {
            updatedProductList.add(shoppingItem)
        }
    }
    if (!isProductRemoved) {
        println("Product Not Found in the Shopping List")
    } else {
        println("Product Is Removed From The Shopping List")
        productList.clear()
        productList.addAll(updatedProductList)
    }
    askForShowingProductList(updatedProductList, true)
}
