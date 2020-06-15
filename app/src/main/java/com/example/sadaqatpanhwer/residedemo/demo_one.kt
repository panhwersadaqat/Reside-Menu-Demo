package com.example.sadaqatpanhwer.residedemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.special.ResideMenu.ResideMenu

class demo_one : Fragment() {
    private var parentView: View? = null
    private val resideMenu: ResideMenu? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parentView = inflater.inflate(R.layout.demo_one, container, false)

        return parentView
    }
}
