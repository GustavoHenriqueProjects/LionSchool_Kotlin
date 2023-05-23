package br.senai.sp.jandira.lionschool.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.R
import br.senai.sp.jandira.lionschool.gui.ui.theme.LionSchoolTheme

class StudentsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    InterfaceStudents()
                }
            }
        }
    }
}

@Composable
fun InterfaceStudents() {
    val items = remember { mutableStateListOf("2018", "2019", "2020", "2021", "2020", "2021", "2022", "2023", "2024") }
    val selectedItem = remember { mutableStateOf(items.first()) }
    val expandedState = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .background(color = Color(0XFF121214))
            ) {
                Button(
                    onClick = { /* Ação a ser executada quando o botão for clicado */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .background(Color(0XFF3E9450)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF3E9450)),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.student_activity_button_studing),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Button(
                    onClick = { /* Ação a ser executada quando o botão for clicado */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .background(Color(0XFFA13F2A)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFA13F2A)),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.student_activity_button_studing_finish),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Row() {
                    Button(
                        onClick = {
                            expandedState.value = true
                        },
                        modifier = Modifier
                            .width(120.dp)
                            .padding(16.dp)
                            .background(Color(0XFFFFC23E)),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFFFC23E)),
                        contentPadding = PaddingValues(16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.student_activity_button_Year),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    DropdownMenu(
                        expanded = expandedState.value,
                        onDismissRequest = { expandedState.value = false }
                    ) {
                        items.forEachIndexed { index, item ->
                            DropdownMenuItem(onClick = {
                                selectedItem.value = item
                                expandedState.value = false

                                Log.i("LionScholl", selectedItem.value)
                            }) {
                                Text(text = item, style = MaterialTheme.typography.body1)
                            }
                        }
                    }
                }
            }
        }
    }
}
