package `in`.bitcode.customviews2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.widget.TextView

@SuppressLint("AppCompatCustomView")
class TaskView(
    context: Context,
    attributeSet: AttributeSet? = null
) : TextView(context, attributeSet) {

    var isDone = false

    init {
        setPadding(140, 0, 0, 0)
        gravity = Gravity.CENTER_VERTICAL

        setOnClickListener {
            isDone = !isDone
            setTextColor(
                if(isDone) Color.GREEN else Color.BLACK
            )
        }
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)

        Log.e("tag", "onDraw called")

        val paint = Paint()
        paint.color = Color.RED
        paint.strokeWidth = 6f
        canvas.drawLine( 100F, 0F, 100F, height.toFloat(), paint)
        canvas.drawLine( 125F, 0F, 125F, height.toFloat(), paint)
        paint.color = Color.GRAY
        canvas.drawLine(0F, height.toFloat(), width.toFloat(), height.toFloat(), paint)

    }
}












