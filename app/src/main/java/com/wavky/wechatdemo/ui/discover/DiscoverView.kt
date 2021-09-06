package com.wavky.wechatdemo.ui.discover

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.wavky.wechatdemo.ui.Tabs
import com.wavky.wechatdemo.ui.common.ItemSpacer
import com.wavky.wechatdemo.ui.common.TopBar
import com.wavky.wechatdemo.ui.common.resource.Colors
import com.wavky.wechatdemo.ui.common.toItemView
import com.wavky.wechatdemo.ui.discover.data.DiscoverItemName.*
import com.wavky.wechatdemo.ui.discover.data.getDiscoverItems

/**
 * Created on 2021/08/30
 * @author Wavky.Huang
 */
@Composable
fun DiscoverView(modifier: Modifier = Modifier) {
  Scaffold(
    modifier,
    topBar = { TopBar(Tabs.DISCOVER.textId) }
  ) {
    val items = getDiscoverItems()

    Column(
      Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        .background(Colors.topBarGray)
    ) {
      items[Moments]?.toItemView()
      ItemSpacer()
      items[Channels]?.toItemView(withDivider = true)
      items[Live]?.toItemView()
      ItemSpacer()
      items[Scan]?.toItemView(withDivider = true)
      items[Shake]?.toItemView()
      ItemSpacer()
      items[TopStories]?.toItemView(withDivider = true)
      items[Search]?.toItemView()
      ItemSpacer()
      items[Nearby]?.toItemView()
      ItemSpacer()
      items[MiniPrograms]?.toItemView()
      ItemSpacer()
    }
  }
}

@Preview
@Composable
fun DiscoverViewPreview() {
  DiscoverView(Modifier.fillMaxSize())
}
