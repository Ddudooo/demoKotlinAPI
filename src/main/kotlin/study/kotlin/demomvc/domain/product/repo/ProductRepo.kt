package study.kotlin.demomvc.domain.product.repo

import org.springframework.data.jpa.repository.JpaRepository
import study.kotlin.demomvc.domain.product.model.Product

interface ProductRepo : JpaRepository<Product, Long> {

}