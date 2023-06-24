package com.example.cs330_pz3.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cs330_pz3.AppViewModel
import com.example.cs330_pz3.data.ReceptItem
import com.example.cs330_pz3.ui.theme.CS330PZ3Theme

@Composable
fun ReceptListPage(vm: AppViewModel, paddingValues: PaddingValues) {
    val reepti = vm.recepti.observeAsState()
    LaunchedEffect(vm.loadRecepti()) {
    }

    LazyColumn(modifier = Modifier.padding(paddingValues)) {
        reepti.value?.let {
            items(it) { recept ->
                ReceptCardView(recept) {
                    vm.navigateToReceptDetails(it)
                }
            }
        }
    }
}
@Composable
fun ReceptCardView(recept: ReceptItem, onSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onSelected(recept.id) }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = recept.image,
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .width(250.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${recept.naziv} ",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.clickable { expanded =!expanded }
                )
                Text(
                    text = "Vreme pripreme: ${recept.vreme_pripreme}", color = Color.Gray,
                    modifier = Modifier.padding(4.dp)
                )
                if (expanded) {

                    Text(
                        text = "Tezina pripreme: ${recept.difficulty}",
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = "Kalorijska vrednost: ${recept.kalorije}",
                        modifier = Modifier.padding(4.dp),
                        style = MaterialTheme.typography.titleMedium
                    )


                }
            }

        }


    }
}

