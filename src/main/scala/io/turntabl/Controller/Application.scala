package io.turntabl.Controller

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import springfox.documentation.swagger2.annotations.EnableSwagger2


@EnableSwagger2
@SpringBootApplication
class Application

object Application extends App {
  SpringApplication.run(classOf[Application])

  @Bean def getCustomerService = new CustomerService
}


