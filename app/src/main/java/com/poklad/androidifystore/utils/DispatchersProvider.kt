package com.poklad.androidifystore.utils

import kotlinx.coroutines.CoroutineDispatcher
interface DispatchersProvider {
    fun getIO(): CoroutineDispatcher
    fun getMain(): CoroutineDispatcher
    fun getUnconfined(): CoroutineDispatcher
    fun getDefault(): CoroutineDispatcher
}