package com.hmtalk.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.hmtalk.viewmodeldemo.R
import com.hmtalk.viewmodeldemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        /*return inflater.inflate(R.layout.main_fragment, container, false)*/
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    } // onCreateView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModelProvider: ViewModelProvider = ViewModelProvider(this)
        viewModel = viewModelProvider.get(MainViewModel::class.java)

        // binding.resultText.text = viewModel.getResult().toString()

        val resultObserver: Observer<Float> = Observer<Float> { result ->
            binding.resultText.text = result.toString()
        }
        val liveData: MutableLiveData<Float> = viewModel.getResult()
        liveData.observe(viewLifecycleOwner, resultObserver)

        binding.convertButton.setOnClickListener {
            if (binding.dollarText.text.isNotEmpty()) {
                viewModel.setAmount(binding.dollarText.text.toString())
                // binding.resultText.text = viewModel.getResult().toString()
            } else {
                binding.resultText.text = "No Value"
            }
        }
    } // onActivityCreated

}
