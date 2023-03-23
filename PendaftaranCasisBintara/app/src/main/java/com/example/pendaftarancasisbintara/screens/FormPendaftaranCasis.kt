package com.example.pendaftarancasisbintara.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.pendaftarancasisbintara.model.PendaftaranCasis
import com.example.pendaftarancasisbintara.persistences.PendaftaranCasisDao
import com.example.pendaftarancasisbintara.ui.theme.Purple700
import com.example.pendaftarancasisbintara.ui.theme.Teal200
import kotlinx.coroutines.launch
@Composable
fun FormPendaftaranCasis(PendaftaranCasisDao: PendaftaranCasisDao ) {
    val id = remember { mutableStateOf(TextFieldValue("")) }
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val alamat = remember { mutableStateOf(TextFieldValue("")) }
    val usia = remember { mutableStateOf(TextFieldValue("")) }
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(text = "id") },
            value = id.value,
            onValueChange = {
                id.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "id") }

        )
        OutlinedTextField(
            label = { Text(text = "Nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Nama") }

        )
        OutlinedTextField(
            label = { Text(text = "Alamat") },
            value = alamat.value,
            onValueChange = {
                alamat.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "Alamat") }
        )
        OutlinedTextField(
            label = { Text(text = "Usia") },
            value = usia.value,
            onValueChange = {
                usia.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "Usia") }
        )
        OutlinedTextField(
            label = { Text(text = "Tanggal Pendaftaran") },
            value = tanggal.value,
            onValueChange = {
                tanggal.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = PendaftaranCasis(id, nama.value.text,
                    alamat.value.text, usia.value.text, tanggal.value.text)
                scope.launch {
                    PendaftaranCasisDao.insertAll(item)
                }
                nama.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
                usia.value = TextFieldValue("")
                tanggal.value = TextFieldValue("")

            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                alamat.value = TextFieldValue("")
                usia.value = TextFieldValue("")
                tanggal.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}