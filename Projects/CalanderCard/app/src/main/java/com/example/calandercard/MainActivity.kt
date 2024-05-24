package com.example.calandercard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calandercard.ui.theme.CalanderCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalenderCard(event = Event(guestCount = 6))
        }
    }
}

data class Event(var title: String = "Calender",
                 var guestCount: Int = 0,
                 var owner: String = "Estifanos Taye",
                 var callLink: String = "https//:localhost/link",
                 val guests: List<String> = List(guestCount) {"Guest number $it"},
                 var room: String = "NB 107") {
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
    ) { Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Title: $title",
            modifier = Modifier.padding(5.dp),
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    } }
}

@Composable
fun SetOwner(owner: String) {
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Surface (modifier = Modifier.size(width = 30.dp, height = 30.dp), shape = CircleShape,border = BorderStroke(width = 1.dp, color = Color.Black), color = Color.Green) {}
        Text(text = "Owner: $owner",
            modifier = Modifier.padding(5.dp),
            fontFamily = FontFamily.Cursive,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold)
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
            Text(text = "Link: $link",
                modifier = Modifier.padding(5.dp),
                fontFamily = FontFamily.Cursive,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
            if(room != "") {
                Text(text = "Room: $room",
                    modifier = Modifier.padding(5.dp),
                    fontFamily = FontFamily.Cursive,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun SetGuestList(guests: List<String>, count: Int, liable: Boolean) {
    Column() {
        var isExpanded by remember { mutableStateOf(value = count <= 5) }

        Row() {
            if (liable) {
                Text(text = "Guests(50+)",
                    modifier = Modifier.padding(5.dp),
                    fontFamily = FontFamily.Cursive,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold)
            } else {
                Text(text = "Guests($count)",
                    modifier = Modifier.padding(5.dp),
                    fontFamily = FontFamily.Cursive,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold)
            }


            IconButton(onClick = { isExpanded = !isExpanded }) {
                if (isExpanded) {
                    Icon(
                        Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Compress"
                    )
                }else {
                    Icon(
                        Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Compress"
                    )
                }
            }
        }


        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            if (isExpanded) {
                items(guests) {guest ->
                    Row (modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically) {
                        Surface (modifier = Modifier.size(width = 20.dp, height = 20.dp),
                            shape = CircleShape,
                            border = BorderStroke(width = 1.dp, color = Color.Black),
                            color = Color.LightGray) {}
                        Text(text = guest,
                            fontFamily = FontFamily.Cursive,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CalenderCard(event: Event) {
    CalanderCardTheme {
        Surface (
            modifier = Modifier.fillMaxHeight(),
            border = BorderStroke(width = 2.dp, color = Color.Black),
            shape = RoundedCornerShape(2.dp)

        ) {
            Column(modifier = Modifier.padding(10.dp),verticalArrangement = Arrangement.Center) {
                SetTitle(title = event.title)

                Spacer(modifier = Modifier.height(10.dp))

                Surface (
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            border = BorderStroke(2.dp, Color.Black),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(10.dp)
                ) {
                    Column{
                        SetOwner(owner = event.owner)

                        Spacer(modifier = Modifier.height(10.dp))

                        SetGuestList(guests = event.guests, count = event.guestCount, liable = event.isGreaterThan50() )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                SetCallLink(link = event.callLink, room = event.room)
            }
        }
    }
}


@Preview
@Composable
fun PreviewCard () {
    CalenderCard(event = Event(guestCount = 6))
}