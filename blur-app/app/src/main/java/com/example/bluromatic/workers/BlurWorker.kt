package com.example.bluromatic.workers

import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import com.example.bluromatic.DELAY_TIME_MILLIS
import com.example.bluromatic.KEY_BLUR_LEVEL
import com.example.bluromatic.KEY_IMAGE_URI
import com.example.bluromatic.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import androidx.core.net.toUri

private const val TAG = "BlurWorker"

class BlurWorker (ctx: Context, params: WorkerParameters
    ): CoroutineWorker (ctx, params)
    {
        override suspend fun doWork(): Result {
            val resourceUri = inputData.getString(KEY_IMAGE_URI)
            val blurLevel = inputData.getInt(KEY_BLUR_LEVEL, 1)

            makeStatusNotification(
                applicationContext.resources.getString(R.string.blurring_image),
                applicationContext
            )

            return withContext(Dispatchers.IO) {
                //utility function to make the emulator work slower
                delay(DELAY_TIME_MILLIS)

                return@withContext try {
                    //check that the variable is populated
                    require(!resourceUri.isNullOrBlank()) {
                        val errorMessage =
                            applicationContext.resources.getString(R.string.invalid_input_uri)
                        Log.e(TAG, errorMessage)
                        errorMessage
                    }
                    //we need a content resolver obj to read the content pointed to
                    val resolver = applicationContext.contentResolver

                    //populate the bitmap with the resource id
                    val picture = BitmapFactory.decodeStream( //source is passed as URI
                        resolver.openInputStream(resourceUri.toUri()) //modern approach
                    )
                    //blur the bitmap
                    val output = blurBitmap(picture, blurLevel)
                    //write bitmap to a temp file
                    val outputUri = writeBitmapToFile(applicationContext, output)

                    Result.success()
                } catch (throwable: Throwable) {
                    Log.e(
                        TAG,
                        applicationContext.resources.getString(R.string.error_applying_blur),
                        throwable
                    )
                    Result.failure()
                }
            }
        }
    }