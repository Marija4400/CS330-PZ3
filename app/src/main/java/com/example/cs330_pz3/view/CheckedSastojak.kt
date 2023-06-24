package com.example.cs330_pz3.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.cs330_pz3.AppViewModel


@Composable
fun CheckedSastojak (vm: AppViewModel, paddingValues: PaddingValues) {
    val foodPreferences = remember { mutableStateListOf<String>() }

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()


    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(paddingValues)
        ) {

            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    IconButton(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .scale(1.5f),
                        onClick = { vm.goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.padding(16.dp))
                    }
                        Text(text = "Namirnice:",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.align(Alignment.Center))
                    }

                }
                item {
                    Text(
                        text = "Odaberite namirnice koje trenutno imate: ",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Meso", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR701qW7kYsYn-3ajKwoNm3wTp4py3dK8uXGA&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Krompir" ,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMTftFpHdeLB4uRQu_Qof5D2q_dq5Rci4-uw&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Grasak", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGYHufgCKVsZJ66SWdyJ_KW_7OgeXG8HkSqQ&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Paradajz", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3GhXSqsnMOE_6y-rotT8Pn0THd-80dpQ-dg&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Kupus", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRpekqfe-qTeQLOtkSv2d9c6ScH5aqZFXhPw&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Zacin","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6PFXZMWzSdlnypmm7Dlr7uGSHXajslrUWrA&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Nudle","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXRUCJPIWs8TbxYzRJmOeqYGy3BFnsOg22sw&usqp=CAU" )
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Tunjevina", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjik9X1-ubCLHnAJ6v64eM2cbEL51LMHmC7A&usqp=CAU")
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Testenina","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMlmdrraUc6chuPcZ1VhUrSu3yPoX67CR2uQ&usqp=CAU" )
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Pirinac","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRN0eNZf5PGxXtiM2XuXcxAEy0N_FHzy91zHA&usqp=CAU" )
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Ovsene pahuljice","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_3B2yNmTJ1RyNYt1KPfZETBgRQs56HcRCLg&usqp=CAU" )
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Krem","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2RdJIX-x8i_5y_uyz3Ufx4TXUewLDWYUfTg&usqp=CAU" )
                    Spacer(modifier = Modifier.height(8.dp))
                    FoodPreferenceItem("Banane","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDnhMZcNvNz-DGQOfvsf8bQ51ri3kfRgw5gw&usqp=CAU" )

                }
            item{
                Button(
                    onClick = { /* Akcija klika na dugme */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(24.dp))
                ) {
                    Text(text = "POTVRDI")
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

            }
     }
}

    @Composable
    fun CustomCheckbox(
        checked: Boolean,
        onCheckedChange: (Boolean) -> Unit,
        modifier: Modifier = Modifier,
        icon: ImageVector = Icons.Default.CheckCircle,
        color: Color = MaterialTheme.colorScheme.primary,
        size: Dp = 45.dp
    ) {
        Box(
            modifier = modifier
                .size(size)
                .clickable { onCheckedChange(!checked) }
                .padding(4.dp),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (checked) color else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.size(size)
            )
        }
    }

    @Composable
    fun FoodPreferenceItem(name: String, imageUrl: String? = null) {
        val checkedState = remember { mutableStateOf(false) }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            CustomCheckbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier.padding(end = 8.dp)
            )

            if (imageUrl != null) {
                val painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        crossfade(true)
                    }
                )

                Image(
                    painter = painter,
                    contentDescription = name,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop,
                )
            }

            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
        }
    }





