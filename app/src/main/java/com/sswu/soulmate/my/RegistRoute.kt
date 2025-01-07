package com.sswu.soulmate.my

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.sswu.soulmate.R
import com.sswu.soulmate.component.SoulmateButton
import com.sswu.soulmate.ui.theme.BackgroundWhite
import com.sswu.soulmate.ui.theme.DarkBrown

@Composable
fun RegistRoute(
    paddingValues: PaddingValues,
    navigateToMy: () -> Unit
) {
    RegistScreen(paddingValues = paddingValues, navigateToMy = navigateToMy)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    navigateToMy: () -> Unit
) {
    val nameState = remember { mutableStateOf("") }
    val ageState = remember { mutableStateOf("") }
    val addressState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val instagramState = remember { mutableStateOf("") }
    val personalityState = remember { mutableStateOf("") }
    val soulmateDescriptionState = remember { mutableStateOf("") }

    val imageUri = remember { mutableStateOf<Uri?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            imageUri.value = uri
        }
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
                    .padding(horizontal = 30.dp)
                    .padding(bottom = 20.dp)
                    .background(BackgroundWhite, RoundedCornerShape(20.dp))
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = nameState.value,
                    onValueChange = { nameState.value = it },
                    label = { Text("이름") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = ageState.value,
                    onValueChange = { ageState.value = it },
                    label = { Text("나이") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { imagePickerLauncher.launch("image/*") }
                        .clip(CircleShape)
                ) {
                    imageUri.value?.let {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            painter = rememberImagePainter(it),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    } ?: Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(R.drawable.img_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = addressState.value,
                    onValueChange = { addressState.value = it },
                    label = { Text("주소") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = phoneState.value,
                    onValueChange = { phoneState.value = it },
                    label = { Text("전화번호") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = instagramState.value,
                    onValueChange = { instagramState.value = it },
                    label = { Text("인스타그램 아이디") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = personalityState.value,
                    onValueChange = { personalityState.value = it },
                    label = { Text("성격 설명") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    ),
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = soulmateDescriptionState.value,
                    onValueChange = { soulmateDescriptionState.value = it },
                    label = { Text("소울메이트 설명") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = DarkBrown,
                        unfocusedIndicatorColor = DarkBrown,
                        cursorColor = DarkBrown
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                )

                Spacer(modifier = Modifier.height(40.dp))

                SoulmateButton(
                    text = "저장",
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .clickable { navigateToMy() }
                )

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}


@Composable
@Preview
fun RegistScreenPreview() {
    RegistScreen(paddingValues = PaddingValues(), navigateToMy = {})
}
