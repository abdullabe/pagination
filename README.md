# Pagination-RecyclerView
Simple and easy way to Paginating a RecyclerView

Android library/module to make Recyclerview paginate 

While scrolling we need to add page chnage listener so that we can detect the ending of list and can work as per our needs

    recyclerView.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageChange(page: Int) {
                //Page change listener for recycler view
                
                //TODO Add own code here to fetch data
            }
        })


This is how you can add the custom recycler view (chnage the tag as per your package name)

    <com.rakshit.pagination_recyclerview.PaginationRecyclerView
        android:id="@+id/custom_recycler_view"
        android:layout_width="match_parent"
        app:layoutManager="androidx.recyclerview.widget.StaggeredGridLayoutManager"
        app:spanCount="2"
        tools:listitem="@layout/item_photos"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"/>

Now you can initialize the Recyclerview like below

     val recyclerView: PaginationRecyclerView = findViewById(R.id.custom_recycler_view)

        recyclerView.adapter = //TODO Add your adapter here
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageChange(page: Int) {
                //Page change listener for recycler view
              
                //TODO Add own code here to fetch data
            }
        })

**Note**: You need to create your own Recyclerview's adapter as per your need, a sample is already added in code base

Like what I did buy me coffee maybe?

<a href='https://ko-fi.com/P5P57R3V2' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://cdn.ko-fi.com/cdn/kofi3.png?v=3' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>

or get in touch with me to discuss a project visit http://rakshit.tech/ to discuss with me more.

Happy Coding !!
Cheers
