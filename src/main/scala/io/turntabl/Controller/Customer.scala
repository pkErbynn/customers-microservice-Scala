package io.turntabl.Controller

case class Customer(val id: Long,
                    val name: String,
                    val address: String,
                    val telephoneNumber: String,
                    val email: String) {
  def apply(name: String, address: String, telephoneNumber: String, email: String): Customer =
    new Customer(id, name, address, telephoneNumber, email)

}
