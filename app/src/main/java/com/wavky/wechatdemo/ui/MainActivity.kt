package com.wavky.wechatdemo.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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

  Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Bottom) {
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
