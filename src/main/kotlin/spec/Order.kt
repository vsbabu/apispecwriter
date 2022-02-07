package spec

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
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
@RequestMapping("/api/order/")
class OrderApis {

    @Operation(
        summary = "Create an order for an email",
        description = """
            Create an order for a particular *email*.
            Order data must be passed in the child.          
          """
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Created order",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = OrderData::class))]
        )]
    )
    @PostMapping("email/{emailid}")
    fun createNewOrderByMail(
        @PathVariable(value = "emailid") email: String,
        @RequestBody order: OrderData
    ): OrderData? {
        return null
    }

    @Operation (
        summary = "Get an order by id"
    )
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Order retrieved",
            content = [Content(mediaType = "application/json", schema = Schema(implementation = OrderData::class))]
        ),
        ApiResponse(responseCode = "404", description = "Order not found", content = [Content()])
    ]
    )
    @GetMapping("/{id}")
    fun getOrderById(
        @PathVariable(value = "id") id: Long
    ): OrderData? {
        return null
    }

}

@Schema(name = "Order")
@Entity
data class OrderData(
    @Id
    val id: Long = 0,

    @NotEmpty
    var customerId: Long = 0,

    @Size(min = 10, max = 15)
    @NotBlank
    val product: String = "",

    @NotEmpty
    var orderDate: Timestamp = Timestamp.valueOf(LocalDateTime.now()),

    @NotEmpty
    var confirmed: Int = 0,

    )