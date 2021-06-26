package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.lotto.databinding.ActivityMainBinding
import com.example.lotto.databinding.ActivitySplashBinding

private lateinit var binding: ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Splish View가 띄어지고 3초후 사라지게 함
        /*
        * postDelayed(기능, 딜레이 시간) : 기능을 수행하는데, 딜레이 시간이 지나면 자동으로 기능을 수행하게 함
        *
        * */
        handler.postDelayed(runnable, 3000)

        // Splish View를 클릭했을 때
        binding.animationView.setOnClickListener{
            handler.removeCallbacks(runnable) // 만약 위의 postDelayed에서 runnable 기능이 실행이 되면, 콜백함수를 이용하여 기능을 하지 않도록 한다.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 뒤로가기 버튼을 누르면, splish View가 안 나오게 함
        }
    }
}