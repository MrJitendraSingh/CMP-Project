package com.example.shopeapp.ui.main.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.shopeapp.ui.main.home.model.Category
import com.example.shopeapp.ui.theme.Red3F
import com.example.shopeapp.ui.theme.WhiteFF
import com.example.shopeapp.util.getAsyncImageLoader
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.app_name
import shopeapp.composeapp.generated.resources.chairs
import shopeapp.composeapp.generated.resources.cupboards
import shopeapp.composeapp.generated.resources.ic_chairs_icon
import shopeapp.composeapp.generated.resources.ic_cupboards_icon
import shopeapp.composeapp.generated.resources.ic_sofas_icon
import shopeapp.composeapp.generated.resources.ic_tables_icon
import shopeapp.composeapp.generated.resources.sofas
import shopeapp.composeapp.generated.resources.tables

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(Res.string.app_name)) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle menu click */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Red3F,
                    titleContentColor = WhiteFF,
                    navigationIconContentColor = WhiteFF,
                    actionIconContentColor = WhiteFF
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val pagerState = rememberPagerState { 4 }
            val sliderList = listOf(
                "https://www.urbanwood.in/image/catalog/blogs/1260h-teak-wood-living-room-furniture-1051780.jpg",
                "https://birchwoodfurniture.ca/wp-content/uploads/2023/07/Modern-Living-Room-Furniture-Ideas-Hero-scaled.jpg",
                "https://cdn.prod.website-files.com/5f2b10811da7064399ed3a1c/67640b5b33d1a8708c0843b2_1.webp",
                "https://cdn.laredoute.com/generic/blogs/images/3/storage-solutions-shelves.jpg"
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.height(250.dp)
            ) {
                AsyncImage(
                    model = sliderList[it],
                    imageLoader = getAsyncImageLoader(),
                    contentDescription = "Slider Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth().height(250.dp)
                )
            }
            Row(
                Modifier
                    .height(20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(sliderList.size) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(10.dp)

                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            val categories = listOf(
                Category(Res.string.tables, Res.drawable.ic_tables_icon),
                Category(Res.string.sofas, Res.drawable.ic_sofas_icon),
                Category(Res.string.chairs, Res.drawable.ic_chairs_icon),
                Category(Res.string.cupboards, Res.drawable.ic_cupboards_icon)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    CategoryGridItem(category)
                }
            }
        }
    }
}

@Composable
fun CategoryGridItem(category: Category) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Red3F)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(category.title),
                color = WhiteFF,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Icon(
                painter = org.jetbrains.compose.resources.painterResource(category.icon),
                contentDescription = null,
                tint = WhiteFF,
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
@Preview
fun CategoryGridItemPreview() {
    CategoryGridItem(
        category = Category(
            title = Res.string.tables,
            icon = Res.drawable.ic_tables_icon
        )
    )
}
