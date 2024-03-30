package com.babacan05.cineme.feature_movie.presentation.cineme_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babacan05.cineme.feature_movie.domain.model.FavouredTitle
import com.babacan05.cineme.feature_movie.domain.model.TitleDetail
import com.babacan05.cineme.feature_movie.domain.use_case.CinemeUseCases
import com.babacan05.cineme.feature_movie.domain.util.DataResult
import com.babacan05.cineme.feature_movie.presentation.cineme_main.TitlesState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val cinemeUseCases: CinemeUseCases
): ViewModel(){
    private val _detailState = MutableStateFlow(value = DetailState())
    val detailState: StateFlow<DetailState> get() = _detailState.asStateFlow()
    init {
        viewModelScope.launch {
            val loadFavouredIdList=async { loadFavouredIdList()}

            loadFavouredIdList.await()

        }
    }
     suspend fun loadTitleDetail(id:String){

         cinemeUseCases.getTitleDetail(id).collect{ dataResult ->
             _detailState.update { it.copy(detailResult =dataResult) }
when(dataResult){
    is DataResult.Error -> {dataResult.message}
    is DataResult.Success -> println(dataResult.data.videoUrl)
}

         }

     }
    fun setMenuState(menustate: Menustate){
        _detailState.update {
            it.copy(menustate=menustate)
        }
    }
    fun getVideoState()=_detailState.value.videoState
    fun setVideoState(videoState: VideoState){
        _detailState.update { it.copy(videoState = videoState) }
    }
 fun updateFavouredTitle(id:String,isFavoured: Boolean) {
  viewModelScope.launch { cinemeUseCases.updateFavouredTitle(FavouredTitle(id,isFavoured)) }

 }

 private   suspend   fun loadFavouredIdList() {
        cinemeUseCases.getFavouredTitleIds().collect{result->
            _detailState.update {
                it.copy(favouredIdList = result)
            }


        }
    }

}
