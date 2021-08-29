package com.wavky.wechatdemo.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
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

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
@Composable
fun TopBar(@StringRes titleId: Int) {
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
        .padding(horizontal = 16.dp),
      horizontalArrangement = Arrangement.End
    ) {
      val iconSize = 22.dp
      Icon(
        painter = painterResource(R.drawable.ic_search),
        contentDescription = "search button",
        Modifier
          .padding(end = 16.dp)
          .size(iconSize)
      )
      Icon(
        painter = painterResource(R.drawable.ic_add),
        contentDescription = "add button",
        Modifier.size(iconSize)
      )
    }
  }
}


@Preview
@Composable
fun TopBarPreview() {
  TopBar(R.string.app_name)
}
