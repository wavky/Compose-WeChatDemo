package com.wavky.wechatdemo.ui.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.data.getDefaultContactList
import com.wavky.wechatdemo.ui.common.extension.MaskPattern
import com.wavky.wechatdemo.ui.common.extension.maskedBy
import com.wavky.wechatdemo.ui.common.extension.toStringRes
import com.wavky.wechatdemo.ui.common.resource.Colors
import com.wavky.wechatdemo.ui.common.resource.Sizes

/**
 * Created on 2021/08/30
 * @author Wavky.Huang
 */
@Composable
fun ItemView(itemInfo: ItemInfo, withDivider: Boolean, withBadge: Boolean) {
  Row(
    Modifier
      .fillMaxWidth()
      .height(65.dp)
      .background(Color.White)
      .clickable { }
      .padding(horizontal = Sizes.defaultPadding),
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconView(itemInfo.iconId, itemInfo.iconPattern)
    Spacer(Modifier.width(Sizes.defaultPadding))
    Column {
      ExpandedSpacer()
      Row(verticalAlignment = Alignment.CenterVertically) {
        Text(itemInfo.titleId.toStringRes(), fontSize = Sizes.fontItemTitle, maxLines = 1)
        ExpandedSpacer()
        itemInfo.nameId?.toStringRes()?.let { name ->
          Text(
            name,
            Modifier.padding(horizontal = Sizes.itemSpacing),
            fontSize = Sizes.fontItemSubTitle,
            maxLines = 1,
            color = Color.Gray
          )
        }
        itemInfo.profileImageId?.let { imageId ->
          BadgedDecorator(withBadge) {
            Image(
              painterResource(imageId), contentDescription = "profile image",
              Modifier
                .padding(end = 4.dp)
                .size(40.dp)
                .clip(CircleShape)
            )
          }
        }
        Icon(
          painterResource(R.drawable.ic_right),
          contentDescription = "arrow icon",
          tint = Color.LightGray
        )
      }
      ExpandedSpacer()
      if (withDivider) {
        Divider(thickness = Sizes.divider)
      }
    }
  }
}

@Composable
private fun IconView(@DrawableRes imageId: Int, iconPattern: MaskPattern?) {
  fun createModifier(): Modifier {
    val instance = Modifier.size(30.dp)
    return if (iconPattern != null) instance.maskedBy(iconPattern) else instance
  }

  val modifier = remember { createModifier() }

  Icon(
    painterResource(imageId),
    contentDescription = "icon",
    modifier
  )
}

data class ItemInfo(
  @DrawableRes val iconId: Int,
  val iconPattern: MaskPattern?,
  @StringRes val titleId: Int,
  @StringRes val nameId: Int?,
  @DrawableRes val profileImageId: Int?,
)

@Composable
fun ItemInfo.toItemView(withDivider: Boolean = false, withBadge: Boolean = true) {
  ItemView(itemInfo = this, withDivider = withDivider, withBadge = withBadge)
}

@Preview
@Composable
fun ItemViewPreview() {
  val contacts = getDefaultContactList().shuffled()
  val itemInfos = listOf(
    ItemInfo(
      iconId = R.drawable.ic_discover_moments,
      iconPattern = MaskPattern.GradientPattern(
        Brush.sweepGradient(
          listOf(
            Colors.Discover.Moments.blue,
            Colors.Discover.Moments.green,
            Colors.Discover.Moments.yellow,
            Colors.Discover.Moments.red,
            Colors.Discover.Moments.blue,
          )
        )
      ),
      titleId = R.string.tabs_chat,
      nameId = contacts[0].nameId,
      profileImageId = contacts[0].profileImageId
    ),
    ItemInfo(
      iconId = R.drawable.ic_discover_channels,
      iconPattern = MaskPattern.ColorPattern(Colors.Discover.channelsOrange),
      titleId = R.string.tabs_contacts,
      nameId = null,
      profileImageId = contacts[1].profileImageId
    ),
    ItemInfo(
      iconId = R.drawable.ic_discover_live,
      iconPattern = MaskPattern.ColorPattern(Colors.Discover.liveRed),
      titleId = R.string.tabs_discover,
      nameId = null,
      profileImageId = null
    )
  )
  Column(
    Modifier
      .fillMaxSize()
      .background(Color.White)
  ) {
    for (index in 0..2) {
      itemInfos[index].toItemView(withDivider = true)
    }
  }
}
