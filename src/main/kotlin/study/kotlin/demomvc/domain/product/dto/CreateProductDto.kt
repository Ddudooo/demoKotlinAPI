package study.kotlin.demomvc.domain.product.dto

import study.kotlin.demomvc.domain.product.model.Category
import study.kotlin.demomvc.domain.product.model.Product

data class CreateProductDto(
        var name: String,
        var category: String,
        var price: Int = 1000,
        var quantity: Int = 100
) {
    fun toEntity(): Product {
        return Product(null, Category.valueOf(category), name, price, quantity)
    }
}