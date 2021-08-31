package com.wavky.wechatdemo.ui.me.data

import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.ui.common.ItemInfo
import com.wavky.wechatdemo.ui.common.resource.Colors
import com.wavky.wechatdemo.ui.me.data.MeItemName.*

/**
 * Created on 2021/08/31
 * @author Wavky.Huang
 */
fun getMeItems(): Map<MeItemName, ItemInfo> =
  mapOf(
    Pay to ItemInfo(
      iconId = R.drawable.ic_me_pay,
      iconColor = Colors.Me.payGreen,
      titleId = R.string.me_pay,
      nameId = null,
      profileImageId = null
    ),
    Favorites to ItemInfo(
      iconId = R.drawable.ic_me_favorites,
      iconColor = Colors.Me.favoritesRed,
      titleId = R.string.me_favorites,
      nameId = null,
      profileImageId = null
    ),
    Moments to ItemInfo(
      iconId = R.drawable.ic_me_moments,
      iconColor = Colors.Me.momentsBlue,
      titleId = R.string.me_moments,
      nameId = null,
      profileImageId = null
    ),
    Channels to ItemInfo(
      iconId = R.drawable.ic_me_channels,
      iconColor = Colors.Me.channelsOrange,
      titleId = R.string.me_channels,
      nameId = null,
      profileImageId = null
    ),
    Cards to ItemInfo(
      iconId = R.drawable.ic_me_cards,
      iconColor = Colors.Me.cardsBlue,
      titleId = R.string.me_cards,
      nameId = null,
      profileImageId = null
    ),
    Sticker to ItemInfo(
      iconId = R.drawable.ic_me_sticker,
      iconColor = Colors.Me.stickerYellow,
      titleId = R.string.me_sticker,
      nameId = null,
      profileImageId = null
    ),
    Settings to ItemInfo(
      iconId = R.drawable.ic_me_settings,
      iconColor = Colors.Me.settingsBlue,
      titleId = R.string.me_settings,
      nameId = null,
      profileImageId = null
    ),
  )

enum class MeItemName {
  Pay, Favorites, Moments, Channels,
  Cards, Sticker, Settings
}
