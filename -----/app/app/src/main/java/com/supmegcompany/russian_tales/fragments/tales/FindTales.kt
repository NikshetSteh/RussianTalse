package com.supmegcompany.russian_tales.fragments.tales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.supmegcompany.russian_tales.data.ResourceManager
import com.supmegcompany.russian_tales.data.Tales
import com.supmegcompany.russian_tales.databinding.FragmentFindTalesBinding

class FindTales : Fragment() {

    private fun getFinedTales(name: String, person: String): Array<out Any> {
        val tales = ArrayList<Tales>()

        for (i in 0 until ResourceManager.getTalesListSize()){
            val nowTales = ResourceManager.getTales(i)
            if(nowTales.name.lowercase().contains(name) && nowTales.characters.lowercase().contains(person)){
                tales.add(nowTales)
            }
        }

        return  tales.toArray()

    }

    private fun showFinedTales(view: View){
        adapter.removeAll()
        for (i in getFinedTales(building.findByName.editText?.text.toString().lowercase(), building.findByPerson.editText?.text.toString().lowercase())){
            adapter.addTales(i as Tales)
        }
        adapter.notifyDataSetChanged()
    }

    private lateinit var building: FragmentFindTalesBinding
    private var adapter: AllTalesAdapter = AllTalesAdapter()

    override fun onStart() {
        super.onStart()

        building.apply {
            findedTales.layoutManager = LinearLayoutManager(context)
            findedTales.adapter = adapter

            findB.setOnClickListener(::showFinedTales)
        }

        showFinedTales(building.findB)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        building = FragmentFindTalesBinding.inflate(inflater, container, false)
        return building.root
    }

}