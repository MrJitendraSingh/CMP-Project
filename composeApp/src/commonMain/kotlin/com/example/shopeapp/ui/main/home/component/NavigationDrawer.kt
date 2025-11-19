package com.example.shopeapp.ui.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.ui.main.home.model.NavigationItem
import com.example.shopeapp.ui.theme.Black2B
import com.example.shopeapp.ui.theme.Red1A
import com.example.shopeapp.ui.theme.WhiteFF
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.chairs
import shopeapp.composeapp.generated.resources.cupboards
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.ic_cart_icon
import shopeapp.composeapp.generated.resources.ic_chairs_icon
import shopeapp.composeapp.generated.resources.ic_cupboards_icon
import shopeapp.composeapp.generated.resources.ic_logout_icon
import shopeapp.composeapp.generated.resources.ic_person_icon
import shopeapp.composeapp.generated.resources.ic_pin_drop_location_icon
import shopeapp.composeapp.generated.resources.ic_prescriptions_icon
import shopeapp.composeapp.generated.resources.ic_sofas_icon
import shopeapp.composeapp.generated.resources.ic_tables_icon
import shopeapp.composeapp.generated.resources.logout
import shopeapp.composeapp.generated.resources.my_account
import shopeapp.composeapp.generated.resources.my_cart
import shopeapp.composeapp.generated.resources.my_orders
import shopeapp.composeapp.generated.resources.sofas
import shopeapp.composeapp.generated.resources.store_locator
import shopeapp.composeapp.generated.resources.tables

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(
    user: UserLoginModel,
    onClick: (DrawerEvent) -> Unit
) {
    val navItems = listOf(
        NavigationItem(Res.string.my_cart, Res.drawable.ic_cart_icon, 2),
        NavigationItem(Res.string.tables, Res.drawable.ic_tables_icon),
        NavigationItem(Res.string.sofas, Res.drawable.ic_sofas_icon),
        NavigationItem(Res.string.chairs, Res.drawable.ic_chairs_icon),
        NavigationItem(Res.string.cupboards, Res.drawable.ic_cupboards_icon),
        NavigationItem(Res.string.my_account, Res.drawable.ic_person_icon),
        NavigationItem(Res.string.store_locator, Res.drawable.ic_pin_drop_location_icon),
        NavigationItem(Res.string.my_orders, Res.drawable.ic_prescriptions_icon),
        NavigationItem(Res.string.logout, Res.drawable.ic_logout_icon),
    )

    Column(modifier = Modifier.background(Black2B).padding(16.dp)
        .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(60.dp))
        Image(
            painter = painterResource(Res.drawable.ic_person_icon),
            contentDescription = "User profile picture",
            modifier = Modifier.size(100.dp).clip(CircleShape)
                .border(width = 2.dp, color = WhiteFF, shape = CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(user.username, color = WhiteFF,
            fontFamily = FontFamily(Font(Res.font.gotham_medium)),
            fontSize = 22.sp)
        Spacer(Modifier.height(10.dp))
        Text(user.email, color = WhiteFF,
            fontFamily = FontFamily(Font(Res.font.gotham_medium)),
            fontSize = 12.sp)
        Spacer(modifier = Modifier.height(40.dp))
        navItems.forEach { item ->
            NavigationDrawerItem(
                label = {
                            Text(stringResource(item.title),
                            color = WhiteFF,
                            fontFamily = FontFamily(Font(Res.font.gotham_medium)),
                            fontSize = 16.sp)
                        },
                icon = { Icon(painterResource(item.icon), contentDescription = null, tint = WhiteFF,
                    modifier = Modifier.size(28.dp)) },
                badge = {
                    item.badgeCount?.let {
                        Badge(containerColor = Red1A) { Text(it.toString()) }
                    }
                },
                selected = false,
                onClick = { /* Handle navigation */ }
            )
        }
    }
}

@Composable
@Preview
fun NavigationDrawerPreview(){
    NavigationDrawer(UserLoginModel(
        1,
        "Kinjal Jain",
        "kinjal.jain@wwindia.com",
        "pass"
    )){

    }
}
