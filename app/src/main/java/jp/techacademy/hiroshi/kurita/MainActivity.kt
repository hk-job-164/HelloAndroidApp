package jp.techacademy.hiroshi.kurita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sayHuman = Human("miyazaki", 30, "kyusyu")
        sayHuman.say()

        val thinkHuman = Human("tokyo", 30, "kantou")
        thinkHuman.think()
    }
}