package com.wavky.wechatdemo.ui.chats.detail.viewmodel

import androidx.annotation.StringRes
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.wavky.wechatdemo.data.Contact
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.ChatMessage
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.MessageType.MessageId
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.MessageType.MessageString
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side.Left
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side.Right
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

/**
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
@FlowPreview
@ObsoleteCoroutinesApi
class ChatDetailViewModel(private val opposite: Contact, val listState: LazyListState) :
  ViewModel() {

  private var sender: SendChannel<ChatMessage>? = null

  val messageFlow = mutableStateListOf<ChatMessage>()

  init {
    subscribe()
  }

  private fun subscribe() {
    viewModelScope.launch {
      sender = actor {
        consumeAsFlow()
          .debounce(1000)
          .flowOn(Dispatchers.IO)
          .collect { message ->
            messageFlow.add(message)
            scrollToBottom()
          }
      }
    }
  }

  fun unsubscribe() {
    sender?.close()
    sender = null
  }

  private fun scrollToBottom() {
    viewModelScope.launch {
      listState.scrollToItem(messageFlow.lastIndex)
    }
  }

  fun sendLastMessage(@StringRes messageId: Int) {
    messageFlow.add(
      ChatMessage(
        side = Left(opposite.profileImageId),
        text = MessageId(messageId)
      )
    )
  }

  fun send(message: String) {
    messageFlow.add(ChatMessage(side = Right, text = MessageString(message)))
    scrollToBottom()
  }

  fun echo(message: String) {
    viewModelScope.launch {
      sender?.trySend(
        ChatMessage(
          side = Left(opposite.profileImageId),
          text = MessageString(message.stupidSwap())
        )
      )
    }
  }
}

@FlowPreview
@ObsoleteCoroutinesApi
class ChatDetailViewModelFactory(
  private val opposite: Contact,
  private val listState: LazyListState
) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return ChatDetailViewModel(opposite, listState) as T
  }
}

private fun String.swap(a: String, b: String): String {
  val swapMark = "__Swapping__"
  val replaceA = this.replace(a, swapMark)
  val replaceB = replaceA.replace(b, a)
  return replaceB.replace(swapMark, b)
}

private fun String.stupidSwap(): String =
  swap("我", "你")
    .swap("I ", "You ")
    .swap(" you", " me")
