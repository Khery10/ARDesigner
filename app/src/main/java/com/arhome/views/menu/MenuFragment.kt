package com.arhome.views.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.arhome.R
import com.arhome.views.menu.categories.CategoriesFragment
import kotlinx.android.synthetic.main.menu_fragment.*
import kotlinx.android.synthetic.main.menu_fragment.view.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.menu_fragment, container, false)

        val creators = mapOf<Int, () -> Fragment>(0 to { CategoriesFragment() })
        view.catalogs_viewer.apply {
            adapter = object : FragmentStateAdapter(this@MenuFragment) {

                override fun getItemCount() = creators.size
                override fun createFragment(position: Int) = creators[position]?.invoke()!!
            }

            isUserInputEnabled = false
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createViewAnimation(view)
    }

    private fun createViewAnimation(view: View) {
        OverScrollDecoratorHelper.setUpOverScroll(horizontal_scroll_header)

        image_to_camera.setOnClickListener { gotoCamera() }
    }

    private fun gotoCamera(){
        findNavController().navigate(MenuFragmentDirections.menuToCamera())
    }
}