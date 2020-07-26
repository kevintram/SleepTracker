package com.kiwicorp.sleeptracker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kiwicorp.sleeptracker.data.PickUp
import com.kiwicorp.sleeptracker.data.source.PickUpRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val repository: PickUpRepository) : ViewModel() {
    val pickUps: LiveData<List<PickUp>> = repository.pickups

    val numberOfPickUpsToday = Transformations.map(pickUps) { pickUps ->
        pickUps.count { pickUp ->
            pickUp.date.toLocalDate() == LocalDate.now()
        }
    }

    fun addPickUp() {
        viewModelScope.launch {
            repository.insertPickUp(PickUp())
        }
    }

    fun deletePickUps() {
        viewModelScope.launch {
            repository.deletePickUps()
        }
    }
}