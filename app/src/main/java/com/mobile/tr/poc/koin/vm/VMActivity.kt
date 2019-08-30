package com.mobile.tr.poc.koin.vm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.vm.ui.vm.VmViewModel

class VMActivity : AppCompatActivity() {

    private lateinit var viewModel: VmViewModel
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vm_activity)
        viewModel = ViewModelProviders.of(this).get(VmViewModel::class.java)
        if(savedInstanceState == null) {
            val host = NavHostFragment.create(R.navigation.vmnavigation)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, host)
                .setPrimaryNavigationFragment(host)
                .commit()
        }
    }

}
