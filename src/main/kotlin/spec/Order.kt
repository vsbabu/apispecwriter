package spec

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size


@Tag(
    name = "Orders", description = """
    Everything related to orders!
    - Here is how you can add all **markdown**
    - in multiple lines.
"""
)
@RestController
@RequestMapping("/api")
class OrderApis {

    @Operation(
        summary = "Create an order for an email"
    )
    @PostMapping("/order/email/{id}")
    fun createNewOrderByMail(
        @PathVariable(value = "id") email: String,
        @RequestBody order: OrderData
    ): OrderData? {
        return null
    }


}

@Schema(name = "Order")
@Entity
data class OrderData(
    @Id
    val id: Long = 0,

    @get: NotEmpty
    var customerId: Long = 0,

    @Size(min = 10, max = 15)
    @get: NotBlank
    val product: String = "",

    @get: NotEmpty
    var orderDate: Timestamp = Timestamp.valueOf(LocalDateTime.now()),

    @get: NotEmpty
    var confirmed: Int = 0,

    )