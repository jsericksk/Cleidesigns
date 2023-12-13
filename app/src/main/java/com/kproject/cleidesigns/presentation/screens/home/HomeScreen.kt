package com.kproject.cleidesigns.presentation.screens.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType
import com.kproject.cleidesigns.presentation.screens.model.designs
import com.kproject.core.common.theme.CleidesignsTheme

@Composable
fun HomeScreen(onNavigateToDesignViewScreen: (Design, DesignType) -> Unit) {
    MainContent(
        onViewDesign = onNavigateToDesignViewScreen
    )
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    onViewDesign: (Design, DesignType) -> Unit,
) {
    Scaffold(
        topBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(bottomStart = 100.dp, bottomEnd = 100.dp)
                    )
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(12.dp)
        ) {
            DesignList(
                onViewDesign = onViewDesign
            )
        }
    }
}

@Composable
private fun DesignList(
    modifier: Modifier = Modifier,
    onViewDesign: (Design, DesignType) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        itemsIndexed(items = designs) { index, design ->
            DesignListItem(
                design = design,
                onViewDesign = onViewDesign
            )
        }
    }
}

@Composable
private fun DesignListItem(
    modifier: Modifier = Modifier,
    design: Design,
    onViewDesign: (Design, DesignType) -> Unit
) {
    var showDropdownMenu by remember { mutableStateOf(false) }
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp)
            .aspectRatio(1f)
            .clip(MaterialTheme.shapes.medium)
            .clickable { showDropdownMenu = true },
    ) {
        Box {
            Image(
                painter = painterResource(id = design.image),
                contentDescription = "DesignXML image",
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = design.title,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary.copy(0.7f))
                    .align(Alignment.BottomCenter)
                    .padding(8.dp),
            )
        }

        Box {
            MenuActionOptions(
                showOptionsMenu = showDropdownMenu,
                onDismiss = { showDropdownMenu = false },
                onViewDesign = { designType ->
                    onViewDesign.invoke(design, designType)
                }
            )
        }
    }
}

@Composable
private fun MenuActionOptions(
    showOptionsMenu: Boolean,
    onDismiss: () -> Unit,
    onViewDesign: (DesignType) -> Unit
) {
    DropdownMenu(
        expanded = showOptionsMenu,
        onDismissRequest = onDismiss,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .clip(MaterialTheme.shapes.medium)
    ) {
        ActionDropdownMenuItem(
            iconResId = R.drawable.ic_density_medium,
            titleResId = R.string.view_xml_version,
            contentDescriptionResId = R.string.view_xml_version,
            onClick = {
                onDismiss.invoke()
                onViewDesign.invoke(DesignType.XML)
            }
        )

        ActionDropdownMenuItem(
            iconResId = R.drawable.ic_code,
            titleResId = R.string.view_compose_version,
            contentDescriptionResId = R.string.view_compose_version,
            onClick = {
                onDismiss.invoke()
                onViewDesign.invoke(DesignType.Compose)
            }
        )

        ActionDropdownMenuItem(
            iconResId = R.drawable.ic_lightbulb,
            titleResId = R.string.view_design_inspiration,
            contentDescriptionResId = R.string.view_design_inspiration,
            onClick = {
                onDismiss.invoke()
                onViewDesign.invoke(DesignType.Inspiration)
            }
        )
    }
}

@Composable
private fun ActionDropdownMenuItem(
    @DrawableRes iconResId: Int,
    @StringRes titleResId: Int,
    @StringRes contentDescriptionResId: Int,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        onClick = onClick,
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = iconResId),
                contentDescription = stringResource(id = contentDescriptionResId),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        },
        text = {
            Text(
                text = stringResource(id = titleResId),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        },
        contentPadding = PaddingValues(14.dp)
    )
}

@Preview
@Composable
private fun Preview() {
    CleidesignsTheme {
        HomeScreen(onNavigateToDesignViewScreen = { _, _ -> })
    }
}