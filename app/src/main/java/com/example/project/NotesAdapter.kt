package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.NotesItameBinding
import com.example.project.databinding.PicshersMainBinding

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.MusicViewHolder>() {
    private val onDeleteNoteClick:() ->


    val noteList = mutableListOf<NotesModel>()

    fun updateList(moviList: List<NotesModel>) {
        noteList.clear()
        noteList.addAll(moviList)
        notifyDataSetChanged()
    }

    inner class MusicViewHolder(
        private val binding: NotesItameBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notesModel: NotesModel) {
            binding.tvNoteTitle.text = notesModel.noteTitle
            binding.tvNoteOverview.text = notesModel.noteDescripition


        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicViewHolder {
        val binding = NotesItameBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.notes_itame,
                parent,
                false
            )
        )
        return MusicViewHolder(binding)

    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(
        holder: MusicViewHolder,
        position: Int
    ) {
        holder.bind(noteList[position])
    }

}
