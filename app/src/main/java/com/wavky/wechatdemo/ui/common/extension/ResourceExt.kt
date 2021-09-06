package com.wavky.wechatdemo.ui.common.extension

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * Created on 2021/08/29
 * @author Wavky.Huang
 */
@Composable
fun Int.toStringRes(): String = stringResource(id = this)
