package com.kproject.cleidesigns.presentation.screens.designview

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.feature.design1.Design1
import com.kproject.cleidesigns.feature.design2.Design2
import com.kproject.cleidesigns.feature.design3.Design3
import com.kproject.cleidesigns.feature.design4.Design4
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType
import com.kproject.core.common.theme.CleidesignsTheme

@Composable
fun DesignViewScreen(
    design: Design,
    designType: DesignType,
    onNavigateBack: () -> Unit
) {
    when (designType) {
        DesignType.XML -> {
            DesignContent(
                designId = design.id,
                viewInXml = true
            )
        }
        DesignType.Compose -> {
            DesignContent(
                designId = design.id,
                viewInXml = false
            )
        }
        DesignType.Inspiration -> {
            DesignInspiration(
                design = design,
                onNavigateBack = onNavigateBack
            )
        }
    }
}

@Composable
private fun DesignContent(
    designId: Int,
    viewInXml: Boolean
) {
    when (designId) {
        1 -> Design1(viewInXml)
        2 -> Design2(viewInXml)
        3 -> Design3(viewInXml)
        4 -> Design4(viewInXml)
    }
}

@Composable
private fun DesignInspiration(
    design: Design,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(id = R.string.design_inspiration)) },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(id = R.color.colorPrimary),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1F1F1F))
                .padding(paddingValues)
        ) {
            Image(
                painter = painterResource(id = design.image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
            )

            Button(
                onClick = {
                    context.startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(design.sourceUrl)
                        )
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_open_in_new),
                    contentDescription = "Open url",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = stringResource(id = R.string.view_source_project),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun DesignInspirationPreview() {
    CleidesignsTheme {
        DesignInspiration(
            design = Design(),
            onNavigateBack = {}
        )
    }
}