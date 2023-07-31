package com.eddwar.tote.presentation.groseries

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddwar.tote.core.Constants.Companion.NO_VALUE
import com.eddwar.tote.domain.model.Grosery
import com.eddwar.tote.domain.repository.GroseryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroseriesViewModel @Inject constructor(
    private val repo: GroseryRepository
): ViewModel() {

    var grosery by mutableStateOf(Grosery(0, NO_VALUE, NO_VALUE, NO_VALUE))
    var openDialog by mutableStateOf(false)
    val groseries = repo.getGroseriesFromRoom()
    fun addGrosery(grosery: Grosery)= viewModelScope.launch(Dispatchers.IO)
    {
        repo.addGroseryToRoom(grosery)
    }
    fun closeDialog(){
        openDialog = false
    }
    fun openDialog(){
        openDialog = true
    }
    fun deleteGrosery(grosery: Grosery) =
        viewModelScope.launch(Dispatchers.IO){
            repo.deleteGroseryFromRoom(grosery)
        }

    fun updateName(name: String){
        grosery = grosery.copy(
            name = name
        )
    }

    fun updateAmount(amount: String){
        grosery = grosery.copy(
            amount = amount
        )
    }

    fun updateMeasure(measure: String){
        grosery = grosery.copy(
            measure = measure
        )
    }

    fun updateGrosery(grosery: Grosery) =
        viewModelScope.launch(Dispatchers.IO){
            repo.updateGroseryInRoom(grosery)
        }

    fun getGrosery(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        grosery = repo.getGroseryFromRoom(id)
    }
}