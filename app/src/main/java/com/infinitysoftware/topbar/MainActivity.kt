package com.infinitysoftware.topbar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infinitysoftware.topbar.ui.theme.TopBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopBarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                }
                TopBar()
            }
        }
    }
}

// Error Handler While Importing 'TopAppBar'.
@OptIn(ExperimentalMaterial3Api::class)

// Custom Made Composable Preview Function.
@Preview(showBackground = true)
@Composable
fun TopBar() {

    // Toast Context Variable.
    val context = LocalContext.current

    TopAppBar(
        title = { Text(text = "TopBar") },
        navigationIcon = {

            IconButton(onClick = {
                Toast.makeText(context, "TopBar", Toast.LENGTH_SHORT).show()
            }) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_android_black_24dp),
                    contentDescription = "Android Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White),

        actions = {
            IconButton(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
            Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile", tint = Color.White) }

            IconButton(onClick = { Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search", tint = Color.White) }

            IconButton(onClick = { Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White) }
        }
    )
}