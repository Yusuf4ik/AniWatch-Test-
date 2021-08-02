package com.example.aniwatch.ViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aniwatch.data.NetworkUtils
import com.example.aniwatch.data.Repository
import com.example.aniwatch.data.Series
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CommonVM: ViewModel() {

//    init {
//        getCharacter()
//    }
//    val liveDataAnimes = MutableLiveData<List<Series>>()
//    private val repository = Repository(NetworkUtils.getInstance())
//    private fun getCharacter() {
//
//        viewModelScope.launch(Dispatchers.IO) {
//
//            val response = repository.getAnime(code = "nanatsu-no-taizai-kamigami-no-gekirin")
//            if (response.isSuccessful) {
//                val animes = response.body()
//                Log.i("MyTag", animes.toString())
//                withContext(Dispatchers.Main) {
//
//                    liveDataAnimes.postValue(animes!!.playlist)
//                }
//
//            }
//        }
//
//    }
}