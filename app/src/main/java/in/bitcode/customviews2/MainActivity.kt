package `in`.bitcode.customviews2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.util.Random
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {

    private lateinit var graphView: GraphView
    private lateinit var btnRefresh : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(R.layout.graph_layout)
        graphView = findViewById(R.id.graphView)
        graphView.values = arrayOf(90, 60, 70, 80, 40)

        btnRefresh = findViewById(R.id.btnRefresh)

        btnRefresh.setOnClickListener {
            val random = Random()
            val size =  random.nextInt().absoluteValue.mod(10) + 1
            graphView.values = Array<Int>(size) {
                index -> random.nextInt().absoluteValue.mod(101)
            }
            graphView.invalidate()
        }
    }
}