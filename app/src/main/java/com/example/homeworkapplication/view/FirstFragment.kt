package com.example.homeworkapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.homeworkapplication.R
import com.example.homeworkapplication.Viewmodel.SeeViewModel
import com.example.homeworkapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: SeeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.texttomanipulate.setOnClickListener{
            viewModel.updateString()
        }

        viewModel.getstringtochange().observe(viewLifecycleOwner, Observer { incomingvalue /*this is the actual thing which helps in observing the data*/ ->
            // Update the list UI.
            binding.textviewFirst.text="See "+incomingvalue//now this will help in observing the data
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}