package io.turntabl.Controller

case class Customer(id: Long, name: String, address: String, telephoneNumber: String, val email: String) {
  def apply(name: String, address: String, telephoneNumber: String, email: String): Customer =
    new Customer(id, name, address, telephoneNumber, email)

}
