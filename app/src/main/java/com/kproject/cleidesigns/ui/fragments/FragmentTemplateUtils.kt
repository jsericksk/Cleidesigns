package com.kproject.cleidesigns.ui.fragments
/**
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.kproject.cleidesigns.databinding.FragmentDesign1Binding
import com.kproject.cleidesigns.utils.Constants


class DesignFragment1 : Fragment(), FragmentBaseInterface {
    private var _binding: FragmentDesign1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val layoutVersion = arguments?.getInt("layoutVersion")
        return initializeLayout(layoutVersion, inflater, container)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun initializeLayout(
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
        }
        return view
    }

    override fun initializeXmlLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        _binding = FragmentDesign1Binding.inflate(inflater, container, false)
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

                }
            }
        }
    }
}*/
