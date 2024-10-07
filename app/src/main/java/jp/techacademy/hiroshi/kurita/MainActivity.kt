package jp.techacademy.hiroshi.kurita

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import jp.techacademy.hiroshi.kurita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater) // 追加
        val view = binding.root // 追加
        setContentView(view) // 変更

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button.setOnClickListener(this)

        // Map<String, String> 型のArrayListを作成します
        val list = ArrayList<Map<String, String>>()

        for (i in 0..10) {
            val map = HashMap<String, String>()
            map["main"] = "メイン $i"
            map["sub"] = "サブ $i"
            list.add(map)
        }

        val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_list_item_2,
            arrayOf("main", "sub"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            Log.d("UI_PARTS", "クリック $position")
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> binding.textView.text = binding.editText.text.toString()
            R.id.button2 -> showAlertDialog()
            R.id.button3 -> showTimePickerDialog()
            R.id.button4 -> showDatePickerDialog()
            R.id.button -> {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("VALUE1", 10)
                intent.putExtra("VALUE2", 20)
                startActivity(intent)
            }
        }
    }

    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("メッセージ")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("肯定"){ _, _ ->
            Log.d("UI_PARTS", "肯定ボタン")
        }

        // 中立ボタンに表示される文字列、押したときのリスナーを設定する
        // 使わない引数の場合は「_」と記述するのがkotlinの慣習
        alertDialogBuilder.setNeutralButton("中立"){_,_ ->
            Log.d("UI_PARTS", "中立ボタン")
        }

        // 否定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setNegativeButton("否定"){_,_ ->
            Log.d("UI_PARTS", "否定ボタン")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
            },
            13, 0, true)
        timePickerDialog.show()
    }

    private fun showDatePickerDialog() {
        Log.d("TEST", "button4")

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                Log.d("UI_PARTS", "$year/${month + 1}/$dayOfMonth")
            },
            2023,
            0,
            15
        )
        datePickerDialog.show()
    }
}