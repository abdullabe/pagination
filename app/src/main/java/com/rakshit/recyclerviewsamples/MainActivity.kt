package com.rakshit.recyclerviewsamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.rakshit.pagination_recyclerview.OnPageChangeListener
import com.rakshit.pagination_recyclerview.PaginationRecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mContext by lazy { this }
    private val adapter by lazy { RecyclerViewAdapter(mContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: PaginationRecyclerView = findViewById(R.id.custom_recycler_view)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageChange(page: Int) {
                //Page change listener for recycler view
                //Page changed fetch more data from here
                //TODO Add own code here to fetch data
                addImages()

            }
        })

        addImages()
    }

    /**
     * Sample function to add data in the recycler view
     */
    private fun addImages() {

        val listImages = arrayListOf<String>()

        listImages.add("https://live.staticflickr.com/65535/51748990209_55b9f047d9_b.jpg")
        listImages.add("https://i.picsum.photos/id/566/536/354.jpg?hmac=Qe2MWolacWFJhNfFjmrRRPCdvD0fOtwXEsq_f53gkic")
        listImages.add("https://live.staticflickr.com/7372/12502775644_acfd415fa7_w.jpg")
        listImages.add("https://i.picsum.photos/id/232/536/354.jpg?hmac=f5nImxsmSPKAujq3uNUnMKfZlNzS5PQH1BaKGmOpJio")

        for (i in 0..49) {
            adapter.addItem(listImages[Random().nextInt(listImages.size)])
        }
    }
}