package com.sswu.soulmate.test

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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

@Composable
fun TestRoute(
    paddingValues: PaddingValues,
) {
    TestScreen(
        paddingValues = paddingValues
    )
}

@Composable
fun TestScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {
    val selectedOptions = remember { mutableStateListOf<Option?>(null, null, null, null, null) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.img_background),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        val questions = listOf(
            "한 달에 최소 2번은 만나야 됨" to "바쁘면 일 년에 한두 번만 봐도 됨",
            "시간 약속은 칼같이 지켜야 한다" to "놀려고 만나는 건데 유동적으로",
            "욕하고 디스하는 게 진짜 우정이다" to "아무리 친해도 막 대하는 건 싫다",
            "개그 취향이 비슷했으면 좋겠다" to "문화 취향이 비슷했으면 좋겠다",
            "친구의 친구도 소개받고 싶다" to "친구와 나, 독립된 관계가 좋다"
        )

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(questions.size) { index ->
                    QuestionItem(
                        questionIndex = index + 1,
                        optionA = questions[index].first,
                        optionB = questions[index].second,
                        selectedOption = selectedOptions[index],
                        onOptionSelected = { option ->
                            selectedOptions[index] = option
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.padding(bottom = 50.dp))
                    SoulmateButton("테스트 결과")
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun QuestionItem(
    questionIndex: Int,
    optionA: String,
    optionB: String,
    selectedOption: Option?,
    onOptionSelected: (Option) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = "질문 $questionIndex",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                fontSize = 16.sp,
                color = Color.Black
            )
        )

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TestButton(
                text = optionA,
                isSelected = selectedOption == Option.A,
                modifier = Modifier.weight(1f),
                onClick = { onOptionSelected(Option.A) }
            )

            Spacer(modifier = Modifier.width(16.dp))

            TestButton(
                text = optionB,
                isSelected = selectedOption == Option.B,
                modifier = Modifier.weight(1f),
                onClick = { onOptionSelected(Option.B) }
            )
        }
    }
}

@Composable
fun TestButton(
    text: String,
    isSelected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .border(
                border = BorderStroke(
                    1.dp,
                    if (isSelected) Color.DarkGray else Color.LightGray
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(if (isSelected) Color.DarkGray else Color.Transparent)
            .clickable { onClick() }
            .padding(vertical = 8.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.pretendard_light)),
                fontSize = 14.sp,
                color = if (isSelected) Color.White else Color.Black,
                textAlign = TextAlign.Center
            )
        )
    }
}

enum class Option {
    A, B
}

@Preview
@Composable
fun TestScreenPreview() {
    TestScreen(
        paddingValues = PaddingValues()
    )
}
