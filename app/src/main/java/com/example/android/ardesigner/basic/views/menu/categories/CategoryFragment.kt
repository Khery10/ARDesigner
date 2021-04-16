package com.example.android.ardesigner.basic.views.menu.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.ardesigner.basic.AppExecutors
import com.example.android.ardesigner.basic.R
import com.example.android.ardesigner.basic.binding.FragmentDataBindingComponent
import com.example.android.ardesigner.basic.data.Category
import com.example.android.ardesigner.basic.data.ITextImageData
import com.example.android.ardesigner.basic.di.Injectable
import com.example.android.ardesigner.basic.views.common.CatalogItemsAdapter
import kotlinx.android.synthetic.main.catalog_fragment.*
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper
import javax.inject.Inject

class CategoryFragment : Fragment(), Injectable {

    @Inject
    lateinit var appExecutors: AppExecutors

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val categoriesViewModel: CategoryViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.catalog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = CatalogItemsAdapter(FragmentDataBindingComponent(this), appExecutors) {}
        catalog_item_list.adapter = adapter

        OverScrollDecoratorHelper.setUpOverScroll(catalog_item_list, OverScrollDecoratorHelper.ORIENTATION_VERTICAL)

        postponeEnterTransition()
        catalog_item_list.doOnPreDraw {
            startPostponedEnterTransition()
        }

        initTypesList(adapter)
    }

    private fun initTypesList(adapter: CatalogItemsAdapter) {

        categoriesViewModel.categories.observe(viewLifecycleOwner, {
            adapter.submitList(it)
            adapter.notifyDataSetChanged()
        })

        categoriesViewModel.fetchCategories()
    }
}