package com.wavky.wechatdemo.ui.common

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.R

/**
 * Created on 2021/08/31
 * @author Wavky.Huang
 */
@Composable
fun BadgedDecorator(
  isBadgeVisible: Boolean = true,
  badgeSize: Dp = 12.dp,
  content: @Composable () -> Unit
) {
  Box(contentAlignment = Alignment.TopEnd) {
    content()
    if (isBadgeVisible) {
      Canvas(
        Modifier
          .size(badgeSize)
          .offset(badgeSize / 2, -(badgeSize / 2))
      ) {
        drawCircle(Color.Red)
      }
    }
  }
}

@Preview
@Composable
fun BadgeViewPreview() {
  Box(Modifier.size(100.dp), contentAlignment = Alignment.Center) {
    BadgedDecorator() {
      Image(
        painter = painterResource(R.drawable.avatar_me),
        contentDescription = "profile image",
        Modifier
          .size(60.dp)
          .clip(RoundedCornerShape(CornerSize(4.dp)))
      )
    }
  }
}
