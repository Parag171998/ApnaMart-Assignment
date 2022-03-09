package com.example.assignmentapnamart.repo

import androidx.paging.PagingSource
import com.example.assignmentapnamart.models.ResponseDataItem
import com.example.assignmentapnamart.network.ApiInterface

class Repo(private val apiInterface: ApiInterface) : PagingSource<Int, ResponseDataItem>() {

    companion object {
        private const val ITEMS_LIMIT = "10"
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseDataItem> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiInterface.getData(currentLoadingPageKey.toString(), ITEMS_LIMIT)
            val responseData = mutableListOf<ResponseDataItem>()
            val data = response.body() ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}