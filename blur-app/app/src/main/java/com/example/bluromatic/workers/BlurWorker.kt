package com.example.bluromatic.workers

import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import com.example.bluromatic.DELAY_TIME_MILLIS
import com.example.bluromatic.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private const val TAG = "BlurWorker"

class BlurWorker (ctx: Context, params: WorkerParameters
    ): CoroutineWorker (ctx, params)
    {
        override suspend fun doWork(): Result {
            makeStatusNotification(
                applicationContext.resources.getString(R.string.blurring_image),
                applicationContext
            )

            return withContext(Dispatchers.IO) {
                //utility function to make the emulator work slower
                delay(DELAY_TIME_MILLIS)

                return@withContext try {
                    //populate the bitmap with the resource id
                    val picture = BitmapFactory.decodeResource(
                        applicationContext.resources,
                        R.drawable.android_cupcake
                    )
                    //blur the bitmap
                    val output = blurBitmap(picture,1)
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