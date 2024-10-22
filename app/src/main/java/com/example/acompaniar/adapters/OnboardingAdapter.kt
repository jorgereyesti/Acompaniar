package com.example.acompaniar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.acompaniar.OnboardingItem
import com.example.acompaniar.R
import com.example.acompaniar.databinding.RowItemviewPagerBinding


class OnboardingAdapter(private val context: Context) : RecyclerView.Adapter<OnboardingAdapter.ViewHolder>() {
    //objetct
    private val onboardingItems = listOf(
        OnboardingItem(R.drawable.onboarding0, context.getString(R.string.onb_title1) , context.getString(R.string.boarding1)),
        OnboardingItem(R.drawable.onboarding1, context.getString(R.string.onb_title2) , context.getString(R.string.boarding2)),
        OnboardingItem(R.drawable.onboarding2, context.getString(R.string.onb_title3) , context.getString(R.string.boarding3))
    )
    class ViewHolder(val binding: RowItemviewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowItemviewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = onboardingItems[position]
        with(holder) {
            binding.apply {
                //Bind views with some data here
                imgBoarding.setImageResource(item.imgBoarding)
                tvBoarding.text = item.tvBoarding
                tvsubtBoarding.text = item.tvSubtitleBoarding
            }
        }
    }
    override fun getItemCount() = 3
}