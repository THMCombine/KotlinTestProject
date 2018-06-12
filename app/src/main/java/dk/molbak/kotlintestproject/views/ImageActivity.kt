package dk.molbak.kotlintestproject.views

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dk.molbak.kotlintestproject.R
import kotlinx.android.synthetic.main.activity_image.*
import java.lang.Exception

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        supportPostponeEnterTransition()

        textView.setText(intent.getStringExtra(TRANSITION_TEXT))
        Picasso.get().load(intent.getStringExtra(TRANSITION_IMAGE)).into(topImageView, object : Picasso.Listener, Callback {
            override fun onSuccess() {
                this@ImageActivity.supportStartPostponedEnterTransition()
            }

            override fun onError(e: Exception?) {}

            override fun onImageLoadFailed(picasso: Picasso?, uri: Uri?, exception: Exception?) {}
        })
    }

    companion object {
        private val TRANSITION_IMAGE = "TRANSITION_IMAGE"
        private val TRANSITION_TEXT = "TRANSITION_TEXT"

        fun open(context: Context, imageUrl: String, text: String): Intent {
            val intent = Intent(context, ImageActivity::class.java)
            intent.putExtra(TRANSITION_IMAGE, imageUrl)
            intent.putExtra(TRANSITION_TEXT, text)
            return intent
        }
    }
}