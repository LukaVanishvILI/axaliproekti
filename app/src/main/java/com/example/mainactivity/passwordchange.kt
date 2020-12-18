package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class passwordchange : AppCompatActivity() {

    private lateinit var inputPassword:EditText
    private lateinit var submitPassword:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passwordchange)

        inputPassword=findViewById(R.id.newPasswordEditText)
        submitPassword=findViewById(R.id.SubmitButton)

        submitPassword.setOnClickListener {
            val newPassword=inputPassword.text.toString()
            if (newPassword.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener {task->
                    if (task.isSuccessful) {
                        startActivity(Intent(this,PersonActivity::class.java))
                        finish()
                    } else {
                }

            }
        }




    }
}