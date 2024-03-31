package shopping

class ShoppingList {
    fun getShoppingList() =
        mutableListOf<ShoppingItem>(
            ShoppingItem(productName = "Ice Cream", productPrice = 50.0, productQuantity = 5),
            ShoppingItem(productName = "Milk", productPrice = 2.5, productQuantity = 1),
            ShoppingItem(productName = "Bread", productPrice = 3.0, productQuantity = 2),
            ShoppingItem(productName = "Eggs", productPrice = 4.0, productQuantity = 12),
            ShoppingItem(productName = "Apples", productPrice = 1.0, productQuantity = 6),
            ShoppingItem(productName = "Bananas", productPrice = 1.5, productQuantity = 4),
            ShoppingItem(productName = "Oranges", productPrice = 2.0, productQuantity = 3),
            ShoppingItem(productName = "Cheese", productPrice = 6.0, productQuantity = 1),
            ShoppingItem(productName = "Tomatoes", productPrice = 2.5, productQuantity = 4),
            ShoppingItem(productName = "Potatoes", productPrice = 2.0),
            ShoppingItem(productName = "Onions", productPrice = 1.0, productQuantity = 3),
            ShoppingItem(productName = "Carrots", productPrice = 1.5, productQuantity = 4),
            ShoppingItem(productName = "Chicken", productPrice = 8.0, productQuantity = 2),
            ShoppingItem(productName = "Beef", productPrice = 10.0, productQuantity = 1),
            ShoppingItem(productName = "Pasta", productPrice = 3.0)
        )
}
