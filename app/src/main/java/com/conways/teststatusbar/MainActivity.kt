package com.conways.teststatusbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.conways.statusbar.StatusBar
import com.conways.statusbar.StatusBarHelper
import com.conways.statusbar.StatusBarType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarHelper.Transparent(this, StatusBarType.Normal, -0x1000000)
        StatusBar(this)
            .apply {
                type = StatusBarType.Normal
                isDarkModel=true
            }
            .commit()
    }
}
