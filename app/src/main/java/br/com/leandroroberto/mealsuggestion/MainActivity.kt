package br.com.leandroroberto.mealsuggestion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private var isTrayOpen : Boolean = false
    private var foodList = arrayOf(
        "Hot Dog",
        "Pizza",
        "Hamburger",
        "Pasta",
        "Cake",
        "Barbecue",
        "Rice and Beans"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSuggestMe.setOnClickListener {
            val index = Random().nextInt(foodList.size)

            val uri = if (! isTrayOpen) {
                textViewMeal.text = foodList[index]
                "@drawable/bandeja_aberta"
            }
            else {
                textViewMeal.text = ""
                "@drawable/bandeja"
            }
            val imageResource = resources.getIdentifier(uri, null, packageName)
            YoYo.with(Techniques.Swing)
                .duration(500)
                .playOn(imgMeal)

            imgMeal.setImageResource(imageResource)
            isTrayOpen = !isTrayOpen
        }
    }

    override fun onStop() {
        super.onStop()
        isTrayOpen = false
    }

}