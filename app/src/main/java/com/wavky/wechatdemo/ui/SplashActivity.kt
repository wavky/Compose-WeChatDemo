package com.wavky.wechatdemo.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 无视图欢迎界面
 *
 * ```
 * 底图使用 theme 主题设置中的 windowBackground 属性图。
 * 用于缓冲加载 application 主题中的 fullscreen(无状态栏) 和导航栏黑色底色设置。
 *
 * （测试设备中，仅设置 windowBackground 的话，在欢迎界面中会加载第一个 Activity 的 theme，
 * 若首个 Activity 设定为 MainActivity 则无法实现状态栏与导航栏隐藏效果）
 * ```
 * Created on 2021/09/01
 * @author Wavky.Huang
 */
@FlowPreview
@ObsoleteCoroutinesApi
class SplashActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    lifecycleScope.launch {
      delay(1000)
      startActivity(Intent(applicationContext, MainActivity::class.java))
      finish()
    }
  }
}
