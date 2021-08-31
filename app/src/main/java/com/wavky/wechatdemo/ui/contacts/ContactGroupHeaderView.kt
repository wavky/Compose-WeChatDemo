package com.wavky.wechatdemo.ui.contacts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.common.resource.Colors
import com.wavky.wechatdemo.ui.common.resource.Sizes

/**
 * Created on 2021/08/30
 * @author Wavky.Huang
 */
@Composable
fun ContactGroupHeaderView(groupName: String) {
  Row(
    Modifier
      .fillMaxWidth()
      .height(30.dp)
      .background(Colors.topBarGray),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(groupName, Modifier.padding(start = Sizes.defaultPadding))
  }
}

@Preview
@Composable
fun ContactGroupHeaderViewPreview() {
  val contacts = getDefaultContactList()
  Column(
    Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    ContactGroupHeaderView(groupName = "A")
    ContactItemView(contact = contacts[0])
    ContactGroupHeaderView(groupName = "B")
    ContactItemView(contact = contacts[1])
    ContactItemView(contact = contacts[2])
    ContactGroupHeaderView(groupName = "C")
    ContactItemView(contact = contacts[3])
  }
}
