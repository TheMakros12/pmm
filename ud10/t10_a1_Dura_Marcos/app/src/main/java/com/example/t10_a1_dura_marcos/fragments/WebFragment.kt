package com.example.t10_a1_dura_marcos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.t10_a1_dura_marcos.R
import com.example.t10_a1_dura_marcos.databinding.FragmentWebBinding

class WebFragment : Fragment() {

    private lateinit var binding: FragmentWebBinding

    companion object {
        private const val ARG_URL = "url"

        fun newInstance(url: String) = WebFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_URL, url)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val url = arguments?.getString(ARG_URL) ?: return

        binding.webView.loadUrl(url)
    }
}