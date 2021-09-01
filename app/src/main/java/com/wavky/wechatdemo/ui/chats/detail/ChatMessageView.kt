package com.wavky.wechatdemo.ui.chats.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.ChatMessage
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.MessageType.MessageId
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.MessageType.MessageString
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side.Left
import com.wavky.wechatdemo.ui.chats.detail.bindingmodel.Side.Right
import com.wavky.wechatdemo.ui.common.ExpandedSpacer
import com.wavky.wechatdemo.ui.common.extension.toStringRes
import com.wavky.wechatdemo.ui.common.resource.Colors
import com.wavky.wechatdemo.ui.common.resource.Sizes

/**
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
@Composable
fun ChatMessageView(message: ChatMessage) {
  CompositionLocalProvider(LocalLayoutDirection provides message.side.direction) {
    Row(
      Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
      Image(
        painterResource(message.side.profileImageId),
        contentDescription = "profile image",
        Modifier
          .padding(end = Sizes.itemSpacing)
          .size(40.dp)
          .clip(RoundedCornerShape(CornerSize(4.dp)))
      )
      MessageText(message)
      ExpandedSpacer()
    }
  }
}

@Composable
private fun MessageText(message: ChatMessage) {
  val messageString = with(message.text) {
    when (this) {
      is MessageString -> text
      is MessageId -> text.toStringRes()
    }
  }
  CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
    Text(
      messageString,
      Modifier
        .background(message.side.color, RoundedCornerShape(CornerSize(4.dp)))
        .padding(10.dp),
      fontSize = Sizes.fontItemTitle
    )
  }
}

val Side.color: Color
  get() = when (this) {
    is Left -> Color.White
    is Right -> Colors.chatGreen
  }

val Side.direction: LayoutDirection
  get() = when (this) {
    is Left -> LayoutDirection.Ltr
    is Right -> LayoutDirection.Rtl
  }

@Preview
@Composable
fun ChatMessageViewPreview() {
  val contact = getDefaultContactList().shuffled()[0]
  Column(
    Modifier
      .fillMaxWidth()
      .background(Colors.lightGray)
  ) {
    ChatMessageView(
      ChatMessage(
        Left(contact.profileImageId),
        MessageString("Hello?")
      )
    )
    ChatMessageView(
      ChatMessage(
        Right,
        MessageString("Hello?")
      )
    )
    ChatMessageView(
      ChatMessage(
        Left(contact.profileImageId),
        MessageString("Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?")
      )
    )
    ChatMessageView(
      ChatMessage(
        Right,
        MessageString("Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?Hello?")
      )
    )
  }
}
