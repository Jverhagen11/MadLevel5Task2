package com.example.madlevel5task2.Ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import com.example.madlevel5task2.Models.Game
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.FragmentAddGameBinding
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDate


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {

    private lateinit var binding: FragmentAddGameBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddGameBinding.inflate(inflater, container, false)
        return binding.root

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fabAddGame.setOnClickListener {
            addBacklogGameFormSubmit()
        }

    }

//    // hides the delete button in the toolbar
//    override fun onPrepareOptionsMenu(menu: Menu) {
//        menu.findItem(R.id.delete).isVisible = false
//        super.onPrepareOptionsMenu(menu)
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun addBacklogGameFormSubmit() {

        val title = binding.etTitle.text.toString()
        val platform = binding.etPlatform.text.toString()
        val day = binding.etDay.text.toString().toInt()
        val month = binding.etMonth.text.toString().toInt()
        val year = binding.etYear.text.toString().toInt()

        if (title.isEmpty()) {
            Snackbar.make(requireView(), "Enter a title", Snackbar.LENGTH_SHORT).show()
            return
        }

        if (platform.isEmpty()) {
            Snackbar.make(requireView(), "Enter a platform", Snackbar.LENGTH_SHORT).show()
            return
        }


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