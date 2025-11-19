package com.example.shopeapp.ui.main.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.ui.main.home.component.DrawerEvent
import com.example.shopeapp.ui.main.home.component.NavigationDrawer
import com.example.shopeapp.ui.main.home.model.Category
import com.example.shopeapp.ui.theme.Red1A
import com.example.shopeapp.ui.theme.WhiteFF
import com.example.shopeapp.util.SideAlign
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import shopeapp.composeapp.generated.resources.Res
import shopeapp.composeapp.generated.resources.app_name
import shopeapp.composeapp.generated.resources.chairs
import shopeapp.composeapp.generated.resources.cupboards
import shopeapp.composeapp.generated.resources.gotham_medium
import shopeapp.composeapp.generated.resources.ic_chairs_icon
import shopeapp.composeapp.generated.resources.ic_cupboards_icon
import shopeapp.composeapp.generated.resources.ic_sofas_icon
import shopeapp.composeapp.generated.resources.ic_tables_icon
import shopeapp.composeapp.generated.resources.sofas
import shopeapp.composeapp.generated.resources.tables

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawer(
                UserLoginModel(
                    1,
                    "John Doe",
                    "john.mckinley@examplepetstore.com",
                    "1234567890")
            ){ event ->
                when (event) {
                    is DrawerEvent.CartEvent -> {}
                    is DrawerEvent.LogoutEvent -> {}
                    is DrawerEvent.ProfileEvent -> {}
                    else -> {}
                }
                scope.launch { drawerState.close() }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(stringResource(Res.string.app_name)) },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle search click */ }) {
                            Icon(Icons.Default.Search, contentDescription = "Search")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Red1A,
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
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .height(250.dp)
                ) {

                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxHeight(1f)
                            .fillMaxWidth()
                    ) {
                        AsyncImage(
                            model = sliderList[it],
                            contentDescription = "Slider Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth().fillMaxHeight(1f)
                        )
                    }
                    Row(
                        Modifier
                            .height(20.dp)
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        repeat(sliderList.size) { iteration ->
                            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Red1A
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(10.dp)

                            )
                        }
                    }

                }

                val categories = listOf(
                    Category(Res.string.tables, SideAlign.TOP_END, Res.drawable.ic_tables_icon, SideAlign.BOTTOM_START),
                    Category(Res.string.sofas, SideAlign.BOTTOM_START, Res.drawable.ic_sofas_icon, SideAlign.TOP_END),
                    Category(Res.string.chairs, SideAlign.TOP_START, Res.drawable.ic_chairs_icon, SideAlign.BOTTOM_END),
                    Category(Res.string.cupboards, SideAlign.BOTTOM_END, Res.drawable.ic_cupboards_icon, SideAlign.TOP_START)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(categories) { category ->
                        CategoryGridItem(category)
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryGridItem(category: Category) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Red1A),
        shape = RoundedCornerShape(0.dp)

    ) {
        Box(
            modifier = Modifier.padding(16.dp)
                .height(120.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(category.title),
                color = WhiteFF,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(Res.font.gotham_medium)),
                fontSize = 20.sp,
                modifier = Modifier.align(
                    when (category.titleAlignment) {
                        SideAlign.TOP_START -> Alignment.TopStart
                        SideAlign.TOP_END -> Alignment.TopEnd
                        SideAlign.BOTTOM_START -> Alignment.BottomStart
                        else -> Alignment.BottomEnd
                    }
                )
            )
            Icon(
                painter = org.jetbrains.compose.resources.painterResource(category.icon),
                contentDescription = null,
                tint = WhiteFF,
                modifier = Modifier.size(84.dp)
                    .align(
                        when (category.iconAlignment) {
                            SideAlign.TOP_START -> Alignment.TopStart
                            SideAlign.TOP_END -> Alignment.TopEnd
                            SideAlign.BOTTOM_START -> Alignment.BottomStart
                            else -> Alignment.BottomEnd
                        }
                    )
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
            titleAlignment = SideAlign.TOP_END,
            icon = Res.drawable.ic_tables_icon,
            iconAlignment = SideAlign.BOTTOM_START
        )
    )
}
