package vcmsa.ci.practicumexamapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScreenTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen_two)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//Declarations Here
        val btnReturnToMain = findViewById<Button>(R.id.btnReturnToMain)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val lblOutputPlaylist = findViewById<TextView>(R.id.lblOutputPlaylist)




        btnReturnToMain.setOnClickListener {
            finish()
            //This button Return the Main Screen
        }
        //Setting the Display Button for the list
        btnDisplay.setOnClickListener {
            var outputString: String = ""
            //for loop that runs 0 to the position
            for (i in 0..arrayPosition-1 ) { // (IIE,2025)
                Log.d(TAG, "The for loop to show the list")
                if (songRatings[i] < 5) {
                    //The list is populated here and the list will show
                    outputString += "Song Title:" + songTitles[i] + "\n"
                    outputString += "Artist Name: " + artistNames[i] + "\n"
                    outputString += "Song Rating:" + songRatings[i].toString() + "\n"
                    outputString += "Song Comments:" + songComments[i] + "\n\n"
                    Log.d(TAG, "The list has successfully been shown")
                }
                lblOutputPlaylist.text = outputString
                //The output to view the list
            }

            btnCalculate.setOnClickListener {
//Setting teh button for the Calculation
                }
            }
        }
    }












//The IIE.2025. Introduction to Mobile Application Development [IMAD5112 Module Manual]. The Independent Institute of Education: Unpublished.





