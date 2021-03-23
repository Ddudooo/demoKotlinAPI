package study.kotlin.demomvc.domain.product.api

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*
import study.kotlin.demomvc.domain.product.dto.CreateProductDto
import study.kotlin.demomvc.domain.product.dto.DetailProductDto
import study.kotlin.demomvc.domain.product.dto.SimpleProductDto
import study.kotlin.demomvc.domain.product.dto.UpdateProductDto
import study.kotlin.demomvc.domain.product.service.ProductService

@RestController
class ProductApi(
        val productService: ProductService
) {

    @GetMapping("/api/products")
    fun findAll(pageable: Pageable): Page<SimpleProductDto> {
        return productService.findAll(pageable);
    }

    @GetMapping("/api/products/{id}/detail")
    fun findById(@PathVariable("id") id: Long): DetailProductDto {
        return productService.findById(id);
    }

    @PostMapping("/api/products")
    fun create(@RequestBody creatDto: CreateProductDto): Long? {
        return productService.create(creatDto);
    }

    @PutMapping("/api/products/{id}")
    fun update(
            @PathVariable("id") id: Long,
            @RequestBody updateDto: UpdateProductDto): Long? {
        updateDto.id = id;
        return productService.update(updateDto);
    }

    @DeleteMapping("/api/products/{id}")
    fun delete(@PathVariable("id") id: Long) {
        productService.delete(id);
    }
}