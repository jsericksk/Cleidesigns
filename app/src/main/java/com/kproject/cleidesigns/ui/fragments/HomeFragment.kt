package com.kproject.cleidesigns.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.GridLayoutManager
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.databinding.FragmentHomeBinding
import com.kproject.cleidesigns.models.Design
import com.kproject.cleidesigns.ui.adapters.DesignAdapter
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
        binding.tbMainToolbar.title = ""
        (context as AppCompatActivity).setSupportActionBar(binding.tbMainToolbar)
        setHasOptionsMenu(true)

        initializeRecyclerView()
        return binding.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_options -> {

            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initializeRecyclerView() {
        val designList = ListUtils.createList()
        val layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = DesignAdapter(
            designList = designList, onItemClickListener = { design, view, position ->
                showPopupMenu(design, view, position)
            }
        )
        binding.rvDesignList.adapter = adapter
        binding.rvDesignList.layoutManager = layoutManager
    }

    private fun showPopupMenu(design: Design, view: View, position: Int) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.inflate(R.menu.menu_popup_main)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item?.itemId) {
                R.id.menu_xml_vesion -> {
                   navigate(design.fragmentId, Constants.VIEW_IN_XML)
                }
                R.id.menu_compose_version -> {
                    navigate(design.fragmentId, Constants.VIEW_IN_COMPOSE)
                }
                R.id.menu_design_inspiration -> {
                    navigate(design.fragmentId, Constants.VIEW_INSPIRATION)
                }
            }
            false
        }
        popupMenu.show()
    }

    private fun navigate(fragmentId: Int, layoutVersion: Int) {
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_left
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_right
                popExit = R.anim.slide_out_right
            }
        }
        val bundle = Bundle()
        bundle.putInt("layoutVersion", layoutVersion)
        findNavController().navigate(fragmentId, bundle, options)
    }
}