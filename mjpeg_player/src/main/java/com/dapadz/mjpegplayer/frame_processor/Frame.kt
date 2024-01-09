import android.graphics.Bitmap

data class Frame(
    val size: Float,
    val bitmap: Bitmap
) {
    val width get() = bitmap.width
    val height get() = bitmap.height
}