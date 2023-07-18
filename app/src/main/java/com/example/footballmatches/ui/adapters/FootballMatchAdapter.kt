package com.example.footballmatches.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballmatches.R
import com.example.footballmatches.repository.models.FootballMatch
import kotlinx.android.synthetic.main.match_item.view.*

class FootballMatchAdapter :
    RecyclerView.Adapter<FootballMatchAdapter.FootballMatchAdapterViewHolder>() {
    inner class FootballMatchAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var footballMatchList = ArrayList<FootballMatch>()

    fun setFootballMatchList(footballMatchList: List<FootballMatch>) {
        this.footballMatchList = footballMatchList as ArrayList<FootballMatch>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FootballMatchAdapterViewHolder {
        return FootballMatchAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.match_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FootballMatchAdapterViewHolder, position: Int) {
        val footballMatch = footballMatchList[position]
        holder.itemView.apply {
            tv_date.text = footballMatch.match_date
            tv_home_team.text = footballMatch.match_hometeam_name
            val score =
                "${footballMatch.match_hometeam_score}\n${footballMatch.match_awayteam_score}"
            tv_score.text = score
            tv_away_team.text = footballMatch.match_awayteam_name
            tv_country.text = footballMatch.country_name
            Glide.with(this).load(footballMatch.country_logo).into(iv_country)
            Glide.with(this).load(footballMatch.team_home_badge).into(iv_hometeam)
            Glide.with(this).load(footballMatch.team_away_badge).into(iv_awayteam)
        }
    }

    override fun getItemCount(): Int {
        return footballMatchList.size
    }
}