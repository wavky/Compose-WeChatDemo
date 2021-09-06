package com.wavky.wechatdemo.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wavky.wechatdemo.R
import com.wavky.wechatdemo.ui.common.resource.Colors

/**
 * Created on 2021/08/28
 * @author Wavky.Huang
 */
@Composable
fun TabBar(selecting: Tabs, modifier: Modifier = Modifier, onTabClick: (Tabs) -> Unit) {
  // 消除 Material 组件自带的 Ripple 动画效果
  // https://stackoverflow.com/a/68853697/3113620
  CompositionLocalProvider(LocalRippleTheme provides NoRippleTheme) {
    TabRow(
      selectedTabIndex = selecting.ordinal,
      modifier = modifier,
      indicator = {}, // 消除底部的指示游标
      divider = {},
      backgroundColor = Colors.tabBarGray
    ) {
      for (tab in Tabs.values()) {
        // 单独对组件应用颜色而非通过 Tab 参数传递，消除自带的颜色渐变动画
        val tabColor = tab.currentStateColor(selecting)
        Tab(
          selected = selecting == tab,
          modifier = Modifier.padding(vertical = 8.dp),
          onClick = { onTabClick(tab) }) {
          // 通过 lambda 自定义内容形式，可以手动控制 padding
          Icon(
            painter = painterResource(id = tab.currentStateIconId(selecting)),
            contentDescription = "tab icon",
            tint = tabColor,
          )
          Text(
            text = stringResource(id = tab.textId),
            fontWeight = FontWeight.Light,
            maxLines = 1,
            color = tabColor,
          )
        }
      }
    }
  }
}

private object NoRippleTheme : RippleTheme {
  @Composable
  override fun defaultColor() = Color.Unspecified

  @Composable
  override fun rippleAlpha(): RippleAlpha = RippleAlpha(0.0f, 0.0f, 0.0f, 0.0f)
}

enum class Tabs(val iconId: IconId, @StringRes val textId: Int) {
  CHATS(
    iconId = IconId(on = R.drawable.ic_chats_fill, off = R.drawable.ic_chats_outline),
    textId = R.string.tabs_chat
  ),
  CONTACTS(
    iconId = IconId(on = R.drawable.ic_contacts_fill, off = R.drawable.ic_contacts_outline),
    textId = R.string.tabs_contacts
  ),
  DISCOVER(
    iconId = IconId(on = R.drawable.ic_discover_fill, off = R.drawable.ic_discover_outline),
    textId = R.string.tabs_discover
  ),
  ME(
    iconId = IconId(on = R.drawable.ic_me_fill, off = R.drawable.ic_me_outline),
    textId = R.string.tabs_me
  );

  data class IconId(
    @DrawableRes val on: Int,
    @DrawableRes val off: Int,
  )

  @DrawableRes
  fun currentStateIconId(selecting: Tabs): Int =
    if (selecting == this) iconId.on else iconId.off

  fun currentStateColor(selecting: Tabs): Color =
    if (selecting == this) Colors.weChatGreen else Color.Gray
}

@Preview
@Composable
fun TabBarPreview() {
  TabBar(selecting = Tabs.CONTACTS, Modifier.width(300.dp)) {}
}
