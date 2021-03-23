package study.kotlin.demomvc.domain.product.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.kotlin.demomvc.domain.product.dto.CreateProductDto
import study.kotlin.demomvc.domain.product.dto.DetailProductDto
import study.kotlin.demomvc.domain.product.dto.SimpleProductDto
import study.kotlin.demomvc.domain.product.dto.UpdateProductDto
import study.kotlin.demomvc.domain.product.model.Product
import study.kotlin.demomvc.domain.product.repo.ProductRepo
import java.util.*

@Service
@Transactional(readOnly = true)
class ProductService(
        val productRepo: ProductRepo
) {
    fun findAll(pageable: Pageable): Page<SimpleProductDto> {
        return productRepo.findAll(pageable).map { t -> t.toSimpleDto() }
    }

    fun findById(id: Long): DetailProductDto {
        return productRepo.findById(id)
                .orElseThrow()
                .toDetailDto();
    }

    @Transactional
    fun create(creatDto: CreateProductDto): Long? {
        val createEntity: Product = creatDto.toEntity();
        return productRepo.save(createEntity).id;
    }

    @Transactional
    fun update(updateDto: UpdateProductDto): Long? {
        val foundedEntity: Optional<Product> = productRepo.findById(updateDto.id);
        val entity = foundedEntity.orElseThrow();
        entity.name = updateDto.name;
        entity.price = updateDto.price;
        entity.quantity = updateDto.quantity;

        return productRepo.save(entity).id;
    }

    @Transactional
    fun delete(id: Long) {
        productRepo.deleteById(id);
    }
}