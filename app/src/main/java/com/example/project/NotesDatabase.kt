package com.example.project

import android.content.Context
import android.content.SharedPreferences
import android.widget.ShareActionProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

private const val SHERAD_PREFERENCES_KEY = "SHERAD_PREFERENCES_KEY"
private const val NOTES_SHARED_PRIF = "NOTES_SHARED_PRIF"
class NotesDatabase (
    private val context:Context,
){
    private val sheradPreferencas = context.getSharedPreferences(
        SHERAD_PREFERENCES_KEY,Context.MODE_PRIVATE
    )

    fun getAllNote():List<NotesModel> {
        val gson = Gson()
        val json = sheradPreferencas.getString(NOTES_SHARED_PRIF, null)
        val type = object : TypeToken<ArrayList<NotesModel?>?>() {}.type
        val noteList = gson.fromJson<List<NotesModel>>(json, type)
        return noteList ?: emptyList()
    }

        fun saveNote(notesModel: NotesModel){
            val notes = getAllNote().toMutableList()
            notes.add(0,notesModel)
            val notesGson = Gson().toJson(notes)
            sheradPreferencas
                .edit()
                .putString(NOTES_SHARED_PRIF,notesGson)
                .apply()
        }

    fun deleteAllNotesCard() = sheradPreferencas.edit().clear().apply()




}

