package com.wavky.wechatdemo.ui.contacts

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wavky.wechatdemo.data.Contact
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.Sizes
import com.wavky.wechatdemo.ui.common.extension.toStringRes

/**
 * Created on 2021/08/30
 * @author Wavky.Huang
 */
@Composable
fun ContactItemView(contact: Contact) {
  Column(
    Modifier
      .height(60.dp)
      .fillMaxWidth()
  ) {
    Divider(thickness = Sizes.divider)
    Row(
      Modifier
        .padding(start = Sizes.defaultPadding)
        .weight(1f),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Image(
        painter = painterResource(id = contact.profileImageId),
        contentDescription = "profile image",
        Modifier
          .size(40.dp)
          .clip(RoundedCornerShape(CornerSize(4.dp)))
      )
      Spacer(modifier = Modifier.width(15.dp))
      Text(contact.nameId.toStringRes(), fontSize = 20.sp, maxLines = 1)
    }
  }
}

@Preview
@Composable
fun ContactItemViewPreview() {
  val contacts = getDefaultContactList().shuffled()
  Column(
    Modifier
      .background(Color.White)
      .fillMaxSize()
  ) {
    ContactItemView(contacts[0])
    ContactItemView(contacts[1])
    ContactItemView(contacts[2])
  }
}
