package com.hdaf.testtasksuperheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hdaf.testtasksuperheroapp.feature_superhero.presentation.navgraph.NavGraph
import com.hdaf.testtasksuperheroapp.ui.theme.TestTaskSuperHeroAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTaskSuperHeroAppTheme {
                NavGraph()
            }
        }
    }
}