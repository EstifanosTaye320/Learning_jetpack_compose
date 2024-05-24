package com.example.practice_area

import android.app.Fragment
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_area.ui.theme.Practice_areaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

data class Event(var title: String = "Calender", var guestCount: Int = 0, var owner: String = "Estifanos Taye", var callLink: String = "https//:localhost/link", var guests: String = "guest list...") {
    fun isGreaterThan50 (): Boolean {
        return guestCount > 50
    }

    fun name () {}
}

@Composable
fun SetTitle(title: String) {
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(5.dp)
            )
    ) {
                Text(text = "Title: $title", modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun SetOwner(owner: String) {
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
            Surface (modifier = Modifier.size(width = 30.dp, height = 30.dp), shape = CircleShape,border = BorderStroke(width = 1.dp, color = Color.Black), color = Color.Green) {}
            Text(text = "Owner: $owner", modifier = Modifier.padding(5.dp), fontFamily = FontFamily.Cursive, fontSize = 30.sp)
    }


}

@Composable
fun SetCallLink(link: String, room: String = "") {
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(2.dp, Color.Black),
                shape = RoundedCornerShape(5.dp)
            )
            ) {
        Column (modifier = Modifier.padding(5.dp)){
            Text(text = "Link: $link")
            Text(text = if (room != "") "Room: $room" else "")
        }
    }
}

@Composable
fun CalenderCard(event: Event) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        border = BorderStroke(width = 2.dp, color = Color.Black),
        shape = RoundedCornerShape(2.dp)

    ) {
        Column(verticalArrangement = Arrangement.Center) {
            SetTitle(title = event.title)

            Spacer(modifier = Modifier.height(4.dp))

            Surface (
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(5.dp)
                    )
            ) {

            }
        }
    }
}


@Preview
@Composable
fun PreviewCard () {
    CalenderCard(event = Event())
}