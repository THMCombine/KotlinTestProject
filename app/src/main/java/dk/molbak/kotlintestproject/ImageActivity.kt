package dk.molbak.kotlintestproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dk.molbak.kotlintestproject.MainActivity.Companion.EXTRA_MESSAGE
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val intent = intent
        val uri = intent.getStringExtra(EXTRA_MESSAGE)
        if (uri != null) {
            textView.text = "Message: " + uri.toString()
        }
    }
}