package study.kotlin.demomvc.domain.product.dto

data class UpdateProductDto(
        var id: Long,
        var name: String,
        var price: Int,
        var quantity: Int
)