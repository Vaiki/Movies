package com.example.movie.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movie.R
import com.example.movie.databinding.FragmentMainBinding
import com.example.movie.domain.models.api_models.details.Genre
import com.example.movie.presentation.adapters.ListFilmAdapter
import com.example.movie.presentation.adapters.ListGenreAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var filmAdapter: ListFilmAdapter
    private lateinit var genreAdapter: ListGenreAdapter
    private val viewModel: MainViewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        setupFilmRecyclerView()
        setupGenreRecyclerView()
        viewModel.listGenre.observe(viewLifecycleOwner) {
            Log.d("LISTGENRE", it.toString())
            genreAdapter.differ.submitList(it)
        }
        viewModel.listFilms.observe(viewLifecycleOwner) {
            filmAdapter.submitList(it)
        }

    }

    private fun setupFilmRecyclerView() {
        filmAdapter = ListFilmAdapter()
        binding.rvFilms.layoutManager = GridLayoutManager(activity, 2)
        binding.rvFilms.adapter = filmAdapter
        setupClickListenerFilm()
    }

    private fun setupClickListenerFilm() {
        filmAdapter.onItemFilmClickListener = {
            Log.d("FILM", it.toString())
            launchDetailsFragment(it.id)
        }
    }

    private fun setupGenreRecyclerView() {
        genreAdapter = ListGenreAdapter()
        binding.rvGenres.adapter = genreAdapter
        genreAdapter.onItemGenreClickListener = {
            it.isChecked = !it.isChecked
            viewModel.editGenreList(it)
            Log.d("GENRE", it.toString())
        }
    }

    private fun launchDetailsFragment(idFilm: Int) {
        requireActivity().supportFragmentManager.popBackStack()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fv_container, DetailsFragment.newInstance(idFilm))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}