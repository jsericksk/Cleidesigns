package com.kproject.cleidesigns.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.presentation.main.Design
import com.kproject.cleidesigns.utils.Constants

abstract class BaseFragment : Fragment() {
    private var _binding: ViewBinding? = null
    private val binding get() = _binding!!

    abstract fun initializeXmlLayout(): ViewBinding

    @Composable
    abstract fun ComposeLayout()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val design = arguments?.getParcelable<Design>("design")!!
        val layoutVersion = arguments?.getInt("layoutVersion")
        return initializeLayout(design, layoutVersion)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initializeLayout(
        design: Design,
        layoutVersion: Int?
    ): View {
        lateinit var view: View
        when (layoutVersion) {
            Constants.VIEW_IN_XML -> {
                view = xmlLayout()
            }
            Constants.VIEW_IN_COMPOSE -> {
                view = composeLayout()
            }
            Constants.VIEW_INSPIRATION -> {
                view = viewInspirationLayout(design)
            }
        }
        return view
    }

    private fun xmlLayout(): View {
        _binding = initializeXmlLayout()
        return binding.root
    }

    private fun composeLayout(): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    this@BaseFragment.ComposeLayout()
                }
            }
        }
    }

    private fun viewInspirationLayout(design: Design): View {
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