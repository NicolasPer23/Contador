package com.example.contador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contador.ui.theme.ContadorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContadorTheme {
                Contador()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contador() {
    var contador by remember {
        mutableIntStateOf(0)
    }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text("Contador")
            }
        )
    }
    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).padding(
                top = 40.dp,
                start = 24.dp,
                end = 24.dp,
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
            Text(
                text = "Valor atual", fontSize = 36.sp
            )

            Text(
                text = contador.toString(), fontSize = 56.sp
            )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(onClick = { contador++ },
                    modifier = Modifier.width(140.dp).height(50.dp)) { Text("+ Somar", fontSize = 18.sp) }

                OutlinedButton(onClick = { contador-- },
                    enabled = contador> 0,
                    modifier = Modifier.width(140.dp).height(50.dp)) { Text("- Subtrair", fontSize =  18.sp)
                }

            }
            TextButton(onClick = { contador = 0 }) {
                Text("Zerar", fontSize =  18.sp)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ContadorPreview() {
    Contador()
}





