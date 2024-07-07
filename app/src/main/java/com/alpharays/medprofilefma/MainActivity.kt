package com.alpharays.medprofilefma

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.alpharays.medprofilefma.ui.theme.MedProfileFmaTheme
import com.alpharays.mymedprofilefma.MedProfileFmaRouter
import com.alpharays.mymedprofilefma.profilefma.utils.ProfileUtils

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedProfileFmaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("My Profile FMA")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            openMedProfileFma(context)
        },
        textDecoration = TextDecoration.Underline
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MedProfileFmaTheme {
        Greeting("Android")
    }
}

fun openMedProfileFma(context: Context) {
    MedProfileFmaRouter.initiateMedCommRouter(context)
    setupMedComm(context)
    MedProfileFmaRouter.startDummyActivity(context)
}

fun setupMedComm(context: Context) {
    ProfileUtils.setAuthToken(context, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY1ODFkNDE4ZWE0Mjk4ODI5ZGExOTdiYiIsImlhdCI6MTcxMjY0NDQ0Mn0.bOeYRf1viECg8-5PpeJmj1U0Nz45Z4zHBQSyrD8rQh4")
}
