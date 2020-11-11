package com.example.madlevel5task2.Ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.Models.Game
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.FragmentGameCardBinding
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Adapter(private val games: List<Game>) :
        RecyclerView.Adapter<Adapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = FragmentGameCardBinding.bind(itemView)

        @RequiresApi(Build.VERSION_CODES.O)
        fun dataBind(backlogGame: Game) {
            binding.title.text = backlogGame.name
            binding.platform.text = backlogGame.platform
            binding.date.text =
                    backlogGame.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))
        }
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.fragment_game_card, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }

}