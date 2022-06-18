package jp.co.kotakestudio.godotandroidrequestreview

import android.util.Log
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManagerFactory
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin

class GodotAndroidRequestReview(godot: Godot?) : GodotPlugin(godot) {
    companion object {
        var TAG = "GodotAndroidRequestReview"
        var PLUGIN_NAME = "RequestReview"
    }


    override fun getPluginName(): String {
        return PLUGIN_NAME
    }

    override fun getPluginMethods(): MutableList<String> {
        return mutableListOf(
            "requestReview",
        )
    }

    fun requestReview() {
        Log.i(TAG, "requestReview")
        val manager = ReviewManagerFactory.create(activity!!)
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // We got the ReviewInfo object
                val reviewInfo = task.result as ReviewInfo
                val flow = manager.launchReviewFlow(activity!!, reviewInfo)
                flow.addOnCompleteListener { _ ->
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                    Log.i(TAG, "Request Review has finished.")
                }
            } else {
                Log.w(TAG, task.exception.toString())
                // There was some problem, log or handle the error code.
//                @ReviewErrorCode val reviewErrorCode = (task.exception as TaskException).errorCode
            }
        }
    }
}