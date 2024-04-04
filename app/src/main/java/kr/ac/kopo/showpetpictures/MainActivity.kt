package kr.ac.kopo.showpetpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.VisibleActivityCallback
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    lateinit var Checkstart : CheckBox
    lateinit var rg : RadioGroup
    lateinit var radiopuppy  : RadioButton
    lateinit var radiokitty : RadioButton
    lateinit var radiohamster : RadioButton
    lateinit var Linersub : LinearLayout
    lateinit var btndone : Button
    lateinit var imagev : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Checkstart = findViewById<CheckBox>(R.id.checkstart)
        rg = findViewById<RadioGroup>(R.id.rg)
        Linersub = findViewById<LinearLayout>(R.id.Linearsub)
        btndone = findViewById<Button>(R.id.btndone)
        imagev = findViewById<ImageView>(R.id.imagev)

        Checkstart.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Linersub.visibility = View.VISIBLE
            } else {
                Linersub.visibility = View.INVISIBLE
            }
        }

        btndone.setOnClickListener {
            when(rg.checkedRadioButtonId){
                R.id.radiopuppy -> imagev.setImageResource(R.drawable.puppy)
                R.id.radiokitty -> imagev.setImageResource(R.drawable.kitty)
                R.id.radiohamster-> imagev.setImageResource(R.drawable.hamster)
            }
        }

    }
}