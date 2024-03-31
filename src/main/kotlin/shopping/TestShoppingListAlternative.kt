package shopping

import java.util.*

fun main() {
    val shoppingList = ShoppingList()
    val productList = shoppingList.getShoppingList()

    askForAction("Want to see the product list", productList) { showProductAlternative(productList) }
    askForAction("Want to add a product", productList) { enterProductAlternative(productList) }
    askForAction("Want to remove a product", productList) { removeProductAlternative(productList) }
}

fun askForAction(message: String, productList: MutableList<ShoppingItem>, action: () -> Unit) {
    println("$message: (Y/N)")
    when (readLine()?.uppercase() ?: "") {
        "Y" -> action()
        "N" -> println("Thanks for the feedback")
        else -> println("Invalid Input")
    }
}

fun showProductAlternative(productList: MutableList<ShoppingItem>) {
    println("------------Shopping List-------------")
    productList.forEach { shoppingItem ->
        println("Name: ${shoppingItem.productName}")
        println("Price: ${shoppingItem.productPrice}/-")
        println("Quantity: ${shoppingItem.productQuantity}")
    }
}

fun enterProductAlternative(productList: MutableList<ShoppingItem>) {
    println("Enter Product Name: ")
    val productName = readLine() ?: " "
    println("Enter Product Price: ")
    val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
    println("Enter Product Quantity: ")
    val productQuantity = readLine()?.toIntOrNull() ?: 0

    if (productName.isNotBlank() && productPrice > 0 && productQuantity > 0) {
        productList.add(
            ShoppingItem(
                productName = productName,
                productPrice = productPrice,
                productQuantity = productQuantity
            )
        )
        println("Product is Added successfully")
    } else {
        println("Invalid Input")
    }
}

fun removeProductAlternative(productList: MutableList<ShoppingItem>) {
    println("Enter The Product Name: ")
    val nameOfRemovedProduct = readLine()?.uppercase(Locale.ROOT) ?: " "
    val removedProducts = productList.filterNot { it.productName.uppercase().contains(nameOfRemovedProduct) }
    if (removedProducts.size < productList.size) {
        println("Product Is Removed From The Shopping List")
        productList.clear()
        productList.addAll(removedProducts)
        //showProductAlternative(productList)
        askForAction("Want To See Updated List",productList){
            showProductAlternative(productList)
        }
    } else {
        println("Product Not Found in the Shopping List")
    }
}


