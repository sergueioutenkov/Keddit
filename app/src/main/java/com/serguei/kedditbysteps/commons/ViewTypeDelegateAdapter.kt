package com.serguei.kedditbysteps.commons

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

// Created by Serguei Outenkov on 4/24/16.
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)

}