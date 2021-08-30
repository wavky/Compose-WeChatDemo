package com.wavky.wechatdemo.ui.discover.data

import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.Colors
import com.wavky.wechatdemo.ui.common.ItemInfo
import com.wavky.wechatdemo.ui.discover.data.DiscoverItemName.*

/**
 * Created on 2021/08/30
 * @author Wavky.Huang
 */
fun getDiscoverItems(): Map<DiscoverItemName, ItemInfo> {
  val contacts = getDefaultContactList().shuffled()
  return mapOf(
    Moments to ItemInfo(
      iconId = R.drawable.ic_moments,
      iconColor = null,
      titleId = R.string.discover_moments,
      nameId = null,
      profileImageId = contacts[0].profileImageId
    ),
    Channels to ItemInfo(
      iconId = R.drawable.ic_discover_channels,
      iconColor = Colors.Discover.channelsOrange,
      titleId = R.string.discover_channels,
      nameId = contacts[1].nameId,
      profileImageId = contacts[1].profileImageId
    ),
    Live to ItemInfo(
      iconId = R.drawable.ic_discover_live,
      iconColor = Colors.Discover.liveRed,
      titleId = R.string.discover_live,
      nameId = R.string.discover_live_on_air,
      profileImageId = contacts[2].profileImageId
    ),
    Scan to ItemInfo(
      iconId = R.drawable.ic_discover_scan,
      iconColor = Colors.Discover.scanBlue,
      titleId = R.string.discover_scan,
      nameId = null,
      profileImageId = null
    ),
    Shake to ItemInfo(
      iconId = R.drawable.ic_discover_shake,
      iconColor = Colors.Discover.shakeBlue,
      titleId = R.string.discover_shake,
      nameId = null,
      profileImageId = null
    ),
    TopStories to ItemInfo(
      iconId = R.drawable.ic_discover_top_stories,
      iconColor = Colors.Discover.topStoriesYellow,
      titleId = R.string.discover_top_stories,
      nameId = null,
      profileImageId = null
    ),
    Search to ItemInfo(
      iconId = R.drawable.ic_discover_search,
      iconColor = Colors.Discover.searchRed,
      titleId = R.string.discover_search,
      nameId = null,
      profileImageId = null
    ),
    Nearby to ItemInfo(
      iconId = R.drawable.ic_discover_nearby,
      iconColor = Colors.Discover.nearbyBlue,
      titleId = R.string.discover_nearby,
      nameId = null,
      profileImageId = null
    ),
    MiniPrograms to ItemInfo(
      iconId = R.drawable.ic_discover_mini_programs,
      iconColor = Colors.Discover.miniProgramsPurple,
      titleId = R.string.discover_mini_programs,
      nameId = null,
      profileImageId = null
    ),
  )
}

enum class DiscoverItemName {
  Moments, Channels, Live, Scan,
  Shake, TopStories, Search, Nearby,
  MiniPrograms
}
