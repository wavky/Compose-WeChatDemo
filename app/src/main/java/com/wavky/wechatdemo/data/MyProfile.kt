package com.wavky.wechatdemo.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.wavky.wechatdemo.R

/**
 * Created on 2021/08/31
 * @author Wavky.Huang
 */
data class MyProfile(
  @DrawableRes val profileImageId: Int = R.drawable.avatar_me,
  @DrawableRes val qrcodeImageId: Int = R.drawable.myprofile_qrcode,
  @StringRes val nameId: Int = R.string.my_profile_name,
  val weChatId: String = "Wavky_Huang"
)
