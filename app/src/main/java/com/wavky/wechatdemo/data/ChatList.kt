package com.wavky.wechatdemo.data

import androidx.annotation.StringRes
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.data.LastContactTime.TimeId
import com.wavky.wechatdemo.data.LastContactTime.TimeString

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
fun getDefaultChatList(): List<Chat> {
  val contacts = getDefaultContactList().shuffled()
  val lastMessageIds = listOf(
    R.string.last_message_message_hi,
    R.string.last_message_message_hey,
    R.string.last_message_message_hello,
    R.string.last_message_message_nice_to_meet_you,
    R.string.last_message_message_how_are_you,
    R.string.last_message_message_aloha,
    R.string.last_message_message_are_you_still_there,
    R.string.last_message_message_i_love_you,
    R.string.last_message_message_the_matrix_is_looking_for_you,
    R.string.last_message_message_i_am_robot
  ).shuffled()
  val lastContactTimes = listOf(
    TimeString("13:53"),
    TimeString("11:11"),
    TimeString("03:23"),
    TimeId(R.string.last_message_datetime_yesterday),
    TimeId(R.string.last_message_datetime_monday),
    TimeId(R.string.last_message_datetime_sunday),
    TimeString("2021/04/01"),
    TimeString("2021/01/01"),
    TimeString("2020/11/11"),
    TimeString("2020/02/14"),
  )
  val chatList = mutableListOf<Chat>()
  for (i in 0 until 10) {
    chatList.add(
      Chat(
        contact = contacts[i],
        lastMessageId = lastMessageIds[i],
        lastContactTime = lastContactTimes[i]
      )
    )
  }
  return chatList
}

data class Chat(
  val contact: Contact,
  @StringRes val lastMessageId: Int,
  val lastContactTime: LastContactTime
)

sealed class LastContactTime {
  data class TimeString(val time: String) : LastContactTime()
  data class TimeId(@StringRes val time: Int) : LastContactTime()
}
