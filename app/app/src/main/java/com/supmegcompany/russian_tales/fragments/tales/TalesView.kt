package com.supmegcompany.russian_tales.fragments.tales

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.supmegcompany.russian_tales.data.Tales
import com.supmegcompany.russian_tales.databinding.FragmentTalesViewBinding


class TalesView : Fragment() {

    private lateinit var building: FragmentTalesViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        building = FragmentTalesViewBinding.inflate(inflater, container, false)
        return building.root
    }

    override fun onStart() {
        super.onStart()

        building.apply {
            talesName.text = nowTales.name
            talesAuthor.text = nowTales.author
            talesCharacters.text = nowTales.characters
            talesHistoryCreation.text = nowTales.historyCreation
            talesPlot.text = nowTales.plot
            talesText.text = nowTales.text
            image.setImageResource(nowTales.previewID)
        }
    }

    companion object{
        lateinit var nowTales: Tales
    }

}