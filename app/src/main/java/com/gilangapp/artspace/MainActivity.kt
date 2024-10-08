package com.gilangapp.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gilangapp.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    // Daftar gambar
    val imageIds = listOf(
        R.drawable.img1, // Nama file gambar 1
        R.drawable.img2, // Nama file gambar 2
        R.drawable.img3  // Nama file gambar 3
    )

    // Daftar judul dan nama artist
    val titles = listOf(
        "Nature Pattern",
        "Floral Seamless",
        "Aesthetic Vibrant"
    )

    val artists = listOf(
        "Gilang (2022)",
        "Teja (2023)",
        "Krishna (2024)"
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Gambar
        Image(
            painter = painterResource(id = imageIds[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp) // Ini untuk mengatur ukuran gambar sesuai kebutuhan
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Judul Karya
        Text(
            text = titles[currentIndex], // Menggunakan currentIndex untuk mendapatkan judul
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        // Nama Artist dan Tahun
        Text(
            text = artists[currentIndex], // Menggunakan currentIndex untuk mendapatkan nama artist
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Tombol Previous dan Next
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (currentIndex > 0) {
                        currentIndex--
                    }
                },
                enabled = currentIndex > 0 // Nonaktifkan tombol jika di gambar pertama
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = {
                    if (currentIndex < imageIds.size - 1) {
                        currentIndex++
                    }
                },
                enabled = currentIndex < imageIds.size - 1 // Nonaktifkan tombol jika di gambar terakhir
            ) {
                Text(text = "Next")
            }
        }
    }
}
