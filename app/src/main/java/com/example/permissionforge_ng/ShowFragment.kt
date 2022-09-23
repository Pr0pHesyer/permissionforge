package com.example.permissionforge_ng

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.activityViewModels
import com.example.permissionforge_ng.databinding.FragmentShowBinding
import com.example.permissionforge_ng.viewModel.ApplicantViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ShowFragment : Fragment() {

    private var _binding: FragmentShowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val applicantViewModel: ApplicantViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShowBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = applicantViewModel
            showFragment = this@ShowFragment
        }

        binding.txtTop.text = HtmlCompat.fromHtml(
            String.format(
                getString(R.string.txt_top),
                applicantViewModel.startTimeStr,
                applicantViewModel.endTimeStr,
                applicantViewModel.time),
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        binding.txtMid.text = HtmlCompat.fromHtml(
            String.format(
                getString(R.string.txt_mid),
                applicantViewModel.startTimeStr,
                applicantViewModel.endTimeStr,
                applicantViewModel.tel,
                applicantViewModel.reason,
                applicantViewModel.school,
                applicantViewModel.dst,
                applicantViewModel.home),

            HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.txtInitiate.text = HtmlCompat.fromHtml(
            String.format(
                getString(R.string.txt_initiate),
                applicantViewModel.applicantName),

            HtmlCompat.FROM_HTML_MODE_LEGACY)

        binding.txtPassed.text = HtmlCompat.fromHtml(
            String.format(
                getString(R.string.txt_passed),
                applicantViewModel.counselorName),

            HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}