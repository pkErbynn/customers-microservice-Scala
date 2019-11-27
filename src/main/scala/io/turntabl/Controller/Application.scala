import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@SpringBootApplication
class Application

object Application {
  def main(args: Array[String]): Unit = {
    val bootstrapClasses: Array[Class[_]] = Array(classOf[Application])
    SpringApplication.run(bootstrapClasses, args)
  }
}