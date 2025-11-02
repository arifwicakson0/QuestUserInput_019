package com.example.pertemuan_5.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {

    // Variabel untuk menyimpan input dari user
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    // Variabel untuk hasil submit
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Input Nama
        OutlinedTextField(
            value = textNama,
            onValueChange = { textNama = it },
            label = { Text("Nama Lengkap") },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Pilihan Jenis Kelamin
        Text(text = "Jenis Kelamin")
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = textJK == item,
                            onClick = { textJK = item }
                        )
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    )
                    Text(text = stringResource(id = R.string.submit))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Input Alamat
        OutlinedTextField(
            value = textAlamat,
            onValueChange = { textAlamat = it },
            label = { Text("Alamat Lengkap") },
            singleLine = true,
            modifier = Modifier.width(250.dp)
        )

        HorizontalDivider(
            modifier = Modifier.padding(top = 100.dp)
        )

        // Tombol Submit
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty() && textJK.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
            }
        ) {
            Text(text = stringResource(id = R.st))
        }

        Divider(
            modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_medium)),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        // Card hasil submit
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Red),
            modifier = Modifier
                .height(120.dp)
                .width(300.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp)
            ) {
                Text(text = "Nama: $nama", color = Color.White)
                Text(text = "Gender: $jenis", color = Color.White)
                Text(text = "Alamat: $alamat", color = Color.White)
            }
        }
    }
}