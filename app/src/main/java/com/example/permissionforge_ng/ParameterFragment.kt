package com.example.permissionforge_ng

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.permissionforge_ng.databinding.FragmentParameterBinding
import com.example.permissionforge_ng.viewModel.ApplicantViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ParameterFragment : Fragment() {

    private val applicantViewModel: ApplicantViewModel by activityViewModels()

    private var _binding: FragmentParameterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentParameterBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = applicantViewModel

        }

        binding?.buttonFirst?.setOnClickListener {
            saveParameterToViewModel()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveParameterToViewModel(){
        applicantViewModel.setApplicant(
            binding.applicantNameInput.getText().toString() ,
            binding.counselorNameInput.getText().toString() ,
            if(binding.timeInput.getText()?.toString().equals(""))
                3
            else
                binding.timeInput.getText().toString().toInt(),
            binding.schoolInput.getText().toString() ,
            binding.reasonInput.getText().toString() ,
            binding.dstInput.getText().toString()
        )
    }
}