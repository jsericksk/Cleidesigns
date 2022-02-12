package com.kproject.cleidesigns.ui.fragments.design3

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.databinding.FragmentDesign3Binding
import com.kproject.cleidesigns.models.Design
import com.kproject.cleidesigns.ui.ViewInspiration
import com.kproject.cleidesigns.ui.fragments.FragmentBaseInterface
import com.kproject.cleidesigns.utils.Constants

class Design3Fragment : Fragment(), FragmentBaseInterface {
    private var _binding: FragmentDesign3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val design = arguments?.getParcelable<Design>("design")!!
        val layoutVersion = arguments?.getInt("layoutVersion")
        return initializeLayout(design, layoutVersion, inflater, container)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun initializeLayout(
        design: Design,
        layoutVersion: Int?,
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        lateinit var view: View
        when (layoutVersion) {
            Constants.VIEW_IN_XML -> {
                view = initializeXmlLayout(inflater, container)
            }
            Constants.VIEW_IN_COMPOSE -> {
                view = initializeComposeLayout()
            }
            Constants.VIEW_INSPIRATION -> {
                view = initializeViewInspirationLayout(design)
            }
        }
        return view
    }

    override fun initializeXmlLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        _binding = FragmentDesign3Binding.inflate(inflater, container, false)

        with (binding) {
            cpIncome.setOnClickListener {
                cpIncome.setChipBackgroundColorResource(R.color.chip_background_selected)
                cpIncome.setTextColor(Color.WHITE)
                cpExpenses.setChipBackgroundColorResource(R.color.chip_background_unselected)
                cpExpenses.setTextColor(Color.parseColor("#737373"))
            }
            cpExpenses.setOnClickListener {
                cpIncome.setChipBackgroundColorResource(R.color.chip_background_unselected)
                cpIncome.setTextColor(Color.parseColor("#737373"))
                cpExpenses.setChipBackgroundColorResource(R.color.chip_background_selected)
                cpExpenses.setTextColor(Color.WHITE)
            }

            bnBottomNavigation.selectedItemId = R.id.menu_statistics

            Design3Utils.initBarChart(barChart = bcChart)
        }
        return binding.root
    }

    override fun initializeComposeLayout(): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {

                }
            }
        }
    }

    override fun initializeViewInspirationLayout(design: Design): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    ViewInspiration(
                        design = design,
                        navigateBack = {
                            findNavController().popBackStack(
                                R.id.homeFragment,
                                false
                            )
                        }
                    )
                }
            }
        }
    }
}