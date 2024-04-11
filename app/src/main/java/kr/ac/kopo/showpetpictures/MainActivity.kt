package kr.ac.kopo.showpetpictures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession.VisibleActivityCallback
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.OnClickListener
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
    lateinit var imagev : ImageView
    lateinit var btnFinish : Button
    lateinit var btnInit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Checkstart = findViewById<CheckBox>(R.id.checkstart)
        rg = findViewById<RadioGroup>(R.id.rg)
        Linersub = findViewById<LinearLayout>(R.id.Linearsub)
        imagev = findViewById<ImageView>(R.id.imagev)
        btnFinish = findViewById<Button>(R.id.btnFinsh)
        btnInit = findViewById<Button>(R.id.btnInit)
        btnFinish.setOnClickListener(btnListener)
        btnInit.setOnClickListener(btnListener)

        Checkstart.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Linersub.visibility = View.VISIBLE
            } else {
                Linersub.visibility = View.INVISIBLE
            }
        }

        rg.setOnCheckedChangeListener { buttonView, isChecked ->
            when(rg.checkedRadioButtonId){
                R.id.radiopuppy -> imagev.setImageResource(R.drawable.puppy)
                R.id.radiokitty -> imagev.setImageResource(R.drawable.kitty)
                R.id.radiohamster-> imagev.setImageResource(R.drawable.hamster)
            }
        }

    }

    val btnListener = OnClickListener{
        when(it.id){
            R.id.btnFinsh -> finish()
            R.id.btnInit -> {
                Checkstart.isChecked = false
                Linersub.visibility = INVISIBLE
            }
        }
    }
}