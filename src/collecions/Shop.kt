package collecions

data class Shop(val name: String, val customers: List<Customer>) {
    fun getSetOfCustomers(): Set<Customer> {
        return customers.toSet()
    }

    fun getCustomersFrom(city: City): List<Customer> {
        return customers.filter { it.city == city }
    }

    fun getCitiesCustomersAreFrom(): Set<City> {
        return customers.map { it.city }.toSet()
    }

    // Return true if all customers are from the given city
    fun Shop.checkAllCustomersAreFrom(city: City): Boolean = customers.all { it.city == city }

    // Return true if there is at least one customer from the given city
    fun Shop.hasCustomerFrom(city: City): Boolean = customers.any { it.city == city }

    // Return the number of customers from the given city
    fun Shop.countCustomersFrom(city: City): Int = customers.count { it.city == city }

    // Return a customer who lives in the given city, or null if there is none
    fun Shop.findAnyCustomerFrom(city: City): Customer? = customers.find { it.city == city }

    // Return a customer whose order count is the highest among all customers
    fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
        return customers.minBy { it.orders.size }
    }

    // Return a list of customers, sorted by the ascending number of orders they made
    fun Shop.getCustomersSortedByNumberOfOrders(): List<Customer> {
        return customers.sortedBy { it.orders.size }
    }

    // Return a map of the customers living in each city
    fun Shop.groupCustomersByCity(): Map<City, List<Customer>> {
        return customers.groupBy { it.city }
    }

    // Return customers who have more undelivered orders than delivered
    fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
        return customers.filter {
            val (delivered, undelivered) = it.orders.partition { it.isDelivered }
            undelivered.size > delivered.size
        }.toSet()
    }

    // Return the set of products that were ordered by every customer
    fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
        val allProducts = customers.flatMap { it.orders.flatMap { it.products } }.toSet()

        return customers.fold(allProducts, { orderedByAll, customer ->
            orderedByAll.intersect(customer.orders.flatMap { it.products }.toSet())
        })
    }

    // Return how many times the given product was ordered.
    // Note: a customer may order the same product for several times.
    fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
        return customers.flatMap { it.orders }.flatMap { it.products }.filter { it == product }.count()
    }
}