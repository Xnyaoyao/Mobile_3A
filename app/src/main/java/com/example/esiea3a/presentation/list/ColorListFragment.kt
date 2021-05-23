package com.example.esiea3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.ColorListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ColorListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = ColorAdaptater(listOf(), ::onClickedColor)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.color_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ColorListFragment.adapter
        }

        Singletons.colorApi.getColorList().enqueue(object: Callback<List<ColorListResponse>> {
            override fun onResponse(call: Call<List<ColorListResponse>>, response: Response<List<ColorListResponse>>) {
                if(response.isSuccessful && response.body() != null){
                    val colorListResponse: List<ColorListResponse> = response.body()!!
                    //adapter.updateList(colorListResponse)
                }
            }

            override fun onFailure(call: Call<List<ColorListResponse>>, t: Throwable) {
                //TODO("Not yet implemented")
            }
        })
    }

    private fun onClickedColor(id: Int){
        findNavController().navigate(R.id.navigateToColorDetailFragment, bundleOf("colorId" to id))
    }
}