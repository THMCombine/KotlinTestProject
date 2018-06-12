package dk.molbak.kotlintestproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    final val EXTRA_MESSAGE = "EXTRA_MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setText("Test")
        button.setOnClickListener { v ->
            val ext = " world"
            val text = textView.text.toString() + ext
            textView.setText(text)
        }

        button2.setText("Monkey")
        button2.setOnClickListener { v ->
            val intent = Intent(this, ImageActivity::class.java)
            val message = textView.text

            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
        }

        button3.setText("Next Page")
    }

    companion object {
        final val EXTRA_MESSAGE = "EXTRA_MESSAGE"
    }
}
