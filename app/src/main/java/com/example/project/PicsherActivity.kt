package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.databinding.PicshersMainBinding
import com.google.android.material.snackbar.Snackbar

class PicsherActivity : AppCompatActivity() {
    private val binding:PicshersMainBinding by  lazy {
        PicshersMainBinding .inflate(layoutInflater)
    }
    private val sharedPref:NotesDatabase by  lazy {
        NotesDatabase(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.saveCard.setOnClickListener {
            saveNotes()
        }
    }
    private fun saveNotes() = binding.apply {
        if (titleEditText.text?.isNotEmpty() == true && typeSome.text?.isNotEmpty() == true) {
            sharedPref.saveNote(
                NotesModel
                (noteTitle = titleEditText.text.toString(),
                noteDescripition = typeSome.text.toString()
                )
            )
            startActivity(Intent(this@PicsherActivity,MainActivity::class.java))
        }else showToastMessage("Заполните все поля")
    }
    private fun showToastMessage(message: String) {
        Snackbar.make(
            binding.root,
            message,
            Snackbar.LENGTH_SHORT
        ).show()
    }
}