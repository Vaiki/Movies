package com.example.movie

import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.movie.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {


    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var filmRVAdapter: RVAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
    }




    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}