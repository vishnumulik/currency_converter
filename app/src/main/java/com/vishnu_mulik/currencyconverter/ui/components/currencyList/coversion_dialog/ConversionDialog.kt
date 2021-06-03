package com.vishnu_mulik.currencyconverter.ui.components.currencyList.coversion_dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vishnu_mulik.currencyconverter.data.EXCHANGE_RATE
import com.vishnu_mulik.currencyconverter.databinding.ConversionDialogFragmentBinding
import com.vishnu_mulik.currencyconverter.utils.afterTextChanged

class ConversionDialog : BottomSheetDialogFragment() {
    companion object {
        fun newInstance(rate : Double): ConversionDialog {
            val dialog = ConversionDialog ()
            val args = Bundle()
            args.putDouble(EXCHANGE_RATE, rate)
            dialog.setArguments(args)
            return dialog
        }
    }

    private var _binding: ConversionDialogFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ConversionDialogFragmentBinding.inflate(inflater, container, false)
        binding.etAmount.afterTextChanged {
            val amountToBeConverted = it.toInt()
            arguments?.getDouble(EXCHANGE_RATE, 1.0)?.let{ rate ->
                val value = it +" is " + amountToBeConverted * rate
                binding.calulationAmount.text = value
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}