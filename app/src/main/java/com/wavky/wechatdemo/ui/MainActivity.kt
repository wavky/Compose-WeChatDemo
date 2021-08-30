package com.wavky.wechatdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.ui.chats.ChatsView
import com.wavky.wechatdemo.ui.contacts.ContactsView

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ContentView()
    }
  }
}

@Composable
fun ContentView() {
  var selectingTab by remember { mutableStateOf(Tabs.CHATS) }

  Column(Modifier.fillMaxHeight()) {
    when (selectingTab) {
      Tabs.CHATS -> ChatsView(Modifier.weight(1f))
      Tabs.CONTACTS -> ContactsView(Modifier.weight(1f))
      else -> Spacer(
        Modifier
          .fillMaxWidth()
          .weight(1f)
      )
    }
    TabBar(selectingTab) { selectTab ->
      selectingTab = selectTab
    }
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ContentView()
}
