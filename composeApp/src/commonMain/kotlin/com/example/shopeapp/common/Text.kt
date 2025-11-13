package com.example.shopeapp.common

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.shopeapp.ui.theme.WhiteFF
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.gotham_medium


@Composable
fun MediumText(stringResource: StringResource,
               textSize: Int = 16){
    Text(text = stringResource(stringResource),
        fontSize = textSize.sp,
        fontFamily = FontFamily(Font(Res.font.gotham_medium)),
        color = WhiteFF
    )
}