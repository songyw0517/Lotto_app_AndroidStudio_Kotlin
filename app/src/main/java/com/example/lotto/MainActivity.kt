package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.lotto.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lotteryNumbers = arrayListOf(binding.number1, binding.number2, binding.number3, binding.number4, binding.number5, binding.number6)

        // 3초동안 기능을 1초마다 수행
        val countDownTimer = object: CountDownTimer(3000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                lotteryNumbers.forEach{
                    val randomNumber = (Math.random() * 45 + 1).toInt() // 1~45 사이의 수
                    it.text = "$randomNumber"
                }
            }

            override fun onFinish() {
            }
        }

        binding.lotteryButton.setOnClickListener{
            if (binding.lotteryButton.isAnimating){ // 애니메이션 중이면
                binding.lotteryButton.cancelAnimation()
                countDownTimer.cancel()
            }else{
                binding.lotteryButton.playAnimation()
                countDownTimer.start()
            }

        }
    }
}