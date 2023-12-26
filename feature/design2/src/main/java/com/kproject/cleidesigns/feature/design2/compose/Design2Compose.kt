package com.kproject.cleidesigns.feature.design2.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.feature.design2.R
import com.kproject.cleidesigns.feature.design2.model.TravelBuddy
import com.kproject.cleidesigns.feature.design2.model.placeList
import com.kproject.cleidesigns.feature.design2.model.travelBuddyList

@Composable
internal fun Design2Compose() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // TopBar components
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF2E2A72),
                    shape = RoundedCornerShape(bottomEnd = 28.dp, bottomStart = 28.dp)
                )
        ) {
            TopBarActionIcons(modifier = Modifier.align(Alignment.TopEnd))

            Image(
                painter = painterResource(id = R.drawable.ic_custom_hand),
                contentDescription = "Hand icon",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(150.dp)
            )

            Column {
                Text(
                    text = "Welcome,",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 22.dp, top = 90.dp)
                )

                Text(
                    text = "Charlie",
                    color = Color(0xFFFEC242),
                    fontSize = 32.sp,
                    modifier = Modifier
                        .padding(start = 22.dp)
                )

                Spacer(Modifier.height(24.dp))

                SearchTextField(
                    modifier = Modifier.padding(horizontal = 24.dp)
                )

                Spacer(Modifier.height(30.dp))
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(22.dp)
        ) {
            item {
                Text(
                    text = "Saved Places",
                    color = Color(0xFF403F3F),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }

            val columns = 2
            val rows = if (placeList.isEmpty()) 0 else 1 + (placeList.count() - 1) / columns
            /**
             * Implementation of a lazy vertical grid. LazyVerticalGrid was not used
             * here because it causes bugs when used in a scrollable Column/LazyColumn.
             */
            items(rows) { rowIndex ->
                Row {
                    for (columnIndex in 0 until columns) {
                        val itemIndex = rowIndex * columns + columnIndex
                        if (itemIndex < placeList.count()) {
                            Card(
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(10.dp)
                                    .clickable { }
                            ) {
                                Box {
                                    Image(
                                        painter = painterResource(id = placeList[itemIndex].image),
                                        contentDescription = "",
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .aspectRatio(1f)
                                    )

                                    Text(
                                        text = placeList[itemIndex].name,
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier
                                            .padding(start = 12.dp, top = 40.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item {
                Text(
                    text = "Travel Buddies",
                    color = Color(0xFF403F3F),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 22.dp)
                )

                // Travel buddy list
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                ) {
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, Color(0xFFC3C3C3)),
                        modifier = Modifier
                            .size(120.dp)
                            .padding(start = 8.dp, end = 12.dp)
                            .aspectRatio(1f),
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = com.kproject.cleidesigns.core.commom.R.drawable.ic_add),
                            contentDescription = null,
                            tint = Color.DarkGray
                        )
                    }

                    TravelBuddyList()
                }
            }
        }
    }
}

@Composable
private fun TopBarActionIcons(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(22.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_custom_notification),
            contentDescription = "",
            modifier = Modifier
                .clickable {}
        )
        Spacer(Modifier.width(22.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_custom_menu),
            contentDescription = "",
            modifier = Modifier
                .clickable {}
        )
    }
}

@Composable
private fun SearchTextField(
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(
        value = searchText,
        onValueChange = { value ->
            searchText = value
        },
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        label = { Text(text = "Search") },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = com.kproject.cleidesigns.core.commom.R.drawable.ic_search),
                contentDescription = null,
                tint = Color.White
            )
        },
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            cursorColor = Color.White,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFFCDCDCD),
            unfocusedIndicatorColor = Color(0xFFCDCDCD),
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
private fun TravelBuddyList() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        itemsIndexed(travelBuddyList) { position, travelBuddy ->
            val cardBackgroundColor = if ((position % 2) == 0) {
                Color(0xFF00664F)
            } else {
                Color(0xFF9BA1FF)
            }
            TravelBuddyListItem(
                travelBuddy = travelBuddy,
                cardBackgroundColor = cardBackgroundColor
            )
        }
    }
}

@Composable
private fun TravelBuddyListItem(
    travelBuddy: TravelBuddy,
    cardBackgroundColor: Color
) {
    val travelBuddyStatus = if (travelBuddy.isFriend) "Friend" else "Unknown"
    Card(
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundColor
        ),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 12.dp)
        ) {
            Column {
                Text(
                    text = "Name",
                    color = Color.White,
                    fontSize = 14.sp,
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = travelBuddy.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Age",
                    color = Color.White,
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = travelBuddy.age.toString(),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Status",
                    color = Color.White,
                    fontSize = 14.sp
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = travelBuddyStatus,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(Modifier.height(12.dp))
            }

            Spacer(Modifier.width(14.dp))

            Image(
                painter = painterResource(id = travelBuddy.personImage),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(150.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MaterialTheme {
        Design2Compose()
    }
}