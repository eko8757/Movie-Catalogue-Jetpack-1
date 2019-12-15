package com.jetpack.moviecataloguejetpack.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.jetpack.moviecataloguejetpack.R
import com.jetpack.moviecataloguejetpack.utils.BottomNavigationViewListener
import com.jetpack.moviecataloguejetpack.view.fragment.FavoriteFragment
import com.jetpack.moviecataloguejetpack.view.fragment.MovieFragment
import com.jetpack.moviecataloguejetpack.view.fragment.TvFragement
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    BottomNavigationViewListener {

    private lateinit var fragment: Fragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_navigation.inflateMenu(R.menu.bottom_nav_menu)
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_container,
            MovieFragment()
        ).commit()

        main_bottom_navigation.setOnNavigationItemSelectedListener {
            val id = it.itemId
            when (id) {
                R.id.navigation_movie -> fragment =
                    MovieFragment()
                R.id.navigation_tv -> fragment =
                    TvFragement()
                R.id.navigation_favorite -> fragment =
                    FavoriteFragment()
            }

            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment)
            transaction.commit()
            true
        }
    }

    override fun hideBottomNavigationView() {
        if (main_bottom_navigation.translationY >= main_bottom_navigation.height.toFloat())
            main_bottom_navigation.animate()
                .translationY(0f)
                .setDuration(400)
                .start()
    }

    override fun showBottomNavigationView() {
        if (main_bottom_navigation.translationY == 0f)
            main_bottom_navigation.animate()
                .translationY(main_bottom_navigation.height.toFloat())
                .setDuration(250)
                .start()
    }
}
