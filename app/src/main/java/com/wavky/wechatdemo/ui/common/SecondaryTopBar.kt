package com.wavky.wechatdemo.ui.common

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.ui.common.extension.toStringRes
import com.wavky.wechatdemo.ui.common.resource.Colors

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
@Composable
fun SecondaryTopBar(@StringRes titleId: Int, onClickBack: () -> Unit) {
  Box(
    Modifier
      .fillMaxWidth()
      .height(48.dp)
      .background(Colors.topBarGray),
    Alignment.Center
  ) {
    Text(
      titleId.toStringRes(),
      fontSize = 18.sp,
      maxLines = 1
    )
    Row(
      Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
    ) {
      val iconSize = 22.dp
      Icon(
        painter = painterResource(R.drawable.ic_left),
        contentDescription = "back button",
        Modifier
          .clickable { onClickBack() }
          .size(iconSize)
      )
      ExpandedSpacer()
      Icon(
        painter = painterResource(R.drawable.ic_more),
        contentDescription = "more button",
        Modifier.size(iconSize)
      )
    }
  }
}

@Preview
@Composable
fun SecondaryTopBarPreview() {
  SecondaryTopBar(R.string.app_name) {}
}
