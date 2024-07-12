package com.example.homeworkapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.homeworkapplication.R
import com.example.homeworkapplication.Viewmodel.SeeViewModel
import com.example.homeworkapplication.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel: SeeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        viewModel.getstringtochange().observe(viewLifecycleOwner, Observer { incomingvalue /*this is the actual thing which helps in observing the data*/ ->
            // Update the list UI.
            binding.textviewSecond.text="See "+incomingvalue//now this will help in observing the data
        })


        binding.imagebtn.setOnClickListener {
            binding.textviewSecond.text="Avengers Infinity War"
            Glide
                .with(view.context)
                .load("https://image.tmdb.org/t/p/original/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg")
                .centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .into(binding.imageView);
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}