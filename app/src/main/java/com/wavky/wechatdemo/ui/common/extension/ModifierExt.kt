package com.wavky.wechatdemo.ui.common.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import com.wavky.wechatdemo.ui.common.extension.MaskPattern.ColorPattern
import com.wavky.wechatdemo.ui.common.extension.MaskPattern.GradientPattern

/**
 * Created on 2021/09/06
 * @author Wavky.Huang
 */
fun Modifier.maskedBy(maskPattern: MaskPattern, blendMode: BlendMode = BlendMode.SrcIn): Modifier =
  this.drawWithContent {
    drawIntoCanvas { canvas ->
      canvas.saveLayer(Rect(Offset.Zero, size), Paint())
      drawContent()
      when (maskPattern) {
        is ColorPattern -> {
          drawRect(maskPattern.color, blendMode = blendMode)
        }
        is GradientPattern -> {
          drawRect(maskPattern.gradient, blendMode = blendMode)
        }
      }
      canvas.restore()
    }
  }

sealed class MaskPattern {
  data class ColorPattern(val color: Color) : MaskPattern()
  data class GradientPattern(val gradient: Brush) : MaskPattern()
}
