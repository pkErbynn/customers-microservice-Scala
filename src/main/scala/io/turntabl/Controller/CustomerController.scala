package io.turntabl.Controller

import java.util.concurrent.Flow.Publisher

import io.swagger.annotations
import io.swagger.annotations.ApiOperation
import io.turntabl.service.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
//import io.turntabl.service.{Customer, CustomerService}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RestController}
import io.swagger.annotations.ApiOperation


@annotations.Api
@RestController
class CustomerController {

  @Autowired
  private val dao: CustomerService = new CustomerService

  @ApiOperation("Get all customers in record")
  @GetMapping("/customer")
  def getAllCustomers: List[Customer] = dao.getAllCustomers

  @ApiOperation("get customers by name")
  @GetMapping("/customer/search")
  def getCustomerByName(name: String): List[Customer] = dao.getCustomerByName(name)

  @ApiOperation("get customers by id")
  @GetMapping("/customer/{id}")
  def getCustomerById(@PathVariable id: Long): Option[Customer] = dao.getCustomerById(id)

  @ApiOperation("add new customer")
  @PostMapping("/customer/add")
  def addNewCustomer(@RequestBody customer: Customer): Unit = dao.addNewCustomer(customer)

  @ApiOperation("update record of an existing customer")
  @PutMapping("/customer/{id}")
  def updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer): Option[Customer] = {
    val customerById: Option[Customer] = dao.getCustomerById(id)
    customerById match {
      case Some(customer) => {customerById(customer.name, customer.address, customer.telephoneNumber, customer.email )
                              dao.updateCustomer(customerById)
      }
      case None => print("unknown customer Id")
    }
//    customerToUpdate(customer.name, customer.address, customer.telephoneNumber, customer.email )
  }

  @ApiOperation("delete record of an existing customer")
  @DeleteMapping("/customer/{id}")
  def deleteCustomer(@PathVariable id: Long) : Unit = dao.deleteCustomer(id)

  @ApiOperation("retrieve record of an deleted customer")
  @GetMapping("/customer/retrieve/{id}")
  def retrieveCustomer(@PathVariable ): Customer

}
