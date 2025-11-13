package com.example.shopeapp.ui.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopeapp.common.LeadingIconInputField
import com.example.shopeapp.common.PrimaryButton
import com.example.shopeapp.ui.theme.DarkRed00
import com.example.shopeapp.ui.theme.Red1A
import com.example.shopeapp.ui.theme.Red3F
import com.example.shopeapp.ui.theme.WhiteFF
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.gotham_bold
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.ic_add_icon
import shopeapp.composeapp.generated.resources.ic_lock_icon
import shopeapp.composeapp.generated.resources.ic_person_icon
import shopeapp.composeapp.generated.resources.login
import shopeapp.composeapp.generated.resources.password
import shopeapp.composeapp.generated.resources.username


@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Red1A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "NeoSTORE",
                color = WhiteFF,
                fontSize = 135.sp / 3, // Approximate size
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(Res.font.gotham_bold))
            )
            Spacer(modifier = Modifier.height(148.dp / 2))

            LeadingIconInputField(
                value = username,
                onValueChange = { username = it },
                placeholder = Res.string.username,
                Res.drawable.ic_person_icon
            )
            Spacer(modifier = Modifier.height(20.dp))
            LeadingIconInputField(
                value = password,
                onValueChange = { password = it },
                placeholder = Res.string.password,
                Res.drawable.ic_lock_icon
            )

            Spacer(modifier = Modifier.height(100.dp/2))

            PrimaryButton(
                text = Res.string.login,
                onClick = { }
            )

            Spacer(modifier = Modifier.height(65.dp/2))
            Text(
                text = "Forgot Password?",
                color = WhiteFF,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(Res.font.gotham_medium))
            )
        }
        Row (modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 40.dp)
            .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "DON'T HAVE AN ACCOUNT?",
                color = WhiteFF,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(Res.font.gotham_medium))
            )
            Icon(
                painter = painterResource(Res.drawable.ic_add_icon),
                contentDescription = "Add Icon",
                tint = WhiteFF,
                modifier = Modifier.size(48.dp)
                    .background(DarkRed00)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen()
}

