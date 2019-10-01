package xyz.mlumeau.kosmos.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import xyz.mlumeau.kosmos.R
import xyz.mlumeau.kosmos.kore.APOD
import xyz.mlumeau.kosmos.kore.createApplicationScreenMessage
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemote
import xyz.mlumeau.kosmos.kore.data.APODRepositoryRemoteImpl

class MainActivity : AppCompatActivity() {

    private val apodRepository: APODRepositoryRemote = APODRepositoryRemoteImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title_tv.text = createApplicationScreenMessage()

        getAPOD()
    }

    private fun updateAPODData(apod: APOD) {
        title_tv.text = apod.title
        desc_tv.text = apod.explanation
        if (apod.media_type == "image" && !apod.url.isNullOrEmpty()) {
            Picasso.get().load(apod.url).fit().centerCrop().into(apod_iv)
        } else {
            apod_iv.visibility = View.GONE
        }
        progress.visibility = View.GONE
    }

    private fun getAPOD() {
        GlobalScope.launch {
            apodRepository.getAPOD()?.let { apod ->
                withContext(Dispatchers.Main) {
                    updateAPODData(apod)
                }
            }
        }
    }
}
