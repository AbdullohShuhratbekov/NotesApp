package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter: NotesAdapter by lazy {
        NotesAdapter()
    }
    private val sharedPref: NotesDatabase by lazy {
        NotesDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewAndAdapter()
        setClickListener()
    }

    private fun setupViewAndAdapter() {
        val listOfNotes = sharedPref.getAllNote()
        if (listOfNotes.isNotEmpty()) {
            binding.noteEmptyImg.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
            adapter.updateList(listOfNotes)
            binding.recyclerView.adapter = adapter
        }
    }

    private fun setClickListener() {
        binding.addNio.setOnClickListener {
            startActivity(Intent(this@MainActivity, PicsherActivity::class.java))
        }

        binding.deleteCars.setOnClickListener {
            showDeleteNoteDiolog()

        }
    }

    private fun showDeleteNoteDiolog() {
        val alertDiolog = MaterialAlertDialogBuilder(this)
        alertDiolog.setMessage("Do you want to delete all Notes?")
        alertDiolog.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        alertDiolog.setPositiveButton("Yes") { dialog, _ ->
            deleteAllCar()
            dialog.dismiss()
        }
        alertDiolog.create().show()
    }



    private fun deleteAllCar(){
        sharedPref.deleteAllNotesCard()
        adapter.updateList((emptyList()))
        binding.noteEmptyImg.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }
    }