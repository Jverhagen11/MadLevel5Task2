package com.example.madlevel5task2.Ui

import android.os.Bundle
import android.view.*
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import com.example.madlevel5task2.R
import com.example.madlevel5task2.databinding.FragmentAddGameBinding


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

//    // hides the delete button in the toolbar
//    override fun onPrepareOptionsMenu(menu: Menu) {
//        menu.findItem(R.id.delete).isVisible = false
//        super.onPrepareOptionsMenu(menu)
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {

            else -> super.onOptionsItemSelected(item)
        }
    }



}