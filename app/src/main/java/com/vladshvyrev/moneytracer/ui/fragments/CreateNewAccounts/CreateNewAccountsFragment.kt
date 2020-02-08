package com.vladshvyrev.moneytracer.ui.fragments.CreateNewAccounts

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.vladshvyrev.moneytracer.R

class CreateNewAccountsFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        return builder
            .setTitle("Add Accounts")
            .setView(R.layout.fragment_add_category)
            .setPositiveButton("Add",null)
            .setNegativeButton("Cancel",null)
            .create()
    }
}