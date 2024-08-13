package com.example.aksamedia_test.ui.welcome.second

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aksamedia_test.R
import com.example.aksamedia_test.databinding.FragmentSecondWelcomeBinding
import com.example.aksamedia_test.ui.product.MainActivity


class SecondWelcomeFragment : Fragment() {

    private var _secondFragment: FragmentSecondWelcomeBinding? = null

    private val secondFragment get() = _secondFragment!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _secondFragment = FragmentSecondWelcomeBinding.inflate(inflater, container, false)
        return _secondFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondFragment.txtSkip.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _secondFragment = null
    }
}