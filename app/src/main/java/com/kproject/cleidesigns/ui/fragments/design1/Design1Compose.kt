package com.kproject.cleidesigns.ui.fragments.design1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.R

@Composable
fun Design1Compose() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_design1),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            IconButton(
                onClick = { },
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_design1_arrow_back),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

        Card(
            backgroundColor = Color.White,
            elevation = 0.dp
        ) {
            Column(modifier = Modifier.padding(22.dp)) {
                val avenirFontFamily =
                        FontFamily(Font(R.font.design1_avenirltstd_book, FontWeight.Normal))
                Text(
                    text = "H I S A K O",
                    color = Color(0xFF020102),
                    fontSize = 20.sp,
                    fontFamily = avenirFontFamily,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "\$249",
                    color = Color(0xFF020102),
                    fontSize = 20.sp,
                    fontFamily = avenirFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = stringResource(id = R.string.design1_text),
                    color = Color(0xFF101010),
                    fontSize = 18.sp,
                    fontFamily = avenirFontFamily,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                ) {
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFFD5A587)
                        ),
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .weight(1f),
                    ) {
                        Text(
                            text = "BUY NOW",
                            color = Color.White
                        )
                    }

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .height(60.dp)
                            .padding(start = 12.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_design1_favorite),
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}

/**
@Preview(showBackground = true)
@Composable
fun DesignComposePreviou() {
    MaterialTheme {
        Design1Compose()
    }
}*/