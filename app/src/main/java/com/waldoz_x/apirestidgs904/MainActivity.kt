package com.waldoz_x.apirestidgs904

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.waldoz_x.apirestidgs904.ui.theme.ApiRestIDGS904Theme
import com.waldoz_x.apirestidgs904.ui.theme.StudentScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: StudentViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            ApiRestIDGS904Theme {
                StudentScreen(viewModel)
            }
        }
    }
}

