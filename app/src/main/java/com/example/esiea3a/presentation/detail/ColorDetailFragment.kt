package com.example.esiea3a.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.esiea3a.R
import com.example.esiea3a.presentation.Singletons
import com.example.esiea3a.presentation.api.ColorDetailResponse
import com.example.esiea3a.presentation.api.ColorListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ColorDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.color_detail_title)
        callApi()
    }

    private fun callApi() {

        Singletons.colorApi.getColorDetail().enqueue(object: Callback<List<ColorDetailResponse>> {
            override fun onFailure(call: Call<List<ColorDetailResponse>>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<ColorDetailResponse>>, response: Response<List<ColorDetailResponse>>) {
                if (response.isSuccessful && response.body() != null){
                    //textViewName.text = response.body()!!.title
                    //val colorDetailResponse: ColorDetailResponse = response.body()!!
                }
            }
        })
    }
}