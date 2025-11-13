package com.example.shopeapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopeapp.ui.theme.Red1A
import com.example.shopeapp.ui.theme.Red3F
import com.example.shopeapp.ui.theme.WhiteFF
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.ic_person_icon
import shopeapp.composeapp.generated.resources.username


@Composable
fun LeadingIconInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: StringResource = Res.string.username,
    leadingIcon: DrawableResource = Res.drawable.ic_person_icon,
    visualTransformation : VisualTransformation = VisualTransformation.None
){
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = { Text(text = stringResource(placeholder),
            fontFamily = FontFamily(Font(Res.font.gotham_medium)),
            fontSize = 18.sp
        ) },
        leadingIcon = {
            Icon(
                painter = painterResource(leadingIcon),
                contentDescription = "Username Icon",
                modifier = Modifier.size(28.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = WhiteFF,
            unfocusedTextColor = WhiteFF,
            focusedContainerColor = Red1A,
            unfocusedContainerColor = Red1A,
            cursorColor = WhiteFF,
            focusedLeadingIconColor = WhiteFF,
            unfocusedLeadingIconColor = WhiteFF,
            focusedPlaceholderColor = WhiteFF,
            unfocusedPlaceholderColor = WhiteFF,
            focusedIndicatorColor = WhiteFF,
            unfocusedIndicatorColor = WhiteFF,
        ),
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(0.dp),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
@Preview
fun LeadingIconInputFieldPreview(){
    Box(modifier = Modifier.background(Red3F).padding(16.dp)) {
        LeadingIconInputField(value = "", onValueChange = {})
    }
}
