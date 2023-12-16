package com.kproject.cleidesigns.feature.design3.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.kproject.cleidesigns.feature.design3.utils.initBarChart
import com.kproject.cleidesigns.core.commom.R as CR

@Composable
internal fun Design3Compose() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
                .verticalScroll(scrollState)
        ) {
            TopComponents()
            Spacer(Modifier.height(28.dp))
            CardComponents()
            Spacer(Modifier.height(28.dp))
            Statistics()
            Spacer(Modifier.height(28.dp))
            LastStatistics()
            Spacer(Modifier.height(28.dp))
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .border(BorderStroke(1.dp, Color(0xFFF5F4F4)))
        )

        Column(modifier = Modifier.padding(start = 24.dp, end = 24.dp)) {
            BottomNavigationView(
                items = listOf(
                    BottomNavigationItem(
                        "Home",
                        CR.drawable.ic_home
                    ),
                    BottomNavigationItem(
                        "Statistics",
                        CR.drawable.ic_bar_chart
                    ),
                    BottomNavigationItem(
                        "Transactions",
                        CR.drawable.ic_currency_exchange
                    ),
                    BottomNavigationItem(
                        "Profile",
                        CR.drawable.ic_person
                    ),
                )
            )
        }
    }
}

@Composable
private fun TopComponents() {
    Text(
        text = "Statistics",
        color = Color(0xFF0A0A0A),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(18.dp))

    var textFieldValue by remember { mutableStateOf("") }
    TextField(
        value = textFieldValue,
        onValueChange = { value ->
            textFieldValue = value
        },
        label = { Text(text = "Search...") },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = com.kproject.cleidesigns.core.commom.R.drawable.ic_search),
                contentDescription = null,
                tint = Color(0xFF5C5C5C)
            )
        },
        shape = CircleShape.copy(CornerSize(16.dp)),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.DarkGray,
            containerColor = Color(0xFFF1F1F9),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedLabelColor = Color(0xFF5C5C5C),
            unfocusedLabelColor = Color(0xFF5C5C5C),
        ),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun CardComponents() {
    Row(Modifier.fillMaxWidth()) {
        TransactionCard(
            iconResId = com.kproject.cleidesigns.core.commom.R.drawable.ic_call_made,
            type = "Income",
            cardBackgroundColor = Color(0xFF7D29A7),
            iconBackgroundColor = Color(0xFF5C1182),
            value = "$ 5 860",
            modifier = Modifier.weight(1f)
        )

        Spacer(Modifier.width(10.dp))

        TransactionCard(
            iconResId = com.kproject.cleidesigns.core.commom.R.drawable.ic_call_received,
            iconRotation = -90f,
            type = "Expenses",
            cardBackgroundColor = Color(0xFF4D4AD8),
            iconBackgroundColor = Color(0xFF312EAF),
            value = "$ 1 920",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun TransactionCard(
    modifier: Modifier = Modifier,
    iconResId: Int,
    iconRotation: Float = 0f,
    type: String,
    cardBackgroundColor: Color,
    iconBackgroundColor: Color,
    value: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor
        ),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = iconResId),
                contentDescription = type,
                contentScale = ContentScale.Inside,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .rotate(iconRotation)
                    .background(color = iconBackgroundColor, shape = CircleShape)
            )

            Spacer(Modifier.width(10.dp))

            Column {
                Text(
                    text = type,
                    color = Color(0xFFC3C3C3),
                    fontSize = 15.sp
                )

                Text(
                    text = value,
                    color = Color(0xFFECECEC),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun Statistics() {
    StatisticsOptions()
    Spacer(Modifier.height(28.dp))
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1F9)
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = "Total amount spent",
                        color = Color(0xFF6E6E6E),
                        fontSize = 15.sp
                    )

                    Text(
                        text = "\$ 1 420",
                        color = Color(0xFF131313),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFFDCDCE7),
                            CircleShape.copy(CornerSize(8.dp))
                        )
                        .clickable { }
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Weekly",
                            color = Color(0xFF494949),
                            fontSize = 16.sp,
                            modifier = Modifier.padding(14.dp)
                        )

                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Options",
                            tint = Color.Black,
                            modifier = Modifier.padding(end = 12.dp)
                        )
                    }
                }
            }

            Spacer(Modifier.height(8.dp))

            StatisticsChart()
        }
    }
}

@Composable
private fun StatisticsOptions() {
    var selectedOption by remember { mutableIntStateOf(2) }
    val option1BackgroundColor =
            if (selectedOption == 1) Color(0xFF2D2F45) else Color(0xFFF1F1F9)
    val option1TextColor =
            if (selectedOption == 1) Color.White else Color(0xFF737373)
    val option2BackgroundColor =
            if (selectedOption == 2) Color(0xFF2D2F45) else Color(0xFFF1F1F9)
    val option2TextColor =
            if (selectedOption == 2) Color.White else Color(0xFF737373)

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(option1BackgroundColor, CircleShape.copy(CornerSize(8.dp)))
                .clickable { selectedOption = 1 },
        ) {
            Text(
                text = "Income",
                color = option1TextColor,
                fontSize = 16.sp,
                modifier = Modifier.padding(7.dp)
            )
        }

        Spacer(Modifier.width(10.dp))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(option2BackgroundColor, CircleShape.copy(CornerSize(8.dp)))
                .clickable { selectedOption = 2 },
        ) {
            Text(
                text = "Expenses",
                color = option2TextColor,
                fontSize = 16.sp,
                modifier = Modifier.padding(7.dp)
            )
        }
    }
}

@Composable
private fun StatisticsChart() {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        factory = { context ->
            BarChart(context).apply {
                initBarChart()
            }
        },
        update = { view -> }
    )
}

@Composable
private fun LastStatistics() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "This week",
            color = Color(0xFF171717),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = "View all",
            color = Color(0xFF6E6E6E),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { }
        )
    }

    Spacer(Modifier.height(20.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = com.kproject.cleidesigns.core.commom.R.drawable.ic_call_received),
            contentDescription = "Expenses",
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(Color.Black),
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .rotate(-90f)
                .background(color = Color(0xFFF1F1F9), shape = CircleShape)
        )

        Spacer(Modifier.width(10.dp))

        Column {
            Text(
                text = "Care cosmetics",
                color = Color(0xFF171717),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Jan 21, 2022",
                color = Color(0xFF6E6E6E),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.weight(1f))

        Text(
            text = "- $ 60.3",
            color = Color(0xFF171717),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun BottomNavigationView(
    items: List<BottomNavigationItem>,
    modifier: Modifier = Modifier,
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Color(0xFF929292),
    initialSelectedItemIndex: Int = 1
) {
    var selectedItemIndex by remember { mutableIntStateOf(initialSelectedItemIndex) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationViewItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    selectedItemIndex = index
                }
            )
        }
    }
}

@Composable
private fun BottomNavigationViewItem(
    item: BottomNavigationItem,
    isSelected: Boolean = false,
    activeTextColor: Color = Color(0xFF070707),
    inactiveTextColor: Color = Color(0xFF929292),
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onItemClick() }
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            tint = if (isSelected) activeTextColor else inactiveTextColor
        )

        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Design3Compose()
}

data class BottomNavigationItem(
    val title: String,
    @DrawableRes val icon: Int
)