package com.babacan05.cineme.feature_movie.presentation.cineme_main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babacan05.cineme.feature_movie.domain.model.FavouredTitle
import com.babacan05.cineme.feature_movie.domain.use_case.CinemeUseCases
import com.babacan05.cineme.feature_movie.domain.util.DataResult

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TitlesViewModel @Inject constructor(
    private val cinemeUseCases: CinemeUseCases
):ViewModel() {
    private val _titlesState = MutableStateFlow(value = TitlesState())
    val titlesState: StateFlow<TitlesState> get() = _titlesState.asStateFlow()
init {
    viewModelScope.launch {
        val top100Result = async { loadTop100Titles() }
        val loadFavouredList = async {loadFavouredList() }
        val loadFavouredIdList=async { loadFavouredIdList()}

        top100Result.await()
        loadFavouredList.await()
        loadFavouredIdList.await()

    }


}

  suspend  private fun loadFavouredIdList() {
      cinemeUseCases.getFavouredTitleIds().collect{result->
          _titlesState.update {
              it.copy(favouredIdList = result)
          }


      }
    }

    suspend private fun loadFavouredList() {
        cinemeUseCases.getFavouredTitles().collect{result->
            _titlesState.update {
                it.copy(listFavouredTitles = result)
            }


        }

    }

    private  suspend fun loadTop100Titles() {
        cinemeUseCases.getTop100Title().collect { result ->
            _titlesState.update {
                it.copy(listTop100Titles = result)
            }
        }

    }

 fun onEvent(event:TitlesEvent){
viewModelScope.launch {  when(event){

    is TitlesEvent.SetFavoured -> cinemeUseCases.updateFavouredTitle(FavouredTitle(titleId = event.titleId, favoured =event.isFavoured))
    is TitlesEvent.SearchTitle -> getMovies(event.search)
}
}

 }

   private suspend fun getMovies(search: String) {
        cinemeUseCases.getTitles(search).collect { result ->
            when (result) {
                is DataResult.Success -> _titlesState.update {
                    it.copy(listSearchedTitles = result.data.movieList.filter { title-> title.id.startsWith("tt") }) }
                is DataResult.Error -> _titlesState.update {
                    it.copy(listSearchedTitles = emptyList())
                }

            }


        }


    }
private suspend fun getActors(search: String){
    cinemeUseCases.getTitles(search).collect{result->
        when(result){
            is DataResult.Error -> TODO()
            is DataResult.Success -> TODO()
        }

    }

}

}


