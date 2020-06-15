package com.example.sadaqatpanhwer.residedemo

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.WindowManager

import com.special.ResideMenu.ResideMenu
import com.special.ResideMenu.ResideMenuItem

class resideDemo : AppCompatActivity(), View.OnClickListener {
    // What good method is to access resideMenu？
    var resideMenu: ResideMenu? = null
        private set
    private var mContext: Context? = null
    private var itemCalendar: ResideMenuItem? = null
    private var itemSettings: ResideMenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_reside_demo)
        mContext = this
        setUpMenu()

    }

    private fun setUpMenu() {

        // attach to current activity;
        resideMenu = ResideMenu(this)

        resideMenu!!.setBackground(R.color.colorPrimary)
        resideMenu!!.attachToActivity(this)
        //    resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu!!.setScaleValue(0.6f)

        // create menu items;

        itemCalendar = ResideMenuItem(this, R.drawable.i, "sample")
        itemSettings = ResideMenuItem(this, R.drawable.h, "sample")


        itemCalendar!!.setOnClickListener(this)
        itemSettings!!.setOnClickListener(this)


        resideMenu!!.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT)
        resideMenu!!.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT)

        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_LEFT);


        //        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View view) {
        //                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
        //            }
        //        });
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return resideMenu!!.dispatchTouchEvent(ev)
    }

    override fun onClick(view: View) {


        if (view === itemCalendar) {
            changeFragment(demo_one())
        } else if (view === itemSettings) {
            changeFragment(demo_two())
        }

        resideMenu!!.closeMenu()
    }


    private fun changeFragment(targetFragment: Fragment) {
        resideMenu!!.clearIgnoredViewList()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }
}

