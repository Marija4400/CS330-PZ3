package com.example.cs330_pz3.view

import android.Manifest
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cs330_pz3.AppViewModel

import com.example.cs330_pz3.ui.theme.CS330PZ3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(vm: AppViewModel = viewModel(), paddingValues: PaddingValues) {
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        vm.granted.value = isGranted
    }

    Column {
        if (!vm.granted.value) {
            InternetPermission(launcher)
        } else {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Recepti",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    )
            },
                floatingActionButton = {
                    FloatingActionButton(onClick = { vm.navigateCheckedSastojak() }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Odaberi sastojke")
                    }
                }) { innerPadding ->
                ReceptListPage(vm, innerPadding)
            }

        }
    }
}

@Composable
private fun InternetPermission(launcher: ManagedActivityResultLauncher<String, Boolean>) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Internet permission not granted",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(8.dp)
            )
            Button(onClick = { launcher.launch(Manifest.permission.INTERNET) }) {
                Text("Request permission")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    CS330PZ3Theme() {
        HomeScreen(AppViewModel(), PaddingValues(8.dp))
    }

}