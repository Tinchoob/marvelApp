package com.martinb.marvelapp.ui

import android.content.Intent
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

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var character : Result

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_description, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val characterImagePath = "${character.thumbnail.path}/standard_fantastic.${character.thumbnail.extension}"
        character_name.text = character.name
        desciption.text = if(character.description != "") character.description else "No description avaliable!!"
        Picasso.get().load(Uri.parse(characterImagePath)).into(image_character)
        extra_info.setOnClickListener {
            val intent = Intent(context,FullCharacterInfoActivity::class.java)
            val bundle = Bundle()
            bundle.putString("characterId",character.id)
            bundle.putString("characterImagePath",characterImagePath)
            bundle.putString("characterName",character.name)
            intent.putExtras(bundle)
            startActivity(intent)
        }

        floating_action_button.setOnClickListener {
            dismiss()
        }

    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window.setLayout(width, height)
        }
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    interface OnFragmentInteractionListener {
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
