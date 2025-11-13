package com.example.shopeapp.ui.auth.register

import androidx.compose.foundation.background
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopeapp.common.LeadingIconInputField
import com.example.shopeapp.common.MediumText
import com.example.shopeapp.common.PrimaryButton
import com.example.shopeapp.ui.theme.Red1A
import com.example.shopeapp.ui.theme.Red3F
import com.example.shopeapp.ui.theme.WhiteFF
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.agree_terms
import shopeapp.composeapp.generated.resources.back
import shopeapp.composeapp.generated.resources.confirm_password
import shopeapp.composeapp.generated.resources.email
import shopeapp.composeapp.generated.resources.female
import shopeapp.composeapp.generated.resources.first_name
import shopeapp.composeapp.generated.resources.gender
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.ic_arrow_back_icon
import shopeapp.composeapp.generated.resources.ic_lock_icon
import shopeapp.composeapp.generated.resources.ic_lock_open_icon
import shopeapp.composeapp.generated.resources.ic_mail_icon
import shopeapp.composeapp.generated.resources.ic_mobile_icon
import shopeapp.composeapp.generated.resources.ic_person_icon
import shopeapp.composeapp.generated.resources.last_name
import shopeapp.composeapp.generated.resources.male
import shopeapp.composeapp.generated.resources.neo_store
import shopeapp.composeapp.generated.resources.password
import shopeapp.composeapp.generated.resources.phone_number
import shopeapp.composeapp.generated.resources.register
import shopeapp.composeapp.generated.resources.register_button


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }
    var phoneNumber by remember { mutableStateOf("") }
    var agreeTerms by remember { mutableStateOf(false) }


    Column( modifier = Modifier
        .fillMaxSize()
        .background(Red1A),
        horizontalAlignment = Alignment.CenterHorizontally){

        Box(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 12.dp)
                .height(60.dp)
        ) {
            IconButton(onClick = { /* Handle back navigation */ },
                modifier = Modifier.align(Alignment.CenterStart)) {
                Icon(painter = painterResource(Res.drawable.ic_arrow_back_icon),
                    contentDescription = stringResource(Res.string.back),
                    tint = WhiteFF,
                    modifier = Modifier.size(20.dp))
            }
            Text(stringResource(Res.string.register),
                modifier = Modifier.align(Alignment.Center),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(Res.font.gotham_medium)),
                color = WhiteFF
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(Res.string.neo_store),
                color = WhiteFF,
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(40.dp))
            LeadingIconInputField(
                value = firstName,
                onValueChange = { firstName = it },
                placeholder = Res.string.first_name,
                leadingIcon = Res.drawable.ic_person_icon
            )
            Spacer(modifier = Modifier.height(20.dp))
            LeadingIconInputField(
                value = lastName,
                onValueChange = { lastName = it },
                placeholder = Res.string.last_name,
                leadingIcon = Res.drawable.ic_person_icon
            )
            Spacer(modifier = Modifier.height(20.dp))
            LeadingIconInputField(
                value = email,
                onValueChange = { email = it },
                placeholder = Res.string.email,
                leadingIcon = Res.drawable.ic_mail_icon
            )
            Spacer(modifier = Modifier.height(20.dp))
            LeadingIconInputField(
                value = password,
                onValueChange = { password = it },
                placeholder = Res.string.password,
                leadingIcon = Res.drawable.ic_lock_open_icon,
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            LeadingIconInputField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = Res.string.confirm_password,
                leadingIcon = Res.drawable.ic_lock_icon,
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                MediumText(stringResource = Res.string.gender)
                RadioButton(
                    selected = gender == "Male",
                    onClick = { gender = "Male" },
                    colors = RadioButtonDefaults.colors(selectedColor = WhiteFF, unselectedColor = WhiteFF)
                )
                MediumText(stringResource = Res.string.male)
                RadioButton(
                    selected = gender == "Female",
                    onClick = { gender = "Female" },
                    colors = RadioButtonDefaults.colors(selectedColor = WhiteFF, unselectedColor = WhiteFF)
                )
                MediumText(stringResource = Res.string.female)
            }
            Spacer(modifier = Modifier.height(20.dp))
            LeadingIconInputField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = Res.string.phone_number,
                leadingIcon = Res.drawable.ic_mobile_icon
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = agreeTerms,
                    onCheckedChange = { agreeTerms = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = WhiteFF,
                        uncheckedColor = WhiteFF,
                        checkmarkColor = Red3F
                    )
                )
                MediumText(stringResource = Res.string.agree_terms, textSize = 13)
            }
            Spacer(modifier = Modifier.height(20.dp))
            PrimaryButton(text = Res.string.register_button,){

            }
        }

    }

}

@Composable
@Preview
fun RegisterScreenPreview() {
    RegisterScreen()
}


