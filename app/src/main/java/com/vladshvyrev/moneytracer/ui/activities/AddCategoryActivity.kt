package com.vladshvyrev.moneytracer.ui.activities

import android.app.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vladshvyrev.moneytracer.R
import com.vladshvyrev.moneytracer.ui.fragments.PinCodeSqreen.PinCodeSqreenFragment
import kotlinx.android.synthetic.main.fragment_add_category.*

class AddCategoryActivity: AppCompatActivity() {
    companion object {
        const val EXTRA_TITLE = "com.vladshvyrev.moneytracer.ui.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "com.vladshvyrev.moneytracer.ui.EXTRA_DESCRIPTION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_category)
        butAdd.setOnClickListener{
            saveNote()
        }
    }


    private fun saveNote() {
        if (add_name_category.text.toString().trim().isBlank() || inc_or_spend.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_TITLE, add_name_category.text.toString())
            putExtra(EXTRA_DESCRIPTION, inc_or_spend.text.toString())
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}