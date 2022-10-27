package com.example.foodapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.foodapp.ui.viewmodel.YemekDetayViewModel
import com.example.foodapp.R
import com.example.foodapp.Yemekler
import com.example.foodapp.databinding.FragmentAnasayfaBinding
import com.example.foodapp.ui.adapter.YemeklerAdapter
import com.example.foodapp.ui.viewmodel.AnasayfaViewModel

class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa,container, false)

        tasarim.toolbarAnasayfa.title = "Anasayfa"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        requireActivity().addMenuProvider(object : MenuProvider{

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        //Buraya Yemek Listesi tanımlayacağız sonradan bu listeyi Retrofit ile alacağız
        viewModel.yemeklerListesi.observe(viewLifecycleOwner){
            tasarim.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
            val adapter = YemeklerAdapter(requireContext(),it)
            tasarim.rv.adapter = adapter
        }


        return tasarim.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }












    override fun onQueryTextSubmit(query: String): Boolean {
    ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
    ara(newText)
        return true
    }

    fun ara(aramaKelimesi:String){
    Log.e("Yemek Ara",aramaKelimesi)
    }
}