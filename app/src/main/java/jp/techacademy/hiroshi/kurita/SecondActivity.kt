package jp.techacademy.hiroshi.kurita
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.hiroshi.kurita.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val value1 = intent.getIntExtra("VALUE1", 0)
        val value2 = intent.getIntExtra("VALUE2", 0)

        binding.textView.text = "${value1 + value2}"
    }
}
