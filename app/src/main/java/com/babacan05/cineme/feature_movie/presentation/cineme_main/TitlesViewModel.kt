package com.babacan05.cineme.feature_movie.presentation.cineme_main


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.babacan05.cineme.feature_movie.domain.use_case.CinemeUseCases
import com.babacan05.cineme.feature_movie.domain.util.DataResult

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
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


        // "harry" aramasını yap, tamamlandığında sonucu al
        val top100Result = async { loadTop100Titles() }.await()
           }
}
    suspend fun loadTop100Titles() {
        cinemeUseCases.getTop100Title().collect { result ->
            _titlesState.update {
                it.copy(listTop100Titles = result)
            }
        }

    }


    suspend fun gethMovies(search: String) {
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
suspend fun getActors(search: String){
    cinemeUseCases.getTitles(search).collect{result->
        when(result){
            is DataResult.Error -> TODO()
            is DataResult.Success -> TODO()
        }

    }

}

}


