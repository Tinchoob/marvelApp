package com.martinb.marvelapp.ui

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_character_description.*

class CharacterDescriptionFragment : DialogFragment() {
    // TODO: Rename and change types of parameters

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var character : Result

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_description, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        desciption.text = if(character.description != "") character.description else "No description avaliable!!"
        Picasso.get().load(Uri.parse("${character.thumbnail.path}/standard_fantastic.${character.thumbnail.extension}")).into(image_character)
        extra_info.setOnClickListener {
            val intent = Intent(context,FullCharacterInfoActivity::class.java)
            val bundle = Bundle()
            bundle.putString("characterId",character.id)
            bundle.putString("characterName",character.name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(characterSelected: Result) =
                CharacterDescriptionFragment().apply {
                    arguments = Bundle().apply {
                        character = characterSelected
                    }
                }
    }
}
