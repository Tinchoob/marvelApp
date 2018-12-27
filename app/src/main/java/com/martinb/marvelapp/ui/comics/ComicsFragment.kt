package com.martinb.marvelapp.ui.comics

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.ComicsResults
import org.koin.android.ext.android.inject

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ComicsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ComicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ComicsFragment : Fragment(), ComicsView {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private var listener: OnFragmentInteractionListener? = null
    private var characterId2: String? = ""
    private val comicsFragmentPresenter: ComicsFragmentPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        comicsFragmentPresenter.attachView(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_comics, container, false)

        swipeRefreshLayout = view.findViewById(R.id.comics_refresh)
        swipeRefreshLayout.isRefreshing = true
        comicsFragmentPresenter.getComicsByCharacter(characterId2 ?: return view)
        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun getComicsData(comicsResult: ComicsResults) {
        swipeRefreshLayout.isRefreshing = false
        if(view != null){
            val gridview: GridView = view!!.findViewById(R.id.gridview)
            gridview.adapter = ComicsAdapter(context!!, comicsResult.data.comicInformation)
        }

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
        fun newInstance(characterId: String?) =
                ComicsFragment().apply {
                    arguments = Bundle().apply {
                        //   arguments?.putString("characterId",characterId)
                        characterId2 = characterId;
                    }
                }
    }
}
