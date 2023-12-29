package com.sabrina.msibsuitmedia

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.sabrina.msibsuitmedia.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = activity2

        val username = intent.getStringExtra(EXTRA_NAME)
        binding.usernameTv.text = username

        setupAction()
    }
    private fun setupAction() {
        var selectedUserName = binding.selectedTv.isVisible
        binding.btnChooseUser.setOnClickListener {
            val moveToThird = Intent(this,ThirdActivity::class.java)
            if (!selectedUserName){
                startActivity(moveToThird)
            }else {
                Toast.makeText(this, "Must click name!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.usernameTv.setOnClickListener {
            binding.selectedTv.visibility = View.VISIBLE
            binding.selectedTv.text = SELECTED
            binding.usernameTv.setTextColor(ContextCompat.getColor(this, R.color.teal_700))
            selectedUserName = false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val SELECTED = "Selected User Name"
        private var activity2 = "Second Screen"
    }
}