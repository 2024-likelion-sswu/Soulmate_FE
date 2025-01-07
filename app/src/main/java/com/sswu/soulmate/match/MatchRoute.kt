package com.sswu.soulmate.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sswu.soulmate.R
import com.sswu.soulmate.component.SoulmateButton
import com.sswu.soulmate.ui.theme.BackgroundWhite

@Composable
fun MatchRoute(
    paddingValues: PaddingValues,
    navigateToMatchResult: () -> Unit
) {
    MatchScreen(
        paddingValues = paddingValues,
        navigateToTest = navigateToMatchResult
    )
}

@Composable
fun MatchScreen(
    paddingValues: PaddingValues,
    navigateToTest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.img_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 70.dp),
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 50.dp)
                    .padding(bottom = 20.dp)
                    .background(BackgroundWhite, RoundedCornerShape(20.dp)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "새로운\n소울메이트를 만나요",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "다양한 사람들이 기다리고 있어요",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Spacer(modifier = Modifier.height(100.dp))


                SoulmateButton(text = "만나러 가기", modifier = Modifier.clickable { navigateToTest() })
            }
        }
    }
}

@Composable
@Preview
fun MatchScreenpreview() {
    MatchScreen(
        paddingValues = PaddingValues(),
        navigateToTest = {}
    )
}
