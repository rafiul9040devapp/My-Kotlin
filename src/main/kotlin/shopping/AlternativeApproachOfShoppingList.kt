package shopping

data class Product(
    val nameOfProduct: String?,
    var priceOfProduct: Double?,
    var quantityOfProduct: Int?,
)

fun main() {
    var shoppingListAlternative = mutableListOf<Product>()
    while (true) {
        showMenuOptions()
        when (readLine()?.toIntOrNull() ?: 0) {
            1 -> executeIfShoppingListIsNotEmpty(shoppingListAlternative) { showShoppingList(shoppingListAlternative) }
            2 -> addProductToShoppingList(shoppingListAlternative)
            3 -> executeIfShoppingListIsNotEmpty(shoppingListAlternative) { removeProductFromShoppingList(shoppingListAlternative) }
            4 -> executeIfShoppingListIsNotEmpty(shoppingListAlternative) { updateProductOfShoppingList(shoppingListAlternative) }
            5 -> executeIfShoppingListIsNotEmpty(shoppingListAlternative) { checkOutTheBill(shoppingListAlternative) }
            6 -> return
            else -> println("Invalid Option")
        }
    }
}

fun showMenuOptions() {
    println("Choose An Option....")
    println("1.Show The Shopping List ")
    println("2.Add Product to Shopping List")
    println("3.Remove Product From Shopping List")
    println("4.Update Product of Shopping List")
    println("5.CheckOut The Total Bill")
    println("6.Exit")
}

fun executeIfShoppingListIsNotEmpty(shoppingListAlternative: MutableList<Product>, action: () -> Unit) = if (shoppingListAlternative.isNotEmpty()) action() else println("Empty List")

fun showShoppingList(shoppingListAlternative: MutableList<Product>) {
    println("------------Shopping List-------------")
    println("ID  Product      Price     Quantity")
    shoppingListAlternative.forEachIndexed { index, product ->
        println(
            "${index + 1}.  ${product.nameOfProduct?.uppercase()}        ${product.priceOfProduct}/-       ${
                product
                    .quantityOfProduct
            }"
        )
    }
}

fun addProductToShoppingList(shoppingListAlternative: MutableList<Product>) {
    println("Enter Product Name: ")
    val productName = readLine() ?: " "
    println("Enter Product Price: ")
    val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
    println("Enter Product Quantity: ")
    val productQuantity = readLine()?.toIntOrNull() ?: 0

    if (isValidProduct(productName, productPrice, productQuantity)) {
        shoppingListAlternative.add(
            Product(
                nameOfProduct = productName, priceOfProduct = productPrice,
                quantityOfProduct = productQuantity
            )
        )
        println("$productName is Add To Shopping List Successfully")
    } else {
        println("Invalid Product")
    }
}

fun removeProductFromShoppingList(shoppingListAlternative: MutableList<Product>) {
    println("Enter The Product Name OR ID: ")
    val inputForRemoveProduct = readLine() ?: " "
    val indexOfProduct = inputForRemoveProduct.toIntOrNull()

    val removedProduct = if (indexOfProduct != null) {
        val index = indexOfProduct - 1
        if (index in shoppingListAlternative.indices) shoppingListAlternative[index] else null
    } else {
        shoppingListAlternative.find { product -> product.nameOfProduct.equals(inputForRemoveProduct, false) }
    }

    if (removedProduct != null) {
        shoppingListAlternative.remove(removedProduct)
        println("Product Is Removed From The List Successfully")
    } else {
        println("Product Is not Found")
    }
}

fun updateProductOfShoppingList(shoppingListAlternative: MutableList<Product>) {
    println("Enter The Product Name:")
    val productName = readLine() ?: ""
    if (productName.isNotBlank() || productName.isNotEmpty()) {
        val product = shoppingListAlternative.find { product -> product.nameOfProduct.equals(productName, false) }
        if (product != null) {
            println("Enter Product Price: ")
            val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
            println("Enter Product Quantity: ")
            val productQuantity = readLine()?.toIntOrNull() ?: 0
            if (isValidProduct(productName, productPrice, productQuantity)) {
                product.priceOfProduct = productPrice
                product.quantityOfProduct = productQuantity
                println("${product.nameOfProduct} is updated Successfully")
            }
        } else {
            println("$productName is not found")
        }
    }
}

fun checkOutTheBill(shoppingListAlternative: MutableList<Product>) {
    var totalBill: Double = 0.0
    showShoppingList(shoppingListAlternative)
    shoppingListAlternative.forEach { product ->
        val eachItemPrice = product.priceOfProduct!! * product.quantityOfProduct!!
        totalBill += eachItemPrice
    }
    println("TOTAL BILL: $totalBill/-")
}

private fun isValidProduct(
    productName: String,
    productPrice: Double,
    productQuantity: Int
) = productName.isNotBlank() && productPrice > 0 && productQuantity > 0


//fun removeProductFromShoppingList(shoppingListAlternative: MutableList<Product>) {
//    println("Enter The Product Name OR ID: ")
//    val inputForRemoveProduct = readLine() ?: " "
//    val indexOfProduct = inputForRemoveProduct.toIntOrNull()
//
//    if (shoppingListAlternative.isNotEmpty()) {
//        if (indexOfProduct != null) {
//            val index = indexOfProduct - 1
//            if (index in 0 until shoppingListAlternative.size) {
//                val product = shoppingListAlternative.removeAt(index)
//                println("${product.nameOfProduct} is removed")
//            } else {
//                println("$inputForRemoveProduct is not a valid index")
//            }
//        } else if (inputForRemoveProduct.isNotEmpty()) {
//            val product = shoppingListAlternative.find { product ->
//                product.nameOfProduct.equals(inputForRemoveProduct, false)
//            }
//            if (product != null) {
//                shoppingListAlternative.remove(product)
//                println("$inputForRemoveProduct is removed successfully")
//            } else {
//                println("$inputForRemoveProduct is not found")
//            }
//        } else {
//            println("Invalid Input")
//        }
//    } else {
//        println("Empty List. Noting to remove.")
//    }
//
//}