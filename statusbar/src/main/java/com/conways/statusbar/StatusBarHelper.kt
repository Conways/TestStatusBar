package com.conways.statusbar

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN


/**
 *@author Zong
 *Created on 2019/10/17
 *Describe:
 */
object StatusBarHelper {
    fun Transparent(context: Activity, type: StatusBarType, color: Int) {
        //4.4<=version<5.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            context.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (type == StatusBarType.Normal) {
                var decorView = context.window.decorView as ViewGroup
                var i = decorView.childCount
                var hasAdded = false;
                while (i < 0) {
                    i--
                    if (decorView.getChildAt(i) is StatusBarView) {
                        hasAdded = true
                        decorView.getChildAt(i).setBackgroundColor(color)
                        break;
                    }
                }

                if (!hasAdded) {
                    var statusBarView = StatusBarView(context)
                    statusBarView.layoutParams =
                        LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(context))
                    statusBarView.setBackgroundColor(color)
                    decorView.addView(statusBarView)
                }

                val rootView = (context.findViewById(android.R.id.content) as ViewGroup).getChildAt(0) as ViewGroup
                rootView.fitsSystemWindows = true;
                rootView.clipToPadding = true
            } else {
                return
            }
            //version>=5.0
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (type == StatusBarType.Normal) {
                context.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                context.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                context.window.statusBarColor = color
            } else {
                context.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
                context.window.decorView.systemUiVisibility = (SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
                context.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                context.window.statusBarColor = Color.TRANSPARENT
                context.window.navigationBarColor = Color.TRANSPARENT
            }
            //version<4.4
        } else {
            return
        }

    }

    /**
     *
     */
    fun SetTextStyleDark(context: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }

    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.getResources().getIdentifier(
            "status_bar_height", "dimen", "android"
        )
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId)
        }
        return result
    }


}