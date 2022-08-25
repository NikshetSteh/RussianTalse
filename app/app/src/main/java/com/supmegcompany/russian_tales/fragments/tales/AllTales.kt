package com.supmegcompany.russian_tales.fragments.tales

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supmegcompany.russian_tales.MainActivity
import com.supmegcompany.russian_tales.R
import com.supmegcompany.russian_tales.data.ResourceManager
import com.supmegcompany.russian_tales.data.Tales
import com.supmegcompany.russian_tales.databinding.FragmentAllTalesBinding
import com.supmegcompany.russian_tales.databinding.TalesItemBinding

class AllTales : Fragment() {

    private lateinit var bindings: FragmentAllTalesBinding
    private var adapter = AllTalesAdapter()

    private fun find(view: View){
        MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_find_tales)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = FragmentAllTalesBinding.inflate(inflater, container, false)
        return bindings.root
    }

    override fun onStart() {
        super.onStart()
        adapter.context = requireContext()
        bindings.apply {
            tales.layoutManager = LinearLayoutManager(context)
            tales.adapter = adapter
        }

        adapter.removeAll()

        for(i in 0 until ResourceManager.getTalesListSize()){
            adapter.addTales(ResourceManager.getTales(i))
        }

        bindings.findTales.setOnClickListener(::find)
    }

}
class AllTalesAdapter: RecyclerView.Adapter<AllTalesHolder>(){
    private var talesList = ArrayList<Tales>()

    override fun getItemCount(): Int {
        return talesList.size
    }

    private fun onClickToItem(view: View){
        if(mode){
            TalesView.nowTales = ResourceManager.getEditTales(
                context,
                view.findViewById<TextView>(R.id.id).text.toString().toInt()
            )
            MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_tales_view)
        }else {
            TalesView.nowTales = ResourceManager.getTales(
                view.findViewById<TextView>(R.id.id).text.toString().toInt()
            )
            MainActivity.mainActivity.fragmentTransactionById(R.layout.fragment_tales_view)
        }
    }

    override fun onBindViewHolder(holder: AllTalesHolder, position: Int) {
        holder.bind(talesList[position], ::onClickToItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTalesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tales_item, parent, false)
        return AllTalesHolder(view)
    }

    fun addTales(tales: Tales){
        talesList.add(tales)
        notifyDataSetChanged()
    }

    fun removeAll(){
        val iterator = talesList.iterator()
        while(iterator.hasNext()){
            val item = iterator.next()
            iterator.remove()
        }
    }

    var mode = false
    lateinit var context: Context

}

class AllTalesHolder(item: View): RecyclerView.ViewHolder(item){
    private val binding = TalesItemBinding.bind(item)

    private var active = false

    fun bind(tales: Tales, onClick: (view: View) -> Unit)  = with(binding){
        if(!active) {
            name.text = tales.name
            preview.setImageResource(tales.previewID)
            cardContainer.setOnClickListener(onClick)
            id.text = tales.id.toString()
            active = true
        }
    }
}
