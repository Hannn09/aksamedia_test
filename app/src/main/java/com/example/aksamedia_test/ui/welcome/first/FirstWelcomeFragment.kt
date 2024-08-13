package com.example.aksamedia_test.ui.welcome.first

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aksamedia_test.R
import com.example.aksamedia_test.databinding.FragmentFirstWelcomeBinding
import com.example.aksamedia_test.ui.product.MainActivity

class FirstWelcomeFragment : Fragment() {

    private var _firstFragment: FragmentFirstWelcomeBinding? = null

    private val firstFragment get() = _firstFragment!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _firstFragment = FragmentFirstWelcomeBinding.inflate(inflater, container, false)
        return _firstFragment?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstFragment.txtSkip.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _firstFragment = null
    }
}