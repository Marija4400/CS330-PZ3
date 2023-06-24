package com.example.cs330_pz3.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cs330_pz3.AppViewModel
import com.example.cs330_pz3.data.ReceptItem
import com.example.cs330_pz3.ui.theme.CS330PZ3Theme
import java.nio.file.Files.delete


@Composable
fun ReceptDetailScreen(vm:AppViewModel,elementId:String, paddingValues: PaddingValues) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues), contentAlignment = Alignment.TopCenter) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {

                ReceptBasicData(recept = vm.getRecept(elementId),
                    goBack = { vm.goBack() },
                    nacinPripreme = { vm.switchNacinPripreme() })
            }
            item{
                AnimatedVisibility (vm.nacinPripreme.value) {
                    NacinPripreme(recept = vm.getRecept(elementId))
                }
            }
        }
    }
}
@Composable
fun ReceptBasicData(recept:ReceptItem?, goBack: () -> Unit ,
    nacinPripreme: ()-> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .background(Color.Transparent)
                    .scale(1.5f),
                onClick = { goBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(text = "Recept", style = MaterialTheme.typography.titleLarge, modifier = Modifier.align(
                Alignment.Center))

            }
        recept?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                AsyncImage(
                    model = it.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(280.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Text(text = "${it.naziv}", style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 4.dp),
                    fontWeight = FontWeight.Bold)
                Text(
                    text = "Tezina pripreme: ${recept.difficulty}", color = Color.Gray,
                    modifier = Modifier.padding(4.dp)
                )
        }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 30.dp, vertical = 8.dp)
                    ) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                        Text(
                            text = "${recept.sastojci}",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            Card(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.7f))
                        .padding(16.dp)
                        .clip(MaterialTheme.shapes.small)
                        .align(Alignment.CenterHorizontally) // Postavljanje na sredinu horizontalno
                ) {
                    Text(
                        text = "Kalorije: ${recept.kalorije}",
                        color = MaterialTheme.colorScheme.onTertiary,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 8.dp).align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Vreme pripreme: ${recept.vreme_pripreme}",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onTertiary,
                        modifier = Modifier.align(Alignment.CenterHorizontally) // Postavljanje na sredinu horizontalno
                    )
                    Button(
                        onClick = { nacinPripreme() },
                        modifier = Modifier.padding(8.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Nacin pripreme")
                    }
                }
            }
            }

        }
    }
@Composable
fun NacinPripreme(recept: ReceptItem?) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(16.dp),
    ) {
        recept?.let {
            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "${it.nacinPripreme}",
                    modifier = Modifier
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioLowBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        )
                        .clickable { expanded = !expanded }
                    //,maxLines = if (!expanded) 2 else 10
                )
            }
        }
    }
}

@Preview
@Composable
fun StudentDetailScreenPreview() {
    CS330PZ3Theme {
        ReceptDetailScreen(AppViewModel(), "", PaddingValues())
    }
}