package com.example.zaratest.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.example.zaratest.R
import com.example.zaratest.databinding.FragmentSingleCharacterBinding
import com.example.zaratest.viewModel.AllCharactersViewModel
import com.squareup.picasso.Picasso

class SingleCharacterFragment : Fragment() {

    private val viewmodel : AllCharactersViewModel by activityViewModels()
    private lateinit var singleCharacterBinding: FragmentSingleCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        singleCharacterBinding = FragmentSingleCharacterBinding.inflate(inflater, container, false)
        return singleCharacterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        singleCharacterBinding.text.text = viewmodel.name.value
        viewmodel.image.value?.let { singleCharacterBinding.imageDetail.setImageUrl(it) }
    }

    private fun ImageView.setImageUrl(url:String){
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .into(this)
    }
}