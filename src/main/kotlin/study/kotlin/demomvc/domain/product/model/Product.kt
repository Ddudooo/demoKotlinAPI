package study.kotlin.demomvc.domain.product.model


import study.kotlin.demomvc.domain.product.dto.DetailProductDto
import study.kotlin.demomvc.domain.product.dto.SimpleProductDto
import javax.persistence.*

@Entity
class Product(
        @Id
        @GeneratedValue
        val id: Long? = null,

        @Enumerated(EnumType.STRING)
        val category: Category,

        var name: String,

        var price: Int,

        var quantity: Int,
) {
    fun toDetailDto(): DetailProductDto {
        return DetailProductDto(id, category.name, name, price, quantity)
    }

    fun toSimpleDto(): SimpleProductDto {
        return SimpleProductDto(id, category.name, name, price, quantity)
    }
}