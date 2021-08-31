package com.wavky.wechatdemo.ui.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.ui.common.SecondaryTopBar
import com.wavky.wechatdemo.ui.common.resource.Colors

/**
 * Created on 2021/08/31
 * @author Wavky.Huang
 */
@Composable
fun QrCodeView(modifier: Modifier = Modifier, onClickBack: () -> Unit) {
  Scaffold(
    modifier,
    topBar = { SecondaryTopBar(R.string.qr_code_title, onClickBack) }
  ) {
    Box(
      Modifier
        .fillMaxSize()
        .background(Colors.backgroundGray)
        .padding(all = 20.dp),
      contentAlignment = Alignment.Center
    ) {
      Image(
        painterResource(R.drawable.myprofile_qrcode),
        contentDescription = "my qr code image",
        Modifier.clip(RoundedCornerShape(CornerSize(8.dp)))
      )
    }
  }
}

@Preview
@Composable
fun QrCodeViewPreview() {
  QrCodeView(Modifier.fillMaxSize()) {}
}
