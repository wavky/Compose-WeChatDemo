package com.wavky.wechatdemo.ui.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.data.getDefaultChatList
import com.wavky.wechatdemo.ui.common.TopBar

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
@Composable
fun ChatsView(modifier: Modifier = Modifier) {
  val chats = getDefaultChatList()
  Scaffold(
    modifier,
    topBar = { TopBar(R.string.app_name) }
  ) {
    LazyColumn {
      items(chats) { chat ->
        ChatItemView(chat)
      }
    }
  }
}

@Preview
@Composable
fun ChatsViewPreview() {
  ChatsView(
    Modifier
      .fillMaxSize()
      .background(Color.White)
  )
}
