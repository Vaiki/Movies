package com.example.movie.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movie.R
import com.example.movie.databinding.FragmentDetailsBinding
import com.example.movie.presentation.adapters.ListActorsAdapter


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var actorListAdapter: ListActorsAdapter

    private var filmItemId = 0
    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailsBinding.bind(view)
        parseParams()
        setupActorsRecycler()
        setUI()


    }

    private fun setUI() {
        viewModel.filmItem.observe(viewLifecycleOwner) {
            with(binding) {
                tvDescription.text = it.description
                tvAdult.text = it.adult
                tvTitle.text = it.title
                tvGenre.text = it.genre.toString()
                ratingBar.rating = it.rating.toFloat()
            }
        }
        viewModel.listActorsLD.observe(viewLifecycleOwner) {
            actorListAdapter.submitList(it)
        }
    }


    private fun setupActorsRecycler() {
        actorListAdapter = ListActorsAdapter()
        binding.rvActors.adapter = actorListAdapter
    }

    private fun parseParams() {
        val arg = requireArguments()
        filmItemId = arg.getInt(FILM_ITEM_ID)
        viewModel.getFilmItem(filmItemId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val FILM_ITEM_ID = "extra_film_item_id"
        fun newInstance(filmItemId: Int): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(FILM_ITEM_ID, filmItemId)
                }
            }
        }
    }
}