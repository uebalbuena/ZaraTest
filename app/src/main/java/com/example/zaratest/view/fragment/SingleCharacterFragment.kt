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

    private val viewModel : AllCharactersViewModel by activityViewModels()
    lateinit var singleCharacterBinding: FragmentSingleCharacterBinding

    private val userId: Int by lazy {
        arguments?.getInt(EXTRA_CHARACTER_ID) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        singleCharacterBinding = FragmentSingleCharacterBinding.inflate(inflater, container, false)
        return singleCharacterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getSingleCharacter(userId)
        singleCharacterBinding.characterName.text = viewModel.name.value
        viewModel.image.value?.let { singleCharacterBinding.imageDetail.setImageUrl(it) }
    }

    private fun ImageView.setImageUrl(url:String){
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .into(this)
    }

    private fun getSingleCharacter(user: Int){
        if (view!=null){
        viewModel.getSingleCharacter(user).observe(viewLifecycleOwner){
            singleCharacterBinding.characterStatus.text = it.status
            singleCharacterBinding.characterSpecies.text = it.species
            singleCharacterBinding.characterGender.text = it.gender
        }
        }
    }

    companion object {
        const val EXTRA_CHARACTER_ID = "EXTRA_CHARACTER_ID"
        fun newInstance(characterId: Int): SingleCharacterFragment {
            return SingleCharacterFragment().apply {
                arguments = Bundle().apply {
                    putInt(EXTRA_CHARACTER_ID, characterId)
                }
            }
        }
    }

}