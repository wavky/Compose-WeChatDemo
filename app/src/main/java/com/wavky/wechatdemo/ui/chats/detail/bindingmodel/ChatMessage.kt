package com.wavky.wechatdemo.ui.chats.detail.bindingmodel

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.wavky.wechatdemo.R

/**
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
data class ChatMessage(
  val side: Side,
  val text: MessageType
)

sealed class MessageType {
  data class MessageString(val text: String) : MessageType()
  data class MessageId(@StringRes val text: Int) : MessageType()
}

sealed class Side {
  abstract val profileImageId: Int

  data class Left(
    @DrawableRes override val profileImageId: Int
  ) : Side()

  object Right : Side() {
    @DrawableRes
    override val profileImageId: Int = R.drawable.avatar_me
  }
}
