package com.example.mykotlinapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mykotlinapp.R
import com.example.mykotlinapp.databinding.FragmentMainBinding

class MainFragment : Fragment(), View.OnClickListener {
    lateinit var fragmentMainBinding: FragmentMainBinding
    private var navController: NavController? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return fragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        fragmentMainBinding.sendMoneyBtn.setOnClickListener(this)
        fragmentMainBinding.viewBalanceBtn.setOnClickListener(this)
        fragmentMainBinding.viewTransactionsBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.send_money_btn-> navController!!.navigate(R.id.action_mainFragment_to_chooseRecepientFragment)
            R.id.view_transactions_btn-> navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
            R.id.viewBalanceFragment-> navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)


        }

    }


}