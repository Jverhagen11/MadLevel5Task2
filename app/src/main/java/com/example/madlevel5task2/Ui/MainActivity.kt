package com.example.madlevel5task2.Ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var activeMenu = R.menu.menu_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = findNavController(R.id.nav_host_fragment)

        fab1.setOnClickListener {
            navController.navigate(
                R.id.action_gameBacklogFragment_to_addGameFragment
            )
        }

        fabToggler()
    }

    private fun fabToggler() {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.addGameFragment)) {
                fab1.hide()
                //back arrow button to navigate back to backlog
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(false)
                binding.toolbar.setNavigationOnClickListener {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }

            } else {

            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {


            else -> super.onOptionsItemSelected(item)
        }
    }
}