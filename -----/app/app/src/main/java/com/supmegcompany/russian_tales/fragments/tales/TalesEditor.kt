package com.supmegcompany.russian_tales.fragments.tales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.supmegcompany.russian_tales.MainActivity
import com.supmegcompany.russian_tales.R
import com.supmegcompany.russian_tales.data.ResourceManager
import com.supmegcompany.russian_tales.data.Tales
import com.supmegcompany.russian_tales.databinding.FragmentTalesEditorBinding

class TalesEditor : Fragment() {
    private lateinit var binding: FragmentTalesEditorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTalesEditorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.button.setOnClickListener(::save)
    }

    fun save(view: View){
        ResourceManager.addEditTales(requireContext(), Tales(
            0,
            binding.talesNameEdit.text.toString(),
            binding.talesTextEdit.text.toString(),
            binding.talesAuthorEdit.text.toString(),
            binding.talesPlotEdit.text.toString(),
            binding.talesCharactersEdit.text.toString(),
            binding.talesHistoryCreationEdit.text.toString(),
            0
        )
        )
        MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_all_edit_tales)
    }
}