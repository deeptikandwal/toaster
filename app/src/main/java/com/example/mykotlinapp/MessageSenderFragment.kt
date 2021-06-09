package com.example.mykotlinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mykotlinapp.databinding.FragmentMessageSender2Binding
import com.example.mykotlinapp.viewmodel.SharedViewMOdel


class MessageSenderFragment : Fragment() {

    private lateinit var sharedViewMOdel: SharedViewMOdel
    private lateinit var messageSender2Binding: FragmentMessageSender2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        messageSender2Binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_message_sender2, container, false)
        messageSender2Binding.lifecycleOwner = this
        retainInstance=true
        return messageSender2Binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewMOdel = ViewModelProviders.of(requireActivity())
            .get(SharedViewMOdel(application = activity!!.application)::class.java)
        messageSender2Binding.shared = sharedViewMOdel
        messageSender2Binding.btn.setOnClickListener {
            sharedViewMOdel.sendMessage("Hey baby!!!")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MessageSenderFragment()
    }
}