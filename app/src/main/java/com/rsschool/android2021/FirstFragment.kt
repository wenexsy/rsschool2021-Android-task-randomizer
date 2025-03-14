package com.rsschool.android2021

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class FirstFragment : Fragment() {
    private var listener: onActionFirstFragment? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as onActionFirstFragment
    }

    private var generateButton: Button? = null
    private var previousResult: TextView? = null

    private lateinit var minValue: EditText
    private lateinit var maxValue: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        previousResult = view.findViewById(R.id.previous_result)
        generateButton = view.findViewById(R.id.generate)

        minValue = view.findViewById(R.id.min_value)
        maxValue = view.findViewById(R.id.max_value)

        val result = arguments?.getInt(PREVIOUS_RESULT_KEY)
        previousResult?.text = "Previous result: ${result.toString()}"

        var min: Int
        var max: Int

        generateButton?.setOnClickListener {
//            try {
            if (minValue.text.isNotEmpty() && maxValue.text.isNotEmpty()) {

                min = minValue.text.toString().toInt()
                max = maxValue.text.toString().toInt()

                if (min <= max) {
                    listener?.onActionPerformed(min, max)
                } else {
                    Toast.makeText(
                        activity, "Min > Max",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else{
                Toast.makeText(
                    activity, "Min or Max is null",
                    Toast.LENGTH_SHORT
                ).show()
            }
//            } catch (e: Exception) {
//                Toast.makeText(
//                    activity, "Error",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            }
        }


//                try {

//                    if (view.findViewById<EditText>(R.id.min_value).text.isNotEmpty()) {
//                        min = view.findViewById<EditText>(R.id.min_value).text.toString().toInt()
//                    }

//                min = if (view.findViewById<EditText>(R.id.min_value).text.isEmpty()) 0
//                else view.findViewById<EditText>(R.id.min_value).text.toString().toInt()
//                    max = if (view.findViewById<EditText>(R.id.max_value).text.isEmpty()) 0
//                    else view.findViewById<EditText>(R.id.max_value).text.toString().toInt()
//                    if (min <= max)
//                        listener?.onActionPerformed(min, max)
//                    else
//                        Toast.makeText(
//                            getActivity(), "Min > Max... ${maxInt < minInt}",
//                            Toast.LENGTH_SHORT
//                        ).show()
//
//                } catch (e: Exception) {
//                    Toast.makeText(getActivity(), "Int very long... ${maxInt}", Toast.LENGTH_LONG)
//                        .show()
//
//
//                }

//        }
    }

    companion object {

        @JvmStatic
        fun newInstance(previousResult: Int): FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt(PREVIOUS_RESULT_KEY, previousResult)
            fragment.arguments = args
            return fragment
        }

        private const val PREVIOUS_RESULT_KEY = "PREVIOUS_RESULT"
    }

    interface onActionFirstFragment {
        fun onActionPerformed(min: Int, max: Int)
    }
}

private operator fun Boolean.invoke(value: () -> Unit) {

}
/* val minValue: EditText = view.findViewById(R.id.min_value) as EditText
 val min = minValue.text
 val max = readLine()?.toIntOrNull()
 generateButton?.setOnClickListener {
     //send min and max to the SecondFragment*/
