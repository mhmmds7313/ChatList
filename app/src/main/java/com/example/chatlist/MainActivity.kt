package com.example.chatlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatlist.ui.theme.ChatListTheme

data class Message(
    val sender: String,
    val text: String
)

val sampleMessages = listOf(
    Message("Joe", "Hi!"),
    Message("Jim", "How are you?"),
    Message("Joe", "Test..1..2...3"),
    Message("Joe", "I hate coding!!!"),
    Message("Joe", "Hi!"),
    Message("Jim", "How are you?"),
    Message("Joe", "Test..1..2...3"),
    Message("Joe", "I hate coding!!!"),
    Message("Joe", "Hi!"),
    Message("Jim", "How are you?"),
    Message("Joe", "Test..1..2...3"),
    Message("Joe", "I hate coding!!!")
)

@Composable
fun MessageRow(message: Message) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFEBEE))
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.padding(top = 4.dp)) {
            Text(
                text = message.sender,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF3F51B5)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Surface(
                color = Color(0xFFF5F5F5),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = message.text,
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(messages) { message ->
            MessageRow(message = message)
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageList(messages = sampleMessages)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageListPreview() {
    ChatListTheme {
        MessageList(messages = sampleMessages)
    }
}