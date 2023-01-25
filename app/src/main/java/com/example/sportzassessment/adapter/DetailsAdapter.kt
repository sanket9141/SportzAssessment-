package com.example.sportzassessment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzassessment.model.PlayerDetail
import com.example.sportzinter.databinding.PlayerListBinding

class DetailsAdapter(val context: Context, val playerDetailData: MutableList<PlayerDetail>) :
    RecyclerView.Adapter<DetailsAdapter.MatchDetailHolder>() {


    class MatchDetailHolder(val binding: PlayerListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDetailHolder {
        return MatchDetailHolder(
            PlayerListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MatchDetailHolder, position: Int) {
        val playerData = playerDetailData[position]
        holder.apply {
            binding.playerName.text = playerData.NameFull
        }
    }

    override fun getItemCount() = playerDetailData.size
}
