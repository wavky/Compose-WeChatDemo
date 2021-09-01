package com.wavky.wechatdemo.ui.chats.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.ui.common.resource.Colors
import com.wavky.wechatdemo.ui.common.resource.Sizes

/**
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
@Composable
fun ChatInputView(onSend: (String) -> Unit) {
  var message: String by remember { mutableStateOf("") }

  Row(
    Modifier
      .fillMaxWidth()
      .background(Colors.tabBarGray)
      .padding(8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(
      painterResource(R.drawable.ic_speaker),
      contentDescription = "speaker button",
      Modifier
        .padding(end = Sizes.itemSpacing)
        .size(28.dp)
    )
    BasicTextField(
      value = message,
      onValueChange = { message = it },
      Modifier
        .padding(end = Sizes.itemSpacing)
        .weight(1f)
        .background(Color.White, RoundedCornerShape(CornerSize(4.dp)))
        .padding(8.dp),
      textStyle = TextStyle.Default.copy(fontSize = Sizes.fontItemTitle),
      cursorBrush = SolidColor(Colors.weChatGreen),
      keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
      keyboardActions = KeyboardActions(onSend = {
        onSend(message)
        message = ""
      })
    )
    Icon(
      painterResource(R.drawable.ic_face),
      contentDescription = "face button",
      Modifier
        .padding(end = Sizes.itemSpacing)
        .size(28.dp)
    )
    Icon(
      painterResource(R.drawable.ic_add_s),
      contentDescription = "add button",
      Modifier.size(28.dp)
    )
  }
}

@Preview
@Composable
fun ChatInputViewPreview() {
  ChatInputView() {}
}
