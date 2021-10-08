package com.myapp.graph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class uiFragment:Fragment(R.layout.ui_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val someInt = requireArguments().getInt("some_int")
        

    }
}