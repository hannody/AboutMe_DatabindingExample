package com.abunayla.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.abunayla.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Mohanad")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = this.myName

        binding.btnConfirm.setOnClickListener {
            addNickName(it)
        }

    }


    private fun addNickName(view: View) {
        binding.apply {
            myName?.nickname = etNickName.text.toString()
            invalidateAll()
            etNickName.visibility = View.GONE
            btnConfirm.visibility = View.GONE
            tvNickname.visibility = View.VISIBLE
        }

        // Hide the KB
        val imm = (getSystemService(Context.INPUT_METHOD_SERVICE)
                as InputMethodManager).apply {
            hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}