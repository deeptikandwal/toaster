package com.example.mykotlinapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mykotlinapp.databinding.FragmentMessageReceiverBinding
import com.example.mykotlinapp.viewmodel.SharedViewMOdel


class MessageReceiverFragment : Fragment() {

    private lateinit var sharedViewMOdel: SharedViewMOdel
    private lateinit var messageReceiverBinding: FragmentMessageReceiverBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        messageReceiverBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_message_receiver, container, false)
        messageReceiverBinding.lifecycleOwner=this
        retainInstance=true

        return messageReceiverBinding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //here use requireactivity
        sharedViewMOdel= ViewModelProviders.of(requireActivity()).get(SharedViewMOdel(application = activity!!.application)::class.java)
        messageReceiverBinding.shared = sharedViewMOdel

       sharedViewMOdel.message.observe(this, Observer {
           Log.d("here u are",it)
//           messageReceiverBinding.msg.text=it
       })
    }
    companion object {
        @JvmStatic
        fun newInstance() = MessageReceiverFragment()
    }
}