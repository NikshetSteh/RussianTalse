package com.supmegcompany.russian_tales.fragments.tales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.supmegcompany.russian_tales.MainActivity
import com.supmegcompany.russian_tales.R
import com.supmegcompany.russian_tales.data.ResourceManager
import com.supmegcompany.russian_tales.databinding.FragmentAllEditTalesBinding

class AllEditTales : Fragment() {

    private lateinit var binding: FragmentAllEditTalesBinding
    private var adapter = AllTalesAdapter()

    override fun onStart() {
        super.onStart()

        adapter.removeAll()

        binding.apply {
            tales.layoutManager = LinearLayoutManager(context)
            tales.adapter = adapter
        }

        adapter.mode = true
        context.also {
            if (it != null) {
                adapter.context = it
            }
        }

        for (i in ResourceManager.getEditTales(requireContext())){
            adapter.addTales(ResourceManager.getEditTales(requireContext(), i))
        }

        binding.addTales.setOnClickListener(::newTales)
        binding.removeTales.setOnClickListener(::removeTales)
    }

    private fun newTales(view: View){
        MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_tales_editor)
    }

    private fun removeTales(view: View){
        ResourceManager.removeTales(requireContext(), binding.removeTalesId.text.toString())
        ResourceManager.start(requireContext())

        adapter.removeAll()

        for (i in ResourceManager.getEditTales(requireContext())){
            adapter.addTales(ResourceManager.getEditTales(requireContext(), i))
        }

        adapter.notifyDataSetChanged()


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllEditTalesBinding.inflate(inflater, container, false)
        return binding.root
    }
}