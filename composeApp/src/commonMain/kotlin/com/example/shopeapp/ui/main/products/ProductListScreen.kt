package com.example.shopeapp.ui.main.products

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.shopeapp.common.Icon24Button
import com.example.shopeapp.common.MediumText
import com.example.shopeapp.common.TextMedium
import com.example.shopeapp.ui.main.products.model.Product
import com.example.shopeapp.ui.theme.Black4F
import com.example.shopeapp.ui.theme.Red3F
import com.example.shopeapp.ui.theme.WhiteFF
import com.example.shopeapp.ui.theme.Yellow
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.ic_arrow_back_icon
import shopeapp.composeapp.generated.resources.ic_search_icon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen() {
    val products = listOf(
        Product("Stylish Modern Dining Tables", "Aron Table Center", "Rs. 27,390", 4.5f, "https://www.precedent-furniture.com/sites/precedent-furniture.com/files/styles/header_image/public/A_7417-L-S_0.jpg"),
        Product("4 Seater Dining Table", "Future Furniture Center", "Rs. 27,390", 4.0f, "https://cdn.shopify.com/s/files/1/0040/6442/products/T1852-T1852-1-800x800_1024x1024.jpg?v=1569064789"),
        Product("6 Seater Dining Table", "Aron Table Center", "Rs. 27,390", 4.2f, "https://www.precedent-furniture.com/sites/precedent-furniture.com/files/styles/header_image/public/A_7417-L-S_0.jpg"),
        Product("Stylish 4 Seater Dining Tables", "Aron Table Center", "Rs. 27,390", 4.8f, "https://www.precedent-furniture.com/sites/precedent-furniture.com/files/styles/header_image/public/A_7417-L-S_0.jpg"),
        Product("Stylish Table", "Aron Table Center", "Rs. 27,390", 4.6f, "https://www.precedent-furniture.com/sites/precedent-furniture.com/files/styles/header_image/public/A_7417-L-S_0.jpg"),
        Product("Harkness Table for Offices", "Aron Table Center", "Rs. 06 OF 1508", 3.9f, "https://www.precedent-furniture.com/sites/precedent-furniture.com/files/styles/header_image/public/A_7417-L-S_0.jpg"),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tables", fontSize = 16.sp, fontFamily = FontFamily(Font(Res.font.gotham_medium)),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center) },
                navigationIcon = {
                    Icon24Button(icon = Res.drawable.ic_arrow_back_icon){

                    }
                },
                actions = {
                     Icon24Button(icon = Res.drawable.ic_search_icon) {

                     }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Red3F,
                    titleContentColor = WhiteFF,
                    navigationIconContentColor = WhiteFF
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            items(products) { product ->
                ProductListItem(product){

                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
    
}

@Composable
fun ProductListItem(product: Product, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .clickable{ onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Product Image",
            modifier = Modifier.size(100.dp, 80.dp)
        )
        Column(modifier = Modifier.padding(start = 16.dp)) {
            TextMedium(product.name, 15, color = Black4F)
            Spacer(modifier = Modifier.height(8.dp))
            TextMedium(product.producer, 10, color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextMedium(product.price, fontSize = 20, color = Red3F)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    repeat(5) { index ->
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = if (index < product.rating) Yellow else Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ProductListItemPreview() {
    ProductListScreen()
}
