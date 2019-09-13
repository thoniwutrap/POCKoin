package com.mobile.tr.poc.koin.ui.pincode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobile.tr.poc.koin.databinding.PincodeListItemBinding

class PinCodeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var pinCodeList : MutableList<PinCodeModel> = mutableListOf()

    fun updatePinCode(pinCodeListUpdate: MutableList<PinCodeModel>) {
        pinCodeList = pinCodeListUpdate
        notifyItemRangeChanged(0,pinCodeList.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val applicationBinding = PincodeListItemBinding.inflate(layoutInflater, parent, false)
        return RecyclerHolderCatIcon(applicationBinding)
    }

    override fun getItemCount(): Int  {
        return pinCodeList.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val appInfo = pinCodeList[position]
        (holder as RecyclerHolderCatIcon).bind(appInfo)
    }

    inner class RecyclerHolderCatIcon(private var pinBinding: PincodeListItemBinding) : RecyclerView.ViewHolder(pinBinding.root) {

        fun bind(appInfo: PinCodeModel) {
            pinBinding.viewmodel  = appInfo
        }
    }
}