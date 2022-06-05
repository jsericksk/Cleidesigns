package com.kproject.cleidesigns.ui.fragments.design2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.kproject.cleidesigns.R
import com.kproject.cleidesigns.utils.Constants

@Composable
fun Design2Compose() {
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
            // TopBar action icons
            Column(Modifier.align(Alignment.TopEnd)) {
                TopBarActionIcons()
            }

            Image(
                painter = painterResource(id = R.drawable.ic_design1_hand),
                contentDescription = "",
                modifier = Modifier
                    .size(150.dp)
                    .padding(end = 22.dp)
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

                SearchTextField()
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

            val listOfPlaces = Design2Utils.createListOfPlaces()
            val columns = 2
            val rows = if (listOfPlaces.count() == 0) 0 else 1 + (listOfPlaces.count() - 1) / columns
            /**
             * Implementation of a lazy vertical grid. LazyVerticalGrid was not used
             * here because it causes bugs when used in a scrollable Column/LazyColumn.
             */
            items(rows) { rowIndex ->
                Row {
                    for (columnIndex in 0 until columns) {
                        val itemIndex = rowIndex * columns + columnIndex
                        if (itemIndex < listOfPlaces.count()) {
                            Card(
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(10.dp)
                                    .clickable { }
                            ) {
                                Image(
                                    painter = painterResource(id = listOfPlaces[itemIndex].image),
                                    contentDescription = "",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .aspectRatio(1f)
                                )

                                Text(
                                    text = listOfPlaces[itemIndex].name,
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
                        onClick = { },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .size(120.dp)
                            .padding(start = 8.dp, end = 12.dp)
                            .aspectRatio(1f)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_design2_add),
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
private fun TopBarActionIcons() {
    val defaultPadding = 22.dp
    Row {
        /**
         * Used Image instead of IconButton to keep icon color.
         */
        Image(
            painter = painterResource(id = R.drawable.ic_design2_notification),
            contentDescription = "",
            modifier = Modifier
                .padding(top = defaultPadding, end = defaultPadding)
                .clickable { }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_design2_menu),
            contentDescription = "",
            modifier = Modifier
                .padding(top = defaultPadding, end = defaultPadding)
                .clickable { }
        )
    }
}

@Composable
private fun SearchTextField() {
    val textFieldValue = remember { mutableStateOf("") }
    OutlinedTextField(
        value = textFieldValue.value,
        onValueChange = { value ->
            textFieldValue.value = value
        },
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        label = { Text(text = "Search") },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_design2_search),
                contentDescription = null,
                tint = Color.White
            )
        },
        shape = CircleShape.copy(CornerSize(16.dp)),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.White,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFFCDCDCD),
            unfocusedIndicatorColor = Color(0xFFCDCDCD),
            focusedLabelColor = Color(0xFFCDCDCD),
            unfocusedLabelColor = Color(0xFFCDCDCD),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(22.dp)
    )
}

@Composable
private fun TravelBuddyList() {
    val travelBuddyList = Design2Utils.createTravelBuddyList()
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
    val status = travelBuddy.status
    var travelBuddyStatus = ""
    if (status == Constants.Design2.STATUS_FRIEND) {
        travelBuddyStatus = "Friend"
    } else if (status == Constants.Design2.STATUS_UNKNOWN) {
        travelBuddyStatus = "Unknown"
    }

    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = cardBackgroundColor,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, top = 12.dp)
        ) {
            Column {
                Text(
                    text = "Name",
                    color = Color.White,
                    fontSize = 14.sp,
                )

                Text(
                    text = travelBuddy.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 6.dp)
                )

                Text(
                    text = "Age",
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )

                Text(
                    text = travelBuddy.age.toString(),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 6.dp)
                )

                Text(
                    text = "Status",
                    color = Color.White,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )

                Text(
                    text = travelBuddyStatus,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 6.dp, bottom = 12.dp)
                )
            }

            Image(
                painter = painterResource(id = travelBuddy.personImage),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(width = 150.dp, height = 150.dp)
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