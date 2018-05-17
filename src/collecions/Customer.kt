package collecions

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"

    // Return all products this customer has ordered
    val Customer.orderedProducts: Set<Product>
        get() {
            return orders.flatMap { it.products }.toSet()
        }

    // Return all products that were ordered by at least one customer
    val Shop.allOrderedProducts: Set<Product>
        get() {
            return customers.flatMap { it.orderedProducts }.toSet()
        }

    // Return the most expensive product which has been ordered
    fun Customer.getMostExpensiveOrderedProduct(): Product? {
        return orders.flatMap { it.products }.maxBy { it.price }
    }

    // Return the sum of prices of all products that a customer has ordered.
    // Note: the customer may order the same product for several times.
    fun Customer.getTotalOrderPrice(): Double {
        return orders.flatMap { it.products }.sumByDouble { it.price }
    }

    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    fun Customer.getMostExpensiveDeliveredProduct(): Product? {
        return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
    }
}