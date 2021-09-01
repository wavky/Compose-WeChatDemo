package com.wavky.wechatdemo.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.wavky.wechatdemo.R
import kotlinx.parcelize.Parcelize

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
fun getDefaultContactList(): List<Contact> =
  Friends.values().map { it.contact }

@Parcelize
data class Contact(
  @DrawableRes val profileImageId: Int,
  @StringRes val nameId: Int
) : Parcelable

enum class Friends(val contact: Contact) {
  Antony(
    Contact(profileImageId = R.drawable.avatar01, nameId = R.string.contact_name_antony)
  ),
  Apple(
    Contact(profileImageId = R.drawable.avatar02, nameId = R.string.contact_name_apple)
  ),
  Bosco(
    Contact(profileImageId = R.drawable.avatar03, nameId = R.string.contact_name_bosco)
  ),
  Joe(
    Contact(profileImageId = R.drawable.avatar04, nameId = R.string.contact_name_joe)
  ),
  Microsoft(
    Contact(profileImageId = R.drawable.avatar05, nameId = R.string.contact_name_microsoft)
  ),
  Muraosa(
    Contact(profileImageId = R.drawable.avatar06, nameId = R.string.contact_name_muraosa)
  ),
  Ron(
    Contact(profileImageId = R.drawable.avatar07, nameId = R.string.contact_name_ron)
  ),
  Saha(
    Contact(profileImageId = R.drawable.avatar08, nameId = R.string.contact_name_saha)
  ),
  Sony(
    Contact(profileImageId = R.drawable.avatar09, nameId = R.string.contact_name_sony)
  ),
  UncleWang(
    Contact(profileImageId = R.drawable.avatar10, nameId = R.string.contact_name_unclewang)
  );
}
