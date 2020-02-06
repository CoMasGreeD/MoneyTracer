package com.vladshvyrev.moneytracer


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vladshvyrev.moneytracer.ui.fragments.AccountsFragment.AccountsFragment
import com.vladshvyrev.moneytracer.ui.fragments.CreateNewTransaction.CreateNewTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.EditTransactionFragment.EditTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfCategoryFragment.ListOfCategoryFragment
import com.vladshvyrev.moneytracer.ui.fragments.ListOfSavedTransactionFragment.ListOfSavedTransactionFragment
import com.vladshvyrev.moneytracer.ui.fragments.MainPage.MainPageFragment
import com.vladshvyrev.moneytracer.ui.fragments.PinCodeSqreen.PinCodeSqreenFragment


class MainActivity : AppCompatActivity() {

   // private var toolbar: Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        toolbar = findViewById(R.id.my_Toolbar)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, PinCodeSqreenFragment())
            .commit()


    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu)
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    fun startMainPageFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, MainPageFragment())
            //.addToBackStack(" tag")
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
        var selectedItem = ""
//        when(item?.itemId)
//        {
//           R.id.item_1 -> selectedItem= "1"
//            R.id.item_2 -> selectedItem= "2"
//            R.id.item_3 -> selectedItem= "3"
//
//        }
//        if(selectedItem == "1") {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container,ListOfCategoryFragment())
//                .addToBackStack("3")
//                .commit()
//        }
//        if(selectedItem == "2") {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container,AccountsFragment())
//                //.addToBackStack("4")
//                .commit()
//        }
//        if(selectedItem == "3") {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_container,ListOfSavedTransactionFragment())
//                //.addToBackStack("5")
//                .commit()
//        }


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


