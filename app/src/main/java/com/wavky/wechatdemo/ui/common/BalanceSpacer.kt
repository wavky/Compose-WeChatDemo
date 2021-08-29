package com.wavky.wechatdemo.ui.common

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
@Composable
fun ColumnScope.BalanceSpacer() {
  Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun RowScope.BalanceSpacer() {
  Spacer(modifier = Modifier.weight(1f))
}
