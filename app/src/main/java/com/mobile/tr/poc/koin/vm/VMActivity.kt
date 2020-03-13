package com.mobile.tr.poc.koin.vm

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.mobile.tr.poc.koin.R
import com.mobile.tr.poc.koin.vm.ui.vm.VmViewModel
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class VMActivity : AppCompatActivity() {

    private lateinit var viewModel: VmViewModel
    lateinit var navController : NavController
    private val sharePreferenceEdit : SharedPreferences.Editor by inject()
    private val sharePreference : SharedPreferences by inject(named("settingsPrefs"))

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

        val editor = sharePreferenceEdit.apply() {
            putString("name","tony")
        }.commit()

        Log.e("xxxxx",sharePreference.getString("name","vxcvxcvxcv").toString())

    }

}
