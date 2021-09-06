package com.wavky.wechatdemo.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.ui.chats.ChatsView
import com.wavky.wechatdemo.ui.chats.detail.ChatDetailActivity
import com.wavky.wechatdemo.ui.contacts.ContactsView
import com.wavky.wechatdemo.ui.discover.DiscoverView
import com.wavky.wechatdemo.ui.me.MeView
import com.wavky.wechatdemo.ui.me.QrCodeView
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ContentView(this)
    }
  }
}

@FlowPreview
@ObsoleteCoroutinesApi
@Composable
fun ContentView(activity: Activity?) {
  var selectingTab by remember { mutableStateOf(Tabs.CHATS) }
  var showQrCode by remember { mutableStateOf(false) }

  Column(Modifier.fillMaxHeight()) {
    activity?.window?.grayStatusBar(activity)
    when (selectingTab) {
      Tabs.CHATS -> ChatsView(Modifier.weight(1f)) { chat ->
        activity?.startActivity(Intent(activity, ChatDetailActivity::class.java).apply {
          putExtra(ChatDetailActivity.INTENT_EXTRA_KEY_CHAT, chat)
        })
      }
      Tabs.CONTACTS -> ContactsView(Modifier.weight(1f))
      Tabs.DISCOVER -> DiscoverView(Modifier.weight(1f))
      Tabs.ME -> if (!showQrCode) {
        activity?.window?.whiteStatusBar()
        MeView(Modifier.weight(1f)) { showQrCode = true }
      } else {
        activity?.window?.grayStatusBar(activity)
        QrCodeView(Modifier.weight(1f)) { showQrCode = false }
      }
    }
    TabBar(selectingTab) { selectTab ->
      selectingTab = selectTab
    }
  }
}

private fun Window.whiteStatusBar() {
  statusBarColor = Color.WHITE
}

private fun Window.grayStatusBar(context: Context) {
  statusBarColor = ContextCompat.getColor(context, R.color.statusBar)
}

@ObsoleteCoroutinesApi
@FlowPreview
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ContentView(null)
}
