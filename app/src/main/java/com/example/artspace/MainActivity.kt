package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
 import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.remember

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                ArtSpaceTheme {
                    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                        ArtScreen()
                    }
            }
        }
    }
}

@Composable
fun ArtScreen(modifier: Modifier = Modifier) {
    val image1 = R.drawable.tunis
    val image2 = R.drawable.paris_
    val image3 = R.drawable.rome
    val image4 = R.drawable.egypte


    val title = remember { mutableStateOf(stringResource(R.string.nom1)) }
    val description = remember { mutableStateOf(stringResource(R.string.n1)) }
    val currentImage = remember { mutableStateOf(image1) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = currentImage.value), contentDescription = null)
        Spacer(modifier = modifier.size(16.dp))

        Text(text = title.value, style = MaterialTheme.typography.titleLarge)
        Text(text = description.value, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = modifier.size(25.dp))

        Row(
            modifier = modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {
                when (currentImage.value) {
                    image1 -> {
                        currentImage.value = image4
                        title.value = stringResource(R.string.nom4)
                        description.value = stringResource(R.string.n4)
                    }
                    image2 -> {
                        currentImage.value = image1
                        title.value = stringResource(R.string.nom1)
                        description.value = stringResource(R.string.n1)
                    }
                    image3 -> {
                        currentImage.value = image2
                        title.value = stringResource(R.string.nom2)
                        description.value = stringResource(R.string.n2)
                    }
                    image4 -> {
                        currentImage.value = image3
                        title.value = stringResource(R.string.nom3)
                        description.value = stringResource(R.string.n3)
                    }
                }
            }) {
                Text(text = stringResource(R.string.previous))
            }


            Button(onClick = {
                when (currentImage.value) {
                    image1 -> {
                        currentImage.value = image2
                        title.value = stringResource(R.string.nom2)
                        description.value = stringResource(R.string.n2)
                    }
                    image2 -> {
                        currentImage.value = image3
                        title.value = stringResource(R.string.nom3)
                        description.value = stringResource(R.string.n3)
                    }
                    image3 -> {
                        currentImage.value = image4
                        title.value = stringResource(R.string.nom4)
                        description.value = stringResource(R.string.n4)
                    }
                    image4 -> {
                        currentImage.value = image1
                        title.value = stringResource(R.string.nom1)
                        description.value = stringResource(R.string.n1)
                    }
                }
            }) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Greeting("Android")
    }
}