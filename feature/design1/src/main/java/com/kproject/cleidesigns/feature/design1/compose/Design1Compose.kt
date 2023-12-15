package com.kproject.cleidesigns.feature.design1.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.feature.design1.R
import com.kproject.cleidesigns.core.commom.R as CR

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
                painter = painterResource(id = R.drawable.img_sample),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            IconButton(
                onClick = {},
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = CR.drawable.ic_arrow_back),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(modifier = Modifier.padding(22.dp)) {
                val avenirFontFamily = FontFamily(Font(R.font.avenirltstd_book, FontWeight.Normal))
                Text(
                    text = "H I S A K O",
                    color = Color(0xFF020102),
                    fontSize = 20.sp,
                    fontFamily = avenirFontFamily,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "\$249",
                    color = Color(0xFF020102),
                    fontSize = 20.sp,
                    fontFamily = avenirFontFamily,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.item_text),
                    color = Color(0xFF101010),
                    fontSize = 18.sp,
                    fontFamily = avenirFontFamily,
                )
                Spacer(Modifier.height(22.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD5A587),
                            disabledContainerColor = Color(0xFFD5A587)
                        ),
                        shape = RoundedCornerShape(4.dp),
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
                    Spacer(Modifier.width(12.dp))
                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(4.dp),
                        border = BorderStroke(1.dp, Color(0xFFC3C3C3)),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(60.dp),
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = CR.drawable.ic_favorite),
                            contentDescription = null,
                            tint = Color(0xFF0B0B0B),
                            modifier = Modifier.size(26.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MaterialTheme {
        Design1Compose()
    }
}