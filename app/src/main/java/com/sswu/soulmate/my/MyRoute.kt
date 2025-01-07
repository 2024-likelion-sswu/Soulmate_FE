package com.sswu.soulmate.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sswu.soulmate.R
import com.sswu.soulmate.ui.theme.BackgroundWhite

@Composable
fun MyRoute(
    paddingValues: PaddingValues,
) {
    MyScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun MyScreen(
    paddingValues: PaddingValues,
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
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 20.dp)
                    .background(BackgroundWhite, RoundedCornerShape(20.dp)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "이름",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 25.sp
                    )
                )

                Text(
                    text = "나이",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))

                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    painter = painterResource(R.drawable.img_background),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = "주소",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "전화번호",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "인스타그램 아이디",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "성격",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Text(
                    text = "성격을 한 문장으로 설명",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_light)),
                        fontSize = 12.sp
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "소울메이트",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                        fontSize = 12.sp
                    )
                )

                Text(
                    text = "소울메이트 성격을 한 문장으로 설명",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_light)),
                        fontSize = 12.sp
                    )
                )
            }
        }
    }
}

@Composable
@Preview
fun MyScreenpreview() {
    MyScreen(
        paddingValues = PaddingValues(),
    )
}
