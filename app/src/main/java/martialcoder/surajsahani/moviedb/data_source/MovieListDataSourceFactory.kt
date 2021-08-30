package martialcoder.surajsahani.moviedb.data_source

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import martialcoder.surajsahani.moviedb.data_source.MovieApiListDataSource
import martialcoder.surajsahani.moviedb.model.Movie

class MovieListDataSourceFactory(var context: Context, var CLICKED_BUTTON: String) :
    DataSource.Factory<Int, Movie>() {
    /**
     * ArticleDataSourceFactory is responsible for retrieving the data using the
     * ArticleDataSource
     * and
     * PagedList configuration which is inside our ArticleViewModel class
     */
    // creating the mutable live data
    private var itemLiveDataSource: MutableLiveData<PageKeyedDataSource<Int, Movie>> =
        MutableLiveData<PageKeyedDataSource<Int, Movie>>()

    override fun create(): DataSource<Int, Movie>? {
        //getting our data source object

            val movieApiDataSource = MovieApiListDataSource(context, CLICKED_BUTTON)

            //posting the data source to get the values
            itemLiveDataSource.postValue(movieApiDataSource)

            //returning the data source
            return movieApiDataSource
    }

    //getter for itemlivedatasource
    fun getItemLiveDataSource(): MutableLiveData<PageKeyedDataSource<Int, Movie>> {
        return itemLiveDataSource
    }
}
