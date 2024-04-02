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
            1 -> showShoppingList(shoppingListAlternative)
            2 -> addProductToShoppingList(shoppingListAlternative)
            3 -> removeProductFromShoppingList(shoppingListAlternative)
            4 -> updateProductOfShoppingList(shoppingListAlternative)
            5 -> checkOutTheBill(shoppingListAlternative)
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

fun showShoppingList(shoppingListAlternative: MutableList<Product>) {
    if (shoppingListAlternative.isNotEmpty()) {
        println("------------Shopping List-------------")
        println("ID  Product      Price     Quantity")
        shoppingListAlternative.forEachIndexed { index, product ->
            println(
                "${index + 1}.  ${product.nameOfProduct?.uppercase()}        ${product.priceOfProduct}/-       ${product
                    .quantityOfProduct}"
            )
        }
    } else {
        println("There is nothing to show.")
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

    if (shoppingListAlternative.isNotEmpty()) {
        if (indexOfProduct != null) {
            val index = indexOfProduct - 1
            if (index in 0 until shoppingListAlternative.size) {
                val product = shoppingListAlternative.removeAt(index)
                println("${product.nameOfProduct} is removed")
            } else {
                println("$inputForRemoveProduct is not a valid index")
            }
        } else if (inputForRemoveProduct.isNotEmpty()) {
            val product = shoppingListAlternative.find { product ->
                product.nameOfProduct.equals(inputForRemoveProduct, false)
            }
            if (product != null) {
                shoppingListAlternative.remove(product)
                println("$inputForRemoveProduct is removed successfully")
            } else {
                println("$inputForRemoveProduct is not found")
            }
        } else {
            println("Invalid Input")
        }
    } else {
        println("Empty List. Noting to remove.")
    }

}

fun updateProductOfShoppingList(shoppingListAlternative: MutableList<Product>) {
    if (shoppingListAlternative.isNotEmpty()){
        println("Enter The Product Name:")
        val productName = readLine() ?: ""
        if (productName.isNotBlank()){
            val product = shoppingListAlternative.find { product -> product.nameOfProduct.equals(productName,false)}
            if (product!=null){
                println("Enter Product Price: ")
                val productPrice = readLine()?.toDoubleOrNull() ?: 0.0
                println("Enter Product Quantity: ")
                val productQuantity = readLine()?.toIntOrNull() ?: 0
                if (isValidProduct(productName,productPrice,productQuantity)){
                    product.priceOfProduct = productPrice
                    product.quantityOfProduct = productQuantity
                    println("${product.nameOfProduct} is updated Successfully")
                }
            }else{
                println("$productName is not found")
            }
        }else{
            println("Invalid")
        }
    }
}

fun checkOutTheBill(shoppingListAlternative: MutableList<Product>) {
    var totalBill: Double = 0.0
    if (shoppingListAlternative.isNotEmpty()){
        shoppingListAlternative.forEach { product ->
            var eachItemPrice = product.priceOfProduct!! * product.quantityOfProduct!!
            totalBill += eachItemPrice
        }
        println("TOTAL BILL: $totalBill/-")
    }else{
        println("TOTAL BILL: $totalBill/-")
    }
}

private fun isValidProduct(
    productName: String,
    productPrice: Double,
    productQuantity: Int
) = productName.isNotBlank() && productPrice > 0 && productQuantity > 0