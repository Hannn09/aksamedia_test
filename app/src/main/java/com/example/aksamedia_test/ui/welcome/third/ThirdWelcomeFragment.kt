package com.example.aksamedia_test.ui.welcome.third

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aksamedia_test.R
import com.example.aksamedia_test.databinding.FragmentThirdWelcomeBinding
import com.example.aksamedia_test.ui.product.MainActivity


class ThirdWelcomeFragment : Fragment() {

    private var _thirdFragment: FragmentThirdWelcomeBinding? = null

    private val thirdFragment get() = _thirdFragment!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _thirdFragment = FragmentThirdWelcomeBinding.inflate(inflater, container, false)
        return _thirdFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        thirdFragment.txtSkip.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _thirdFragment = null
    }

}