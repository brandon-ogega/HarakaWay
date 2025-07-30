package com.example.harakaway.ui.screens
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.harakaway.R
import com.example.harakaway.ui.theme.Teal


@Composable

fun LoginPage(innerPadding: PaddingValues) {
    val phoneNumber: MutableState<String> = remember {
        mutableStateOf("")
    }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()

    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = R.drawable.login2,
                contentDescription = "login",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(screenHeight*1/3)
                    .fillMaxWidth()
                    .blur(radius = 1.5.dp)
            )

            Column { Text(
                text = "Welcome!",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                color = Color.White
            )
                Text(
                    text = "Create Account",
                    fontWeight = FontWeight.Light,
                    fontSize = 24.sp,
                    color = Color.White
                ) }
        }

        Card(
            colors = CardColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContainerColor = Color.LightGray,
                disabledContentColor = Color.DarkGray,
            ),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {


                Spacer(modifier = Modifier.padding(vertical = 4.dp) )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    TextField(
                        value = phoneNumber.value,
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.LightGray,
                            unfocusedContainerColor = Color.LightGray,
                            errorContainerColor = Color.Red,
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray,
                            focusedLeadingIconColor = Color.LightGray,
                            unfocusedLeadingIconColor = Color.LightGray,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 8.dp)
                            .clip(RoundedCornerShape(24.dp)),
                        placeholder = {
                            Text(
                                text = "Enter phone number",
                                fontSize = 16.sp,
                                color = Color.DarkGray
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = "add number",
                                tint = Color.DarkGray
                            )
                        },
                        onValueChange = { newValue ->
                            phoneNumber.value = newValue
                        }
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonColors(
                            containerColor = Teal,
                            contentColor = Color.White,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.DarkGray
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                    ) {
                        Text(
                            text = "Sign up",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 1.dp, horizontal = 16.dp)
                ) {
                    Text(
                        text = "Already have an account? Login",
                        color = Color.Black,
                        fontWeight = FontWeight.Light,
                        modifier = Modifier.clickable(onClick = {

                        })
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    HorizontalDivider(
                        color = Color.LightGray,
                        thickness = 0.5.dp,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Button(
                        colors = ButtonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color.Black,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.google),
                            contentDescription = null,
                            tint = Color.Unspecified,
                            modifier = Modifier.size(24.dp),


                            )
                        Text(
                            text = "Sign in with Google",
                            color = Color.Black,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                        )
                    }

                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Button(
                        colors = ButtonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color.Black,
                            disabledContentColor = Color.LightGray,
                            disabledContainerColor = Color.DarkGray,
                        ),
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    ) {
                        Text(
                            text = "Continue as Guest",
                            color = Color.Black,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                        )
                    }

                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "By signing up,you agree to the Terms & Conditions " +
                                "and Privacy Policy",
                        color = Color.LightGray,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)
                    )
                }
            }
        }
    }
}
