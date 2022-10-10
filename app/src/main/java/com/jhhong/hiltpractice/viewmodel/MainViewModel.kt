package com.jhhong.hiltpractice.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.jhhong.hiltpractice.data.PlaceData
import com.jhhong.hiltpractice.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    var _liveData = MutableLiveData<PlaceData>()
    private var liveData : LiveData<PlaceData> = _liveData

    fun getData() = liveData

    init {
        loadData(1, 10) // api 홈페이지에서 테스트 시 기본값으로 설정
    }

    private fun loadData(page : Int, perPage : Int) {
        viewModelScope.launch {
            val data = repository.getAllPlaces(page, perPage)
            when (data.isSuccessful) {
                true -> {
                    _liveData.postValue(data.body())
                }
                else -> {
                    Timber.e("get places error -> ${data.body()}")
                }
            }
        }
    }
}