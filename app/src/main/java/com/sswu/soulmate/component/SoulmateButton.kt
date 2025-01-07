package com.sswu.soulmate.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sswu.soulmate.R

@Composable
fun SoulmateButton(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = TextStyle(
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
            fontSize = 14.sp,
            color = White,
            textAlign = TextAlign.Center
        ),
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(DarkGray)
            .padding(vertical = 5.dp, horizontal = 15.dp)
    )
}
