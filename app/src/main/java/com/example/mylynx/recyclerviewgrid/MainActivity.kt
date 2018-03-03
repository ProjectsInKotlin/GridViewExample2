package com.example.mylynx.recyclerviewgrid

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.mylynx.recyclerviewgrid.adapter.RecyclerViewGridAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var adapter: RecyclerViewGridAdapter? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var numberOfColums = Utility.calculateNoOfColumns(this)
        val list = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                "41", "42", "43", "44", "45", "46", "47", "48")
        adapter = RecyclerViewGridAdapter(this, list)
        layoutManager = GridLayoutManager(this, numberOfColums)

        recyclerViewId.adapter = adapter
        recyclerViewId.layoutManager = layoutManager


    }
}

//calculates number of item_rows to auto fit column
object Utility {
    fun calculateNoOfColumns(context: Context): Int {
        val displayMetrics = context.getResources().getDisplayMetrics()
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        val scaleRatio = context.resources.getDisplayMetrics().density;
        val dimenPix = context.resources.getDimension(R.dimen.row_width) + (context.resources.getDimension(R.dimen.row_padding) * 2f)

        val rowWidth = dimenPix / scaleRatio
     //   Log.d("width", "$rowWidth")
        return (dpWidth / rowWidth).toInt()
        // rowWidth is from dimens.xml. 50 is width of item_row
    }
}