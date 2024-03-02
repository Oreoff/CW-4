package ua.edu.lntu.ipz_32_cw_4
import androidx.compose.material.*
import androidx.compose.runtime.*
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.edu.lntu.ipz_32_cw_4.ui.theme.IPZ_32_cw_4Theme
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ua.edu.lntu.ipz_32_cw_4.ui.StartScreen
import ua.edu.lntu.ipz_32_cw_4.ui.SecondScreen
import androidx.compose.material3.TopAppBar

import androidx.compose.material3.TopAppBarDefaults
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_32_cw_4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}
sealed class Screen(val route: String) {
    data object StartScreen : Screen("StartScreen")
    data object SecondScreen : Screen("SecondScreen")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting( modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Navigation Example") },
                modifier = modifier,
            )
        }
    ) {innerPadding -> Modifier.padding(25.dp)
        NavHost(
            navController = navController,
            startDestination = Screen.StartScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Screen.StartScreen.route)
            {
                StartScreen(navController = navController, modifier = Modifier)
            }
            composable(route = Screen.SecondScreen.route)
            {
SecondScreen(navController = navController, modifier = Modifier)
            }
        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        IPZ_32_cw_4Theme {
            Greeting()
        }
    }
