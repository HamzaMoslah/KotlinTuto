package com.example.root.kotlinkeddit.fragments

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.root.kotlinkeddit.InfiniteScrollListener
import com.example.root.kotlinkeddit.KedditApp
import com.example.root.kotlinkeddit.NewsManager
import com.example.root.kotlinkeddit.R
import com.example.root.kotlinkeddit.adapters.NewsAdapter
import com.example.root.kotlinkeddit.extensions.inflate
import com.example.root.kotlinkeddit.models.RedditNews
import kotlinx.android.synthetic.main.news_fragment.*
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by root on 04/07/17.
 */
class NewsFragment : RxBaseFragment() {
    companion object {
        private val KEY_REDDIT_NEWS = "redditNews"
    }

    private var redditNews: RedditNews? = null
    @Inject lateinit var newsManager: NewsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KedditApp.newsComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.apply {
            setHasFixedSize(true)
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            clearOnScrollListeners()
            addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
        }

        initAdapter()

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_REDDIT_NEWS)){
            redditNews = savedInstanceState.get(KEY_REDDIT_NEWS) as RedditNews
            (news_list.adapter as NewsAdapter).clearAndAddNews(redditNews!!.news)
        }else{
            requestNews()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val news = (news_list.adapter as NewsAdapter).getNews()
        if (redditNews != null && news.size > 0){
            outState.putParcelable(KEY_REDDIT_NEWS, redditNews?.copy(news = news))
        }
    }

    private fun initAdapter(){
        if (news_list.adapter == null){
            news_list.adapter = NewsAdapter()
        }
    }

    private fun requestNews(){
        val subscription = newsManager.getNews(redditNews?.after ?: "").subscribeOn(Schedulers.io()).subscribe({
            retrievedNews -> redditNews = retrievedNews
            (news_list.adapter as NewsAdapter).addNews(retrievedNews.news)
        },{
           e -> Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
        })
        subscriptions.add(subscription)
    }
}