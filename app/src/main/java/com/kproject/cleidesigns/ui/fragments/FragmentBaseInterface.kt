package com.kproject.cleidesigns.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import com.kproject.cleidesigns.models.Design

interface FragmentBaseInterface {

    fun initializeLayout(
        design: Design,
        layoutVersion: Int?,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View

    fun initializeXmlLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View

    fun initializeComposeLayout(): View

    fun initializeViewInspirationLayout(design: Design): View
}