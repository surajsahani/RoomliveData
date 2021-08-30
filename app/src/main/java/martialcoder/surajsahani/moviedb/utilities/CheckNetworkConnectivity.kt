package martialcoder.surajsahani.moviedb.utilities

import android.content.Context
import android.net.ConnectivityManager

class CheckNetworkConnectivity {
    fun check(context : Context): Boolean{
        val cm =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting) {
            return true
        }
        return false
    }
}