package com.ankit.jare.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ankit.jare.model.Results
import com.ankit.jare.model.ListRepository

class RepoListViewModel : BaseViewModel() {

    val repoListLive = MutableLiveData<List<Results>>()

    fun fetchRepoList() {
        try {
            dataLoading.value = true
            ListRepository.getInstance().getRepoList { isSuccess, response ->
                dataLoading.value = false
                if (isSuccess) {
                    if (response != null && response.results.size > 0) {
                        repoListLive.postValue(response?.results)
                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}