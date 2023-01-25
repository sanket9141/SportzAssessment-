package com.example.sportzassessment.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sportzassessment.repository.MatchRepository
import com.example.sportzassessment.viewmodel.MatchDataViewModel

class Matchfactory constructor(private val repository: MatchRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MatchDataViewModel::class.java)) {
            MatchDataViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
