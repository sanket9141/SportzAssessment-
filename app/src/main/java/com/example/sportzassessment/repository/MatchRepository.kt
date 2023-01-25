package com.example.sportzassessment.repository

import com.example.sportzassessment.api.RetroServices

class MatchRepository(private val retrofitService: RetroServices) {

   suspend fun getData() = retrofitService.
   getMatchData()

   suspend fun getInd() = retrofitService.getIndNew()



}