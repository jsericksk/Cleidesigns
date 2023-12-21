package com.kproject.cleidesigns.presentation.screens.designview

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import com.kproject.cleidesigns.presentation.screens.designview.components.pagerTabIndicatorOffset
import com.kproject.cleidesigns.presentation.screens.model.Design
import com.kproject.cleidesigns.presentation.screens.model.DesignType
import com.kproject.core.common.theme.CleidesignsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DesignViewScreen(
    design: Design,
    designType: DesignType
) {
    val pages = remember { DesignType.entries.toList() }
    val pagerState = rememberPagerState(
        initialPage = designType.ordinal,
        initialPageOffsetFraction = 0f,
        pageCount = { pages.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            when (pages[currentPage]) {
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
                    DesignInspiration(design = design)
                }
            }
        }

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = MaterialTheme.colorScheme.primary,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = MaterialTheme.colorScheme.onPrimary,
                    height = 4.dp,
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            pages.forEachIndexed { index, designType ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = {
                        Text(
                            text = designType.name,
                            fontSize = 16.sp
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = designType.iconResId),
                            contentDescription = "Page tab"
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedContentColor = MaterialTheme.colorScheme.onPrimary.copy(0.7f)
                )
            }
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
private fun DesignInspiration(design: Design) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1F1F1F))
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
                .padding(16.dp),
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

@Preview
@Composable
private fun Preview() {
    CleidesignsTheme {
        DesignViewScreen(
            design = Design(),
            designType = DesignType.Compose
        )
    }
}