package com.wavky.wechatdemo.ui.me

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.ui.Colors
import com.wavky.wechatdemo.ui.common.ItemSpacer
import com.wavky.wechatdemo.ui.common.toItemView
import com.wavky.wechatdemo.ui.me.data.MeItemName.*
import com.wavky.wechatdemo.ui.me.data.getMeItems

/**
 * Created on 2021/08/31
 * @author Wavky.Huang
 */
@Composable
fun MeView(modifier: Modifier = Modifier, onClickProfilePanel: () -> Unit) {
  val items = getMeItems()

  Column(
    modifier
      .verticalScroll(rememberScrollState())
      .background(Colors.topBarGray)
  ) {
    MyProfileView(Modifier.clickable(role = Role.Image) { onClickProfilePanel() })
    ItemSpacer()
    items[Pay]?.toItemView()
    ItemSpacer()
    items[Favorites]?.toItemView(withDivider = true)
    items[Moments]?.toItemView(withDivider = true)
    items[Channels]?.toItemView(withDivider = true)
    items[Cards]?.toItemView(withDivider = true)
    items[Sticker]?.toItemView()
    ItemSpacer()
    items[Settings]?.toItemView()
    ItemSpacer()
  }
}

@Preview
@Composable
fun MeViewPreview() {
  MeView(Modifier.fillMaxSize()) {}
}
