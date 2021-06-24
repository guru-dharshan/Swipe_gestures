package com.devgd.swipe_gestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var xStart=0.0f
    var xEnd=0.0f
    var yStart=0.0f
    var yEnd=0.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if (event != null) {
            if (event.action==MotionEvent.ACTION_DOWN){
                xStart= event?.x!!
                yStart= event?.y!!
            }
        }
        if (event != null) {
            if (event.action==MotionEvent.ACTION_UP){
                xEnd= event?.x!!
                yEnd= event?.y!!

                if(xStart<xEnd && xEnd-xStart>150){
                    Toast.makeText(applicationContext,"Swiped RIGHT!",Toast.LENGTH_SHORT).show()
                }
                if(xEnd<xStart && xStart-xEnd>150){
                    Toast.makeText(applicationContext,"Swiped LEFT!",Toast.LENGTH_SHORT).show()
                }
                if(yStart<yEnd && yEnd-yStart>150){
                    Toast.makeText(applicationContext,"Swiped DOWN!",Toast.LENGTH_SHORT).show()
                }
                if(yEnd<yStart && yStart-yEnd>150){
                    Toast.makeText(applicationContext,"Swiped UP!",Toast.LENGTH_SHORT).show()
                }
            }
        }
        return true
    }
}