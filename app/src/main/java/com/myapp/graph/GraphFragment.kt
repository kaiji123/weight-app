package com.myapp.graph

import android.graphics.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.myapp.graph.Database.AppDatabase
import com.myapp.graph.Database.WeightData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [GraphFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GraphFragment : Fragment(R.layout.fragment_graph) {


    var graphView: GraphView? = null
    lateinit var list: MutableList<DataPoint>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val canvas = activity?.findViewById<RelativeLayout>(R.id.container)
        /*
        if (canvas != null) {
            val graph = Rectangle(activity)
            graph.layoutParams=  LinearLayout.LayoutParams(800,1500)
            canvas.addView(
                graph

            )




        }*/
        val db = AppDatabase.getInstance(this);
        //db.weightDao().insertWeight(WeightData(0, 58.0f))
        val weights = db.weightDao().getAll();

        list = mutableListOf();
        for (i in weights){
            val s = i.weightNumber?.let { DataPoint(i.uid.toDouble(), it.toDouble()) };
            list.add(s)

        }

        val max_x = 32.0 // or max(datapoints.x)



        graphView = view.findViewById(R.id.idGraphView)
        graphView?.viewport?.setXAxisBoundsManual(true);
        graphView?.viewport?.setMaxX(365.0)


        // on below line we are adding data to our graph view.

        // on below line we are adding data to our graph view.
        val series = LineGraphSeries(
           list.toTypedArray()
        )

        // after adding data to our line graph series.
        // on below line we are setting
        // title for our graph view.

        // after adding data to our line graph series.
        // on below line we are setting
        // title for our graph view.
        graphView!!.title = "My Graph View"

        // on below line we are setting
        // text color to our graph view.

        // on below line we are setting
        // text color to our graph view.
        graphView!!.titleColor = R.color.purple_200

        // on below line we are setting
        // our title text size.

        // on below line we are setting
        // our title text size.
        graphView!!.titleTextSize = 18f

        // on below line we are adding
        // data series to our graph view.

        // on below line we are adding
        // data series to our graph view.
        graphView!!.addSeries(series)
    }
}

/*
private class Rectangle (context: Context?) : View(context) {
    var paint: Paint = Paint()
   var dataSet = listOf<DataPoint>(
       DataPoint(0,550),
       DataPoint(50,500-100),
       DataPoint(500,500-10)
   )
    private val linePaint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 7f
    }
    override fun onDraw(canvas: Canvas) {
        paint.setColor(Color.GREEN)
        /*
        val rect = Rect(20, 56, 200, 112)
        canvas.drawRect(rect, paint)

         */
      dataSet.forEachIndexed { index, currentDataPoint ->
          val realX = currentDataPoint.x
          val realY = currentDataPoint.y

          if (index < dataSet.size - 1) {
              val nextDataPoint = dataSet[index + 1]
              val startX = currentDataPoint.x
              val startY = currentDataPoint.y
              val endX = nextDataPoint.x
              val endY = nextDataPoint.y
              canvas.drawLine(startX.toFloat(), startY.toFloat(),
                  endX.toFloat(), endY.toFloat(), linePaint)
          }


      }

    }
}
*/
