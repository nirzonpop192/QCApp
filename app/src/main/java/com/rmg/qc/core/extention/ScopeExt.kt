package com.rmg.qc.core.extention

import androidx.lifecycle.MutableLiveData
import com.foodibd.rider.core.data.DataResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


/**
 * Generic method to call api within Coroutine Scope
 */
fun <T> CoroutineScope.callApi(
    dispatcher: CoroutineDispatcher,
    liveData: MutableLiveData<DataResource<*>>,
    api: suspend () -> T
) {
    liveData.postValue(DataResource.Loading(null))
    launch(dispatcher) {
        liveData.postValue(safeApiCall(dispatcher, api))
    }
}



/**
 * Generic method to fetch data from repository
 */
fun CoroutineScope.callRepo(
    dispatcher: CoroutineDispatcher,
    liveData: MutableLiveData<DataResource<*>>,
    repoMethod: suspend () -> DataResource<*>?
) {
    liveData.postValue(DataResource.Loading(null))
    launch(dispatcher) {
        liveData.postValue(repoMethod.invoke())
    }
}


