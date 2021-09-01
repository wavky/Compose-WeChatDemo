package com.wavky.wechatdemo.ui.chats.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.data.getDefaultChatList
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.ChatMessage
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.MessageType.MessageId
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side.Left
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side.Right
import com.wavky.wechatdemo.ui.common.resource.Colors

/**
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
@Composable
fun ChatFlowView(
  messageFlow: List<ChatMessage>,
  modifier: Modifier = Modifier,
  listState: LazyListState = rememberLazyListState() // 列表滑动控制器
) {
  LazyColumn(
    modifier
      .fillMaxWidth()
      .background(Colors.topBarGray),
    state = listState
  ) {
    items(messageFlow, key = { it.hashCode() }) { message ->
      ChatMessageView(message)
    }
  }
}

@Preview
@Composable
fun ChatFlowViewPreview() {
  val opposite = getDefaultContactList().shuffled()[0]
  val messages = getDefaultChatList().map { it.lastMessageId }.shuffled()
  val chatMessages = listOf(
    ChatMessage(side = Left(opposite.profileImageId), text = MessageId(messages[0])),
    ChatMessage(side = Right, text = MessageId(messages[0])),
    ChatMessage(side = Left(opposite.profileImageId), text = MessageId(messages[1])),
    ChatMessage(side = Right, text = MessageId(messages[2]))
  )
  ChatFlowView(messageFlow = chatMessages)
}
