package jp.techacademy.hiroshi.kurita

import android.util.Log


class Human(name: String, age: Int, private val hobby: String) : Animal(name, age), Thinkable {
    override fun say() {
        Log.d("kotlintest", "私の名前は" + name + "です。年は" + age.toString() + "歳です。")
    }

    override fun think() {
        Log.d("kotlintest", "私は" + hobby + "について考える。")
    }
}