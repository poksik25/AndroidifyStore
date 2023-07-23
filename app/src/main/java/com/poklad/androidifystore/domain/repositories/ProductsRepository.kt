package com.poklad.androidifystore.domain.repositories

import com.poklad.androidifystore.domain.model.ProductItem

//todo flow тут може бути, а вот livedata єто чисто во вьюмодел? А ресурс уже в UseCase?
interface ProductsRepository {
    suspend fun getAllProducts(): List<ProductItem>
    suspend fun getProductsById(productId: Long): ProductItem
    suspend fun getProductsByCategories(categoryName: String): List<ProductItem>
}