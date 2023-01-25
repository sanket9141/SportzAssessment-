package com.example.sportzassessment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportzassessment.adapter.Click
import com.example.sportzassessment.adapter.MatchDataAdapter
import com.example.sportzassessment.api.RetroServices
//import com.example.sportzassessment.databinding.ActivityMainBinding
import com.example.sportzassessment.factory.Matchfactory
import com.example.sportzassessment.model.MatchData
import com.example.sportzassessment.repository.MatchRepository
import com.example.sportzassessment.viewmodel.MatchDataViewModel
import com.example.sportzinter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Click {
    lateinit var viewModel: MatchDataViewModel
    private val retrofitService = RetroServices.getInstance()
    lateinit var binding: ActivityMainBinding
    private var matchDataList: ArrayList<MatchData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this, Matchfactory(MatchRepository(retrofitService))).get(
            MatchDataViewModel::class.java
        )

        viewModel.matchData.observe(this, Observer {
            SetData(arrayListOf(it))

        }
        )
        viewModel.indData.observe(this, Observer {
            Log.d("India", it.toString())
            SetData(arrayListOf(it))
        })
        viewModel.getMatch()
        viewModel.getIND()

    }

    private fun SetData(data: List<MatchData>) {
        matchDataList.addAll(data)
        val adapter = MatchDataAdapter(this, matchDataList, this)
        binding.ListRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.ListRecyclerView.adapter = adapter

    }

    override fun onclick(data: MatchData) {
        val intent = Intent(this, DetailsActivity::class.java)
        if (data.Teams?.nz != null &&
            data.Teams?.nz?.NameFull.toString().isNotEmpty()
        ) {
            val bundle = Bundle()
            bundle.putSerializable("name", data.Teams)
            intent.putExtra("match2", "indvsnz")
            intent.putExtras(bundle)
        } else {
            val bundle = Bundle()
            bundle.putSerializable("name", data.Teams)
            intent.putExtra("match1", "savspak")
            intent.putExtras(bundle)
        }
        startActivity(intent)

    }
}