package com.example.flixter_2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"

class DetailActivity : AppCompatActivity() {

    private lateinit var backdropImg: ImageView
    private lateinit var posterImg: ImageView
    private lateinit var titleTxt: TextView
    private lateinit var dateTxt: TextView
    private lateinit var popularityTxt: TextView
    private lateinit var overviewTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        backdropImg = findViewById(R.id.detail_backdrop)
        posterImg = findViewById(R.id.detail_poster)
        titleTxt = findViewById(R.id.detail_title)
        dateTxt = findViewById(R.id.detail_date)
        popularityTxt = findViewById(R.id.detail_popularity)
        overviewTxt = findViewById(R.id.detail_overview)
        //   trailerBtn = findViewById(R.id.trailer)

        val movie: Movie? = intent.getSerializableExtra("MOVIE") as Movie?
        titleTxt.text = movie?.title
        dateTxt.text = movie?.date
        popularityTxt.text = movie?.popularity
        overviewTxt.text = movie?.description

        var baseUrl = "https://image.tmdb.org/t/p/w500/"
        val radius = 10

        Glide.with(this)
            .load(baseUrl+ (movie?.posterPath ))
            .centerInside()
            .transform(RoundedCorners(radius))
            .into(posterImg)

        Glide.with(this)
            .load(baseUrl+ (movie?.backdropPath ))
            .centerInside()
            .into(backdropImg)

    }

}

