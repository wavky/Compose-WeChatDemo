package com.wavky.wechatdemo.ui.chats

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wavky.wechatdemo.data.Chat
import com.wavky.wechatdemo.data.LastContactTime
import com.wavky.wechatdemo.data.LastContactTime.TimeId
import com.wavky.wechatdemo.data.LastContactTime.TimeString
import com.wavky.wechatdemo.data.getDefaultChatList
import com.wavky.wechatdemo.ui.Colors
import com.wavky.wechatdemo.ui.Sizes
import com.wavky.wechatdemo.ui.common.ExpandedSpacer
import com.wavky.wechatdemo.ui.common.extension.toStringRes

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
@Composable
fun ChatItemView(chat: Chat, modifier: Modifier = Modifier) {
  Row(
    modifier
      .padding(horizontal = Sizes.defaultPadding)
      .height(80.dp)
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      painter = painterResource(id = chat.contact.profileImageId),
      contentDescription = "profile image",
      Modifier
        .size(50.dp)
        .clip(RoundedCornerShape(CornerSize(4.dp)))
    )
    Spacer(Modifier.width(Sizes.defaultPadding))
    Column {
      ExpandedSpacer()
      Row {
        Column {
          Text(
            chat.contact.nameId.toStringRes(),
            Modifier.padding(bottom = 8.dp),
            fontSize = 18.sp,
            maxLines = 1
          )
          Text(
            chat.lastMessageId.toStringRes(),
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            maxLines = 1
          )
        }
        ExpandedSpacer()
        LastContactTimeText(chat.lastContactTime)
      }
      ExpandedSpacer()
      Divider(thickness = Sizes.divider)
    }
  }
}

@Composable
private fun LastContactTimeText(contactTime: LastContactTime, modifier: Modifier = Modifier) {
  val timeString = when (contactTime) {
    is TimeString -> contactTime.time
    is TimeId -> contactTime.time.toStringRes()
  }
  Text(
    timeString,
    modifier,
    fontSize = 12.sp,
    maxLines = 1,
    color = Colors.lightGray
  )
}

@Preview
@Composable
fun ChatItemViewPreview() {
  val chats = getDefaultChatList()
  Column(
    Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    ChatItemView(chat = chats[0])
    ChatItemView(chat = chats[1])
    ChatItemView(chat = chats[2])
    ChatItemView(chat = chats[3])
  }
}
