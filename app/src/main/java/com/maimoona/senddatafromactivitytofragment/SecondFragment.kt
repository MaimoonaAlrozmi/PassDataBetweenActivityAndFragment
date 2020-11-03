package com.maimoona.senddatafromactivitytofragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

private const val MYname = "myColor"
private const val ARG_PARAM2 = "param2"

class SecondFragment : Fragment() {

    private lateinit var sendTextview: TextView

    companion object {

        fun newInstance(name: String?) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(MYname, name)

                }
            }
    }

    // private var myColor: String? = null
    /**********this is another way***********/
    var myName: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            myName = it.getString(MYname)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        sendTextview = view.findViewById(R.id.send_to_firstFragment) as TextView
        sendTextview.setText(myName)
        return view;
    }
}