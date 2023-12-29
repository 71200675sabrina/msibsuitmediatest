package com.sabrina.msibsuitmedia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sabrina.msibsuitmedia.databinding.ActivityFirstBinding


class FirstActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       binding = ActivityFirstBinding.inflate(layoutInflater)
       setContentView(binding.root)

       setupAction()

    }
    private fun setupAction() {
        val palindrome = binding.inputPalindrome.text
        val name = binding.inputName.text

        binding.checkBtn.setOnClickListener {
            var isPalindrome = true
            if(palindrome.isEmpty()){
                binding.inputPalindrome.error ="Must be filled!"
                isPalindrome = false
            }

            val textLength = palindrome.length
            var i = 0
            while(i<textLength/2){
                i++
                if(palindrome[i] != palindrome[textLength-1-i]){
                    isPalindrome = false
                    break
                }
            }
            if(isPalindrome){
                Toast.makeText(this, "Palindrome", Toast.LENGTH_SHORT).show()
            }else if(!isPalindrome && palindrome.isNotEmpty()) {
                Toast.makeText(this, "Not Palindrome", Toast.LENGTH_SHORT).show()
            }
        }

        binding.nextBtn.setOnClickListener {
            val moveToSecond = Intent(this, SecondActivity::class.java)
            moveToSecond.putExtra(SecondActivity.EXTRA_NAME,name.toString())
            if(name.isEmpty()){
                binding.inputName.error = "Must be filled!"
            }else startActivity(moveToSecond)
        }
    }
    companion object {
        private var TAG = "MainActivity"
    }
}