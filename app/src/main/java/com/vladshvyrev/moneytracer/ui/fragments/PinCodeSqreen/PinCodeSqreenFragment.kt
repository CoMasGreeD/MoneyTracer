package com.vladshvyrev.moneytracer.ui.fragments.PinCodeSqreen

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.vladshvyrev.moneytracer.MainActivity
import com.vladshvyrev.moneytracer.R
import kotlinx.android.synthetic.main.fragment_pin_code.*
import kotlinx.android.synthetic.main.toolbar.*

class PinCodeSqreenFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pin_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item_button_for_replace.setOnClickListener{
            checkPinCode()
        }
    }


    private fun checkPinCode()
    {
        val inputText = item_insert_Pin_Code.text.toString()
        if(inputText == "1111")
        {
            (activity as MainActivity).startMainPageFragment()
        }
    }
}