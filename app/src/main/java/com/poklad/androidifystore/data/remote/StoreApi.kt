package com.poklad.androidifystore.data.remote

import com.poklad.androidifystore.data.remote.model.ProductCategoryModel
import com.poklad.androidifystore.data.remote.model.ProductItemModel
import com.poklad.androidifystore.utils.Constants.ALL_PRODUCTS
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {
    @GET(ALL_PRODUCTS)
    suspend fun getAllProducts(): List<ProductItemModel>

    @GET("products/{productId}")
    suspend fun getProductById(
        @Path("productId")
        productId: Long
    ): ProductItemModel

    @GET("products/category/{categoryName}")
    suspend fun getProductsByCategories(
        @Path("categoryName")
        categoryName: String
    ): List<ProductItemModel>

    @GET("products/categories")
    suspend fun getAllCategories(): List<ProductCategoryModel>
}