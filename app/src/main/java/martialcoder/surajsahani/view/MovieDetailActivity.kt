package martialcoder.surajsahani.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import martialcoder.surajsahani.moviedb.adapter.DetailsPagePagerAdapter
import martialcoder.surajsahani.moviedb.fragments.DetailPageView
import martialcoder.surajsahani.moviedb.fragments.Tab1Fragment
import com.example.movieappkotlin.fragments.Tab2Fragment
import martialcoder.surajsahani.moviedb.model.MovieDetailed
import martialcoder.surajsahani.moviedb.view_model.MovieDetailViewModal
import martialcoder.surajsahani.moviedb.view_model.MovieDetailViewModelFactory
import com.google.android.material.tabs.TabLayout
import martialcoder.surajsahani.moviedb.R


class MovieDetailActivity : AppCompatActivity() {

    private var movieId: String? = null
    private var mViewPager: ViewPager? = null
    private lateinit var movieDetailViewModal: MovieDetailViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        movieId = intent.getStringExtra("MOVIE_ID")
        mViewPager = findViewById<View>(R.id.detail_viewpager) as ViewPager?
        val tabLayout = findViewById<View>(R.id.detail_tabs) as TabLayout
        tabLayout.setupWithViewPager(mViewPager)
        movieDetailViewModal = ViewModelProviders.of(this, MovieDetailViewModelFactory(application, movieId)).get(
            MovieDetailViewModal::class.java)
        movieDetailViewModal.movieMutableLiveData!!.observe(this, movieUpdateObserver)
    }


    val movieUpdateObserver: Observer<MovieDetailed?> = Observer<MovieDetailed?> { movie ->
        if (movie.id == 0) return@Observer
        val adapter = DetailsPagePagerAdapter(supportFragmentManager)
        adapter.addFragment(Tab1Fragment.newInstance(movie), "INFO")
        adapter.addFragment(Tab2Fragment.newInstance(movie), "GENRES")
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment: DetailPageView = DetailPageView.newInstance(movie)
        fragmentTransaction.add(R.id.detail_top_view, fragment)
        fragmentTransaction.commit()
        mViewPager!!.adapter = adapter
    }
}



