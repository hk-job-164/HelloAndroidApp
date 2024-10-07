package jp.techacademy.hiroshi.kurita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sayHuman = Human("miyazaki", 151, "kyusyu")
        sayHuman.say()
        sayHuman.think()

        val thinkHuman = Human("tokyo", 81, "kantou")
        thinkHuman.say()
        thinkHuman.think()
    }
}