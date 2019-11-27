//package io.turntabl.service
//
////object CustomerService {
////
////}
//
//import io.turntabl.Controller.Customer
//import scalikejdbc._
//
////case class Customer(id: Long, name: String, address: String, telephoneNumber: String, email: String)
//
//object CustomerService {
//
//  def getAllCustomers: List[Customer] = DB readOnly { implicit session =>
//    sql"SELECT * FROM customers WHERE active = 'yes'".map { rs => CustomerMapper(rs) }.toList().apply()
//  }
//
//  def getCustomerByName(name: String): List[Customer] = DB readOnly { implicit session =>
//    sql"SELECT * FROM customers WHERE active = 'yes' AND LOWER(name) LIKE %${name}%".map { rs => CustomerMapper(rs) }.toList().apply()
//  }
//
//  def getCustomerById(id: Long): Option[Customer] = DB readOnly { implicit session =>
//    sql"SELECT * FROM customers WHERE active = 'yes' AND id = ${id}".map { rs => CustomerMapper(rs) }.single().apply()
//  }
//
//  def addNewCustomer(customer: Customer): Option[Customer] = None
//  def updateCustomer(customer: Customer): Option[Customer] = None
//  def deleteCustomer(id: Long): Option[Customer] = None
//  def retrieveDeletedCustomer(id: Long): Option[Customer] = None
//
//
//  def CustomerMapper (rs: WrappedResultSet) = Customer(
//    rs.get[Long]("id"),
//    rs.get[String]("name"),
//    rs.get[String]("address"),
//    rs.get[String]("telephoneNumber"),
//    rs.get[String]("email"))
//}