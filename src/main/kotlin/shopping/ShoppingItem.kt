package shopping

data class ShoppingItem(
    val productName:String = "",
    val productPrice:Double = 0.0,
    val productQuantity:Int? = null,
)
