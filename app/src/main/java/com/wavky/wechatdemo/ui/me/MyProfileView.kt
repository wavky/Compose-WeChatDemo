package com.wavky.wechatdemo.ui.me

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.data.MyProfile
import com.wavky.wechatdemo.ui.Sizes
import com.wavky.wechatdemo.ui.common.ExpandedSpacer
import com.wavky.wechatdemo.ui.common.extension.toStringRes

/**
 * Created on 2021/08/31
 * @author Wavky.Huang
 */
@Composable
fun MyProfileView(modifier: Modifier = Modifier) {
  val profile = MyProfile()

  Row(
    modifier
      .fillMaxWidth()
      .background(Color.White)
      .padding(
        start = Sizes.defaultPadding,
        end = Sizes.defaultPadding,
        top = 20.dp,
        bottom = 36.dp
      ),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      painterResource(profile.profileImageId),
      contentDescription = "profile image",
      Modifier
        .padding(start = 10.dp, end = 16.dp)
        .size(70.dp)
        .clip(RoundedCornerShape(CornerSize(8.dp)))

    )
    Column(Modifier.offset(0.dp, 16.dp)) {
      Text(
        profile.nameId.toStringRes(),
        Modifier.padding(bottom = 10.dp),
        fontSize = 20.sp
      )
      Text(
        R.string.my_profile_wechat_id.toStringRes() + profile.weChatId,
        Modifier.padding(bottom = 10.dp),
        fontSize = Sizes.fontItemSubTitle,
        color = Color.Gray,
        maxLines = 1
      )
      Text(
        "＋ ${R.string.my_profile_status.toStringRes()}",
        Modifier
          .drawBehind {
            drawRoundRect(
              Color.Gray,
              style = Stroke(0.5f),
              cornerRadius = CornerRadius(center.y)
            )
          }
          .padding(all = 2.dp)
          .padding(end = 4.dp),
        fontSize = Sizes.fontItemSubTitle,
        fontWeight = FontWeight.Light,
        color = Color.Gray
      )
    }
    ExpandedSpacer()
    Row(Modifier.offset(0.dp, 20.dp), verticalAlignment = Alignment.CenterVertically) {
      Icon(
        painterResource(R.drawable.ic_myprofile_qrcode_icon),
        contentDescription = "qr code icon",
        Modifier.size(18.dp),
        tint = Color.Gray
      )
      Icon(
        painterResource(R.drawable.ic_right),
        contentDescription = "arrow icon",
        tint = Color.LightGray
      )
    }
  }
}

@Preview
@Composable
fun MyProfileViewPreview() {
  Row(Modifier.fillMaxSize(1f)) {
    MyProfileView()
  }
}
