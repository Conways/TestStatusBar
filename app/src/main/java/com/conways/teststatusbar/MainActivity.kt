package com.conways.teststatusbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.conways.statusbar.StatusBarHelper
import com.conways.statusbar.StatusBarType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarHelper.SetTextStyle(this)
        StatusBarHelper.Transparent(this, StatusBarType.Normal, ContextCompat.getColor(this, R.color.colorAccent))
    }
}
