package com.vladshvyrev.moneytracer



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction.CreateNewTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.MainPage.MainPageFragment
import com.vladshvyrev.moneytracer.ui.fragments.PinCodeSqreen.PinCodeSqreenFragment


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

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onResume() {
        super.onResume()
    }
    override fun onPause() {
        super.onPause()
    }
    override fun onStart() {
        super.onStart()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}


