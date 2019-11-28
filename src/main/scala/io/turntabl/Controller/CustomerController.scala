package io.turntabl.Controller

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PathVariable, PostMapping, PutMapping, RequestBody, RestController}
import io.swagger.annotations.ApiOperation
import javax.sql.DataSource
import org.slf4j.Logger


@Api
@RestController
class CustomerController( @Autowired val dao: CustomerService = new CustomerService,
                          @Autowired val dataSource: DataSource) {

  val logger: Logger = org.slf4j.LoggerFactory.getLogger(classOf[CustomerController])

  @ApiOperation("Get all customers in record")
  @GetMapping(path = Array("/customer"))
  def getAllCustomers: List[Customer] = {
    logger.info("get all customers....")
    println("list all customers...")
    dao.getAllCustomers
  }

  @ApiOperation("get customers by name")
  @GetMapping(path = Array("/customer/search"))
  def getCustomerByName(name: String): List[Customer] = dao.getCustomerByName(name)

  @ApiOperation("get customers by id")
  @GetMapping(path = Array("/customer/{id}"))
  def getCustomerById(@PathVariable id: Long): Option[Customer] = dao.getCustomerById(id)
//    id match {
//      case Some(Customer) => dao.getCustomerById(id)
//      case None => print("invalid id")
//    }

  @ApiOperation("add new customer")
  @PostMapping(path = Array("/customer/add"))
  def addNewCustomer(@RequestBody customer: Customer): Unit = dao.addNewCustomer(customer)

  @ApiOperation("update record of an existing customer")
  @PutMapping(path = Array("/customer/{id}"))
  def updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer): Unit = {
    dao.getCustomerById(id) match {
      case Some(customerToUpdate) => {customerToUpdate(customer.name, customer.address, customer.telephoneNumber, customer.email )
                                    dao.updateCustomer(customerToUpdate)
      }
      case None => println("unknown customer Id")
    }
  }

  @ApiOperation("delete record of an existing customer")
  @DeleteMapping(path = Array("/customer/{id}"))
  def deleteCustomer(@PathVariable id: Long) : Unit = dao.deleteCustomer(id)

  @ApiOperation("retrieve record of an deleted customer")
  @GetMapping(path = Array("/customer/retrieve/{id}"))
  def retrieveDeletedCustomer(@PathVariable id: Long): Option[Customer] = dao.retrieveDeletedCustomer(id)

}
