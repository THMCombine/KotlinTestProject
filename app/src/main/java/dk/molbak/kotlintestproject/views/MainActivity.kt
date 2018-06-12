package dk.molbak.kotlintestproject.views

import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.squareup.picasso.Picasso
import dk.molbak.kotlintestproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://lh3.googleusercontent.com/VT-PqxMMsA2wPy7kzmuKGDIzaA3AGuXKExqnfOfwTEy5AvLIMTranbfNGheRr457RD4=s180"
        Picasso.get().load(url).into(topImageView)

        button.setText("Test")
        button.setOnClickListener { v ->
            val ext = " world"
            val text = textView.text.toString() + ext
            textView.setText(text)
        }

        button2.setText("Monkey")
        button2.setOnClickListener { v ->
            val pairImageView = Pair.create<View, String>(topImageView, "topImage")
            val pairTextView = Pair.create<View, String>(textView, "text")

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    this@MainActivity, pairImageView, pairTextView)

            startActivity(ImageActivity.open(this, url, textView.text.toString()), options.toBundle())
        }

        button3.setText("Next Page")
    }
}
