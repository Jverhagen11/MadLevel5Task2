package com.example.madlevel5task2.Ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel5task2.Models.Game
import com.example.madlevel5task2.R
import com.example.madlevel5task2.Viewmodel.GameViewmodel
import com.example.madlevel5task2.databinding.FragmentGameBacklogBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_game_backlog.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameBacklogFragment : Fragment() {

    private val gameViewmodel: GameViewmodel by viewModels()
    private val games = arrayListOf<Game>()
    private val gameAdapter = Adapter(games)

    private lateinit var binding: FragmentGameBacklogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBacklogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        observeLiveData()

        activity?.setTitle("test")


//        binding.fab1.setOnClickListener {
//            startActivity(Intent(activity, AddGameFragment::class.java))
//        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete -> {
                gameViewmodel.deleteAllGames()
                gameAdapter.notifyDataSetChanged()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun observeLiveData() {
        gameViewmodel.gameLiveData.observe(
                viewLifecycleOwner
        ) { liveBacklogGames: List<Game> ->
            games.clear()
            games.addAll(liveBacklogGames)
            games.sortBy { it.date }
            gameAdapter.notifyDataSetChanged()
        }
    }

    private fun initRv() {
        binding.rvHistory.apply {
            adapter = gameAdapter
            layoutManager =  LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            rvHistory.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        createItemTouchHelper().attachToRecyclerView(binding.rvHistory)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object : ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT
        ) {

            override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val backlogGame = games[position]
                val undoSnackBar = Snackbar.make(
                        requireView(),
                        getString(R.string.removed_game),
                        Snackbar.LENGTH_SHORT
                ).setAction(getString(R.string.undo), fun(_: View) {
                    gameViewmodel.addBacklogGame(backlogGame)
                })

                gameViewmodel.deleteGame(backlogGame)

                undoSnackBar.show()
            }

        }

        return ItemTouchHelper(callback)
    }


}