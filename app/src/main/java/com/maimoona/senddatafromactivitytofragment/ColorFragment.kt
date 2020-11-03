package com.maimoona.senddatafromactivitytofragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {

    private lateinit var mColorTextView: TextView
    private lateinit var btn_send: Button

    companion object {
        fun newInstance(name: String): ColorFragment {
            val args = Bundle().apply {
                putSerializable("Name", name)
            }
            return ColorFragment().apply {
                arguments = args
            }
        }
    }

    private var callbacks: Callbacks? = null

    interface Callbacks {
        fun onAddName(name: String)
    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    var mColor: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mColor = arguments?.getSerializable("Name") as String
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.color_fragment, container, false)

        if (mColor == "red")
            view.setBackgroundColor(Color.RED)
        else if (mColor == "green")
            view.setBackgroundColor(Color.GREEN)
        else if (mColor == "blue")
            view.setBackgroundColor(Color.BLUE)

        mColorTextView = view.findViewById(R.id.txt_color) as TextView

        btn_send = view.findViewById(R.id.btn_send)
        btn_send.setOnClickListener {
            callbacks?.onAddName("Maimoona Al-rozmi")
        }

        mColorTextView.setText(mColor)
        return view;
    }


}