package study.kotlin.demomvc.domain.product.dto

data class DetailProductDto(
        val id: Long? = null,
        var category: String,
        var name: String,
        var price: Int,
        var quantity: Int
)