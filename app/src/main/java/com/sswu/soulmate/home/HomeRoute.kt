package com.sswu.soulmate.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sswu.soulmate.R
import com.sswu.soulmate.ui.theme.DarkBrown

@Composable
fun HomeRoute(
    paddingValues: PaddingValues
) {
    HomeScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val reviews = listOf(
        Pair("김민수", "이 앱에서 만난 친구와 매주 독서 모임을 하고 있어요. 정말 유용한 앱이에요!"),
        Pair("이수지", "여행을 좋아하는 사람들과 매칭되어 주말마다 소소한 여행을 떠나요."),
        Pair("박지훈", "게임 취미가 맞는 사람을 만나 재미있게 시간 보내고 있습니다!"),
        Pair("최은영", "평소 소극적인 성격인데 이 앱 덕분에 다양한 사람을 만날 수 있었어요.")
    )

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
                    .background(White, RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        painter = painterResource(R.drawable.img_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(30.dp))
                    Column {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        fontFamily = FontFamily(Font(R.font.pretendard_extrabold)),
                                        fontSize = 20.sp
                                    )
                                ) {
                                    append("&&&님")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontFamily = FontFamily(Font(R.font.pretendard_light)),
                                        fontSize = 20.sp
                                    )
                                ) {
                                    append("반가워요!")
                                }
                            },
                            style = TextStyle(
                                textAlign = TextAlign.Center
                            )
                        )
                        Text(
                            text = "오늘도 함께 소울메이트를 찾아봐요",
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.pretendard_light)),
                                fontSize = 15.sp
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = "오늘의 추천 친구",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "&&&님과 어울리는 메이트를 찾았어요!",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_light)),
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 15.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(DarkBrown),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(10.dp))

                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        painter = painterResource(R.drawable.img_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "이름 | 나이",
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.pretendard_light)),
                            fontSize = 15.sp
                        ),
                        color = White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "사용자 후기",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                reviews.forEach { review ->
                    RecommandProfile(
                        name = review.first,
                        content = review.second,
                        isVisible = true
                    )
                }
            }
        }
    }
}

@Composable
fun RecommandProfile(name: String, content: String, isVisible: Boolean) {
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }),
        exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 })
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            colors = CardDefaults.cardColors(containerColor = DarkBrown),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = name,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_bold)),
                        fontSize = 14.sp
                    ),
                    color = White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = content,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.pretendard_extralight)),
                        fontSize = 12.sp
                    ),
                    color = White
                )
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenpreview() {
    HomeScreen(
        paddingValues = PaddingValues(),
    )
}
