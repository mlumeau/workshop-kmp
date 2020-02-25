package xyz.mlumeau.kosmos.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import xyz.mlumeau.kosmos.R
import xyz.mlumeau.kosmos.kore.model.APOD
import xyz.mlumeau.kosmos.kore.createApplicationScreenMessage
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCache
import xyz.mlumeau.kosmos.kore.data.APODRepositoryCacheImpl

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {

    private val apodRepository: APODRepositoryCache = APODRepositoryCacheImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAPOD()
    }

    private fun updateAPODData(apod: APOD) {
        runOnUiThread {
            title_tv.text = apod.title
            desc_tv.text = apod.explanation
            if (apod.media_type == "image" && !apod.url.isNullOrEmpty()) {
                Picasso.get().load(apod.url).fit().centerCrop().into(apod_iv)
            } else {
                apod_iv.visibility = View.GONE
            }
            progress.visibility = View.GONE
        }
    }

    private fun getAPOD() {
        apodRepository.getAPOD(
            this::updateAPODData,
            this::onAPODLoadingError
        )
    }

    private fun onAPODLoadingError() {
        // Handle the error
    }
}
