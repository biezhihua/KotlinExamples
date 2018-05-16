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
}

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double) {
    override fun toString() = "'$name' for $price"
}

data class City(val name: String) {
    override fun toString() = name
}