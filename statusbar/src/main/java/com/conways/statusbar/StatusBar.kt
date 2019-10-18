package com.conways.statusbar

import android.app.Activity
import android.graphics.Color
import java.security.AccessControlContext

/**
 *@author Zong
 *Created on 2019/10/18
 *Describe:
 */
class StatusBar(context: Activity) {

    private var context = context;

    var isDarkModel = false

    var type = StatusBarType.Normal;

    var color = Color.TRANSPARENT;


    fun commit() {
        StatusBarHelper.Transparent(context, type, color);
        if (isDarkModel) {
            StatusBarHelper.SetTextStyleDark(context)
        }
    }


}