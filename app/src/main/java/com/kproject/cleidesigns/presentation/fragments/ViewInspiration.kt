package com.kproject.cleidesigns.presentation.fragments

import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.presentation.main.Design

@Composable
fun ViewInspiration(
    design: Design,
    navigateBack: () -> Unit
) {
    val context = LocalContext.current
    var backButtonClicks by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.design_inspiration)) },
                backgroundColor = colorResource(id = R.color.colorPrimary),
                contentColor = Color.White,
                navigationIcon = {
                    IconButton(
                        onClick = {
                            backButtonClicks++
                            if (backButtonClicks == 1) {
                                navigateBack.invoke()
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                },
                elevation = 0.dp
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF3C3C3C))
                .padding(paddingValues)
        ) {
            Image(
                painter = painterResource(id = design.image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize().weight(1f)
            )

            Button(
                onClick = { showDialog = true },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.colorPrimary)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.view_source_project),
                    color = Color.White
                )
            }
        }
    }

    AlertDialog(
        showDialog = showDialog,
        onDismiss = {
            showDialog = false
        },
        titleResId = R.string.design_inspiration,
        messageResId = R.string.continue_to_source_project_page,
        onClickButtonOk = {
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(design.sourceUrl)
                )
            )
        }
    )
}

@Composable
private fun AlertDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    @StringRes titleResId: Int,
    @StringRes messageResId: Int,
    onClickButtonOk: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onDismiss.invoke() },
            title = {
                Text(
                    text = stringResource(id = titleResId),
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = stringResource(id = messageResId),
                    color = Color.Black,
                    fontSize = 16.sp
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDismiss.invoke()
                        onClickButtonOk.invoke()
                    }
                ) {
                    Text(
                        text = "OK",
                        color = MaterialTheme.colors.onSecondary
                    )
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismiss.invoke()
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.button_cancel).uppercase(),
                        color = MaterialTheme.colors.onSecondary
                    )
                }
            }
        )
    }
}