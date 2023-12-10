package com.kproject.cleidesigns.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.GridLayoutManager
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.databinding.FragmentHomeBinding
import com.kproject.cleidesigns.presentation.main.Design
import com.kproject.cleidesigns.presentation.main.DesignAdapter
import com.kproject.cleidesigns.utils.Constants
import com.kproject.cleidesigns.utils.ListUtils


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initializeRecyclerView()
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun initializeRecyclerView() {
        val designList = ListUtils.createList()
        val layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = DesignAdapter(
            designList = designList, onItemClickListener = { design, view, position ->
                showPopupMenu(design, view)
            }
        )
        binding.rvDesignList.adapter = adapter
        binding.rvDesignList.layoutManager = layoutManager
    }

    private fun showPopupMenu(design: Design, view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.inflate(R.menu.menu_popup_main)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.menu_xml_vesion -> {
                   navigate(design, Constants.VIEW_IN_XML)
                }
                R.id.menu_compose_version -> {
                    navigate(design, Constants.VIEW_IN_COMPOSE)
                }
                R.id.menu_design_inspiration -> {
                    navigate(design, Constants.VIEW_INSPIRATION)
                }
            }
            false
        }

        try {
            val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMPopup.isAccessible = true
            val mPopup = fieldMPopup.get(popupMenu)
            mPopup.javaClass
                .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)
        } catch (e: Exception){
            Log.e("HomeFragment", "Error showing popup menu icons.", e)
        } finally {
            popupMenu.show()
        }
    }

    private fun navigate(design: Design, layoutVersion: Int) {
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        val bundle = Bundle()
        bundle.putParcelable("design", design)
        bundle.putInt("layoutVersion", layoutVersion)
        findNavController().navigate(design.fragmentId, bundle, options)
    }
}