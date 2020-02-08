package com.vladshvyrev.moneytracer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction.CreateNewTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.MainPage.MainPageFragment
import com.vladshvyrev.moneytracer.ui.fragments.PinCodeSqreen.PinCodeSqreenFragment
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, PinCodeSqreenFragment())
            .commit()
    }


    fun startMainPageFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MainPageFragment())
            .commit()
    }

    fun startFragmentForAddTransaction() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, CreateNewTransactionFragment())
            .addToBackStack("2")
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,
                when(item?.itemId){
                R.id.item_1 -> ListOfCategoryFragment()
                    R.id.item_2 -> AccountsFragment()
                    R.id.item_3 -> ListOfSavedTransactionFragment()
                    else -> return super.onOptionsItemSelected(item)
            })
            .addToBackStack(" ")
            .commit()
        return true
    }
}


