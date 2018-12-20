package com.martinb.marvelapp.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Comics

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ComicsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ComicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ComicsFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var listener: OnFragmentInteractionListener? = null
    private var comics: Comics? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            comics = arguments?.getParcelable("comics")
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridview: GridView = view.findViewById(R.id.gridview)
        comics.let {
            gridview.adapter = ComicsAdapter(this.requireContext(), comics.items)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComicsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(comics: Comics) =
                ComicsFragment().apply {
                    arguments = Bundle().apply {
                        arguments.putParcelable("comics",comics)
                    }
                }
    }
}
