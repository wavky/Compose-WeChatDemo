package com.wavky.wechatdemo.ui.chats.detail

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.data.Chat
import com.wavky.wechatdemo.data.getDefaultChatList
import com.wavky.wechatdemo.ui.chats.detail.viewmodel.ChatDetailViewModel
import com.wavky.wechatdemo.ui.common.SecondaryTopBar
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi

/**
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
@FlowPreview
@ObsoleteCoroutinesApi
@Composable
fun ChatDetailView(chat: Chat, viewModel: ChatDetailViewModel, onClickBack: () -> Unit) {
  val messageFlow = remember {
    viewModel.run {
      sendLastMessage(chat.lastMessageId)
      messageFlow
    }
  }

  val wrappedOnClickBack = {
    viewModel.unsubscribe()
    onClickBack()
  }

  Scaffold(
    Modifier.fillMaxSize(),
    topBar = { SecondaryTopBar(chat.contact.nameId, wrappedOnClickBack) }
  ) {
    Column(Modifier.fillMaxSize()) {
      Divider()
      ChatFlowView(messageFlow, Modifier.weight(1f), listState = viewModel.listState)
      ChatInputView(onSend = { message ->
        viewModel.send(message)
        viewModel.echo(message)
      })
    }
  }

  BackHandler { wrappedOnClickBack() }
}

@FlowPreview
@ObsoleteCoroutinesApi
@Preview
@Composable
fun ChatDetailViewPreview() {
  val chat = getDefaultChatList().shuffled()[0]
  ChatDetailView(chat, ChatDetailViewModel(chat.contact, rememberLazyListState())) {}
}
