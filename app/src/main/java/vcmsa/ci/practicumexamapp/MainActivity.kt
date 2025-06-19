package vcmsa.ci.practicumexamapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//Set a Global Array Here
var songTitles  =Array<String>(4){""}
var  artistNames= Array<String> (4){""}
var songRatings = Array<Int> (4){0}
var songComments = Array<String> (4) {""}
var arrayPosition = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Student name: Kimberly Takundwa
        // Student Number: ST10471537
//Declarations for my Code
        val btnAddToPlaylist = findViewById<Button>(R.id.btnAddToPlaylist)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnExit = findViewById<Button>(R.id.btnExit)
        var lblArtistName = findViewById<EditText>(R.id.lblArtistName)
        var lblRate = findViewById<EditText>(R.id.lblRate)
        var lblSongTitle = findViewById<EditText>(R.id.lblSongTitle)
        var lblComments = findViewById<EditText>(R.id.lblComments)
        val TAG = "Playlist Manager App"
//Setting the Button
        btnAddToPlaylist.setOnClickListener {
            val songTitle: String = lblSongTitle.text.toString()
            val artistName: String = lblArtistName.text.toString()
            val songComment: String = lblComments.text.toString()
            val songRating: String = lblRate.text.toString()

            if (songTitle.isNullOrBlank()) {  //(IIE, 2025)
                Toast.makeText(
                    this,
                    "Input cannot be left blank, please enter a valid input and try again.",
                    Toast.LENGTH_SHORT //This toast message is for error handling
                ).show()
                Log.d(TAG, "The user did not enter a song title")
                //If the input is invalid, exit out of the onclick method
                return@setOnClickListener

            }
            if (songRating.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Input cannot be blank,enter the numbers between 1-5 and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter the song rating number")
                return@setOnClickListener

            } else if (!songRating.isDigitsOnly()) {
                Toast.makeText(
                    this,
                    "Enter only digits in the rating section, rate between 1 and 5",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            if (songComment.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Input cannot be blank, please enter a valid input and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter a comment")
                return@setOnClickListener

            }
            if (artistName.isNullOrBlank()) {
                Toast.makeText(
                    this,
                    "Input cannot be blank, please enter a valid input and try again.",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(TAG, "The user did not enter the artist's name")
                return@setOnClickListener

            }
            if (arrayPosition < 4) { //(IIE, 2025)
                songTitles[arrayPosition] = songTitle
                artistNames[arrayPosition] = artistName
                songRatings[arrayPosition] = songRating.toInt()
                songComments[arrayPosition] = songComment
                arrayPosition++
                Toast.makeText(this, "Added to Playlist 🎶❤️!", Toast.LENGTH_SHORT)
                    .show() //Toast Message to show that the list was added
                Log.d(
                    TAG,
                    "User has tried to add songs to full array:("
                ) // Log Statement For Understanding of the Code


            }
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, ScreenTwo::class.java)
            startActivity(intent)
            //Starting the Next Screen

        }
        //Setting teh exit Button to completely shut down the app
        btnExit.setOnClickListener {
            finishAffinity()
            //This button shut the app down and stops it

        }
    }
}
//The IIE.2025. Introduction to Mobile Application Development [IMAD5112 Module Manual]. The Independent Institute of Education: Unpublished.