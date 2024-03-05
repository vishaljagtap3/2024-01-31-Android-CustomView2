package `in`.bitcode.customviews2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import java.util.Random
import kotlin.math.absoluteValue

class GraphView(
    context: Context,
    attributeSet: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attributeSet){

    var values : Array<Int>? = null


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if(values == null) {
            return
        }

        val paint = Paint()
        paint.color = Color.RED

        val barWidth = width / values!!.size
        val heightPerc = height / 100F

        var topX = 0F
        var topY = 0F

        val random = Random()

        for(value in values!!) {
            topY = height - value * heightPerc
            paint.color = Color.rgb(
                random.nextInt().absoluteValue.mod(256),
                random.nextInt().absoluteValue.mod(256),
                random.nextInt().absoluteValue.mod(256)
            )
            canvas.drawRect(topX, topY, topX-5 + barWidth, height.toFloat(), paint)
            paint.color = Color.WHITE
            paint.textSize = 100F
            canvas.drawText(value.toString(), topX + 10, height - 20F, paint)


            topX += barWidth
        }


    }
}