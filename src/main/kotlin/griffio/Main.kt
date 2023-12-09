package griffio

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.asJdbcDriver
import griffio.migrations.Address
import griffio.migrations.Customer
import griffio.queries.Sample

import org.postgresql.ds.PGSimpleDataSource

private fun getSqlDriver(): SqlDriver {
    val datasource = PGSimpleDataSource()
    datasource.setURL("jdbc:postgresql://localhost:5432/postgres")
    datasource.applicationName = "App Main"
    return datasource.asJdbcDriver()
}

fun main() {

    val driver = getSqlDriver()
    val sample = Sample(driver)
    val city = sample.cityQueries.insert("City Name 1").executeAsOne()
    val addressId = sample.addressQueries.insert("Address 1", "Address 2", "District 31", city.city_id, "513-281-4700", "POST CODE").executeAsOne()
    val customerId = sample.customerQueries.insert("First Name", "Last Name", "test@example.com", addressId, true).executeAsOne()
    val address: Address = sample.addressQueries.get(addressId).executeAsOne()
    val customer: Customer = sample.customerQueries.get(customerId).executeAsOne()

    // update by single address object not supported, have to provide fields
    sample.addressQueries.update(address_id = address.address_id,
        address_1 = "Address Updated", address2 = address.address2, district = address.district,
        city_id = address.city_id, phone = address.phone, postal_code = address.postal_code)

    sample.customerQueries.update(customer_id = customer.customer_id, first_name = "First Name Updated", last_name = customer.last_name,
        email = customer.email, address_id = customer.address_id, is_active = customer.is_active)

    val addressList: List<Address> = sample.addressQueries.all().executeAsList()
    val customerList: List<Customer> = sample.customerQueries.all().executeAsList()

    println(addressList.joinToString("\n"))
    println(address)
    println(customerList.joinToString("\n"))
    println(customer)
}
