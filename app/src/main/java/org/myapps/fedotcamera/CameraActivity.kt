package org.myapps.fedotcamera

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.fotoapparat.Fotoapparat
import kotlinx.android.synthetic.main.activity_camera.*

/**
 * Created by Gor on 21.06.2018.
 */
class CameraActivity: AppCompatActivity() {

    lateinit var fotoapparat: Fotoapparat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        fotoapparat = Fotoapparat(this, cameraView)
    }

    override fun onStart() {
        super.onStart()
        fotoapparat.start()

        for(i in 0..10) {
            val photoResult = fotoapparat.takePicture()
            photoResult
                    .toBitmap()
                    .whenAvailable { bitmapPhoto ->
                        Toast.makeText(this, "$bitmapPhoto", Toast.LENGTH_SHORT).show()
                    }
        }
    }

    override fun onStop() {
        super.onStop()
        fotoapparat.stop()
    }
}