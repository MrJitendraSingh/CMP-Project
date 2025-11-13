package com.example.shopeapp.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopeapp.ui.theme.Red1A
import com.example.shopeapp.ui.theme.WhiteFF
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.gotham_bold
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.submit


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: StringResource = Res.string.submit,
    onClick: () -> Unit = {}
) {

    Button(
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = WhiteFF),
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = stringResource(text),
            color = Red1A,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(Res.font.gotham_medium))
        )
    }
}

@Composable
@Preview
fun PrimaryButtonPreview(){
    PrimaryButton()
}