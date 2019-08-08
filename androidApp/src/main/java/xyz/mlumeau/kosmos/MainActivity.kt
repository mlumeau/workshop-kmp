package xyz.mlumeau.kosmos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Job
import xyz.mlumeau.kosmos.kore.NasaAPIRemote
import xyz.mlumeau.kosmos.kore.createApplicationScreenMessage
import xyz.mlumeau.kosmos.kore.service.nasa.NasaApi

class MainActivity : AppCompatActivity() {

    private var job: Job? = null
    private val nasaAPI: NasaApi = NasaAPIRemote()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title_tv.text = createApplicationScreenMessage()

        job = nasaAPI.getAPOD{ apod ->
            runOnUiThread {
                if(apod.media_type == "image" && !apod.url.isNullOrEmpty()) {
                    Picasso.get().load(apod.url).fit().centerCrop().into(apod_iv)
                    title_tv.text = apod.title
                    desc_tv.text = apod.explanation
                }else{
                    title_tv.text = "Sorry, no picture today :("
                }
                progress.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job?.cancel()
    }
}
