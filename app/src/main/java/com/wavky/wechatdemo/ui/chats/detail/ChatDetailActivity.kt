package com.wavky.wechatdemo.ui.chats.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wavky.wechatdemo.data.Chat
import com.wavky.wechatdemo.data.getDefaultChatList
import com.wavky.wechatdemo.ui.chats.detail.viewmodel.ChatDetailViewModel
import com.wavky.wechatdemo.ui.chats.detail.viewmodel.ChatDetailViewModelFactory
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

@FlowPreview
@ObsoleteCoroutinesApi
class ChatDetailActivity : ComponentActivity() {

  companion object {
    const val INTENT_EXTRA_KEY_CHAT = "intent_chat"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val chat = intent.getParcelableExtra<Chat>(INTENT_EXTRA_KEY_CHAT)
    setContent {
      if (chat != null) {
        ContentView(chat, this)
      } else {
        Spacer(Modifier.fillMaxSize())
      }
    }
  }
}

@FlowPreview
@ObsoleteCoroutinesApi
@Composable
fun ContentView(
  chat: Chat,
  activity: ChatDetailActivity?,
  viewModel: ChatDetailViewModel = viewModel(
    factory = ChatDetailViewModelFactory(
      opposite = chat.contact,
      listState = rememberLazyListState() // 用于控制滑动
    )
  )
) {
  ChatDetailView(chat, viewModel) {
    activity?.finish()
  }
}

@FlowPreview
@ObsoleteCoroutinesApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  val chat = getDefaultChatList().shuffled()[0]
  ContentView(chat, null, ChatDetailViewModel(chat.contact, rememberLazyListState()))
}
