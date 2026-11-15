package com.ozenli.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Cream = Color(0xFFF4EEE6)
private val CardCream = Color(0xFFFFFBF6)
private val Taupe = Color(0xFFA99585)
private val Brown = Color(0xFF765B4B)
private val DeepBrown = Color(0xFF4F3B31)
private val Gold = Color(0xFFB69A70)
private val Ink = Color(0xFF45372F)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { OzenliApp() }
    }
}

private data class Feature(
    val title: String,
    val subtitle: String,
    val icon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OzenliApp() {
    val features = listOf(
        Feature("Güzellik & Bakım", "Rutinlerini düzenle", Icons.Filled.Spa),
        Feature("Stil & Kombin", "Tarzını planla", Icons.Filled.Checkroom),
        Feature("Sağlıklı Yaşam", "Günlük iyi yaşam", Icons.Filled.FavoriteBorder),
        Feature("Hesaplama Araçları", "Pratik hesaplamalar", Icons.Filled.Calculate),
        Feature("Ajanda & Planlayıcı", "Gününü organize et", Icons.Filled.CalendarMonth),
        Feature("Bütçe & Alışveriş", "Harcamalarını takip et", Icons.Filled.ShoppingBag)
    )
    var selectedTab by remember { mutableStateOf(0) }
    var selectedFeature by remember { mutableStateOf<Feature?>(null) }

    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Brown,
            secondary = Gold,
            background = Cream,
            surface = CardCream,
            onPrimary = Color.White,
            onBackground = Ink,
            onSurface = Ink
        )
    ) {
        Scaffold(
            containerColor = Cream,
            bottomBar = {
                NavigationBar(containerColor = DeepBrown, contentColor = Cream) {
                    val tabs = listOf(
                        "Ana Sayfa" to Icons.Filled.Home,
                        "Favoriler" to Icons.Filled.StarBorder,
                        "Takip" to Icons.Filled.BarChart,
                        "Profil" to Icons.Filled.PersonOutline
                    )
                    tabs.forEachIndexed { index, pair ->
                        NavigationBarItem(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            icon = { Icon(pair.second, contentDescription = pair.first) },
                            label = { Text(pair.first, fontSize = 10.sp) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Gold,
                                selectedTextColor = Cream,
                                unselectedIconColor = Cream.copy(alpha = 0.7f),
                                unselectedTextColor = Cream.copy(alpha = 0.7f),
                                indicatorColor = Brown
                            )
                        )
                    }
                }
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .background(Cream)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(DeepBrown)
                        .padding(horizontal = 20.dp, vertical = 18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menü", tint = Cream)
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            "ÖZENLİ",
                            color = Cream,
                            fontSize = 29.sp,
                            fontWeight = FontWeight.Light,
                            letterSpacing = 4.sp
                        )
                        Text(
                            "KADIN YAŞAM ASİSTANI",
                            color = Cream.copy(alpha = 0.8f),
                            fontSize = 9.sp,
                            letterSpacing = 2.sp
                        )
                    }
                    Icon(Icons.Filled.NotificationsNone, contentDescription = "Bildirimler", tint = Cream)
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 16.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Taupe),
                        shape = RoundedCornerShape(22.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 22.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                "KENDİNE ZAMAN AYIR",
                                color = Cream,
                                fontSize = 11.sp,
                                letterSpacing = 2.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(Modifier.height(8.dp))
                            Text(
                                "Her gün kendine\nbiraz daha özen.",
                                color = Color.White,
                                fontSize = 24.sp,
                                lineHeight = 31.sp,
                                fontWeight = FontWeight.Light
                            )
                            Spacer(Modifier.height(12.dp))
                            Text(
                                "Küçük adımlar, güzel alışkanlıklar.",
                                color = Cream,
                                fontSize = 12.sp
                            )
                        }
                    }

                    Spacer(Modifier.height(22.dp))
                    Text(
                        "Keşfet",
                        color = DeepBrown,
                        fontSize = 21.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "İhtiyacın olan her şey bir arada",
                        color = Brown,
                        fontSize = 12.sp
                    )
                    Spacer(Modifier.height(12.dp))

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(bottom = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(features) { feature ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(142.dp)
                                    .clickable { selectedFeature = feature },
                                shape = RoundedCornerShape(18.dp),
                                colors = CardDefaults.cardColors(containerColor = CardCream),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(14.dp),
                                    horizontalAlignment = Alignment.Start,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        feature.icon,
                                        contentDescription = null,
                                        tint = Brown,
                                        modifier = Modifier.size(30.dp)
                                    )
                                    Spacer(Modifier.height(12.dp))
                                    Text(
                                        feature.title,
                                        color = DeepBrown,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 14.sp
                                    )
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        feature.subtitle,
                                        color = Brown,
                                        fontSize = 11.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        selectedFeature?.let { feature ->
            AlertDialog(
                onDismissRequest = { selectedFeature = null },
                containerColor = CardCream,
                title = { Text(feature.title, color = DeepBrown) },
                text = {
                    Text(
                        "Bu bölüm ÖZENLİ uygulamasının sonraki geliştirme aşamasında hazırlanacak.",
                        color = Ink
                    )
                },
                confirmButton = {
                    TextButton(onClick = { selectedFeature = null }) {
                        Text("Tamam", color = Brown)
                    }
                }
            )
        }
    }
}
