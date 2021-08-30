package martialcoder.surajsahani.moviedb.utilities

import martialcoder.surajsahani.moviedb.constants.MovieConstants

object ResolveURL {
    fun getURL(CLICKED_BUTTON: String): String {
        return when (CLICKED_BUTTON) {
            "popular" -> {
                MovieConstants.POPULAR_URL_MOVIE
            }
            "nowplaying" -> {
                MovieConstants.NOWPLAYING_URL_MOVIE
            }
            else -> {
                MovieConstants.RATING_URL_MOVIE
            }
        }
    }
}
