package com.kproject.cleidesigns.feature.design4.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kproject.cleidesigns.feature.design4.R
import com.kproject.core.common.theme.CleidesignsTheme

@Composable
internal fun Design4Compose() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val primaryCircleColor = colorResource(id = R.color.primary_circle)
    val secondaryCircleColor = colorResource(id = R.color.secondary_circle)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background))
            .drawBehind {
                drawCircles(
                    primaryCircleColor = primaryCircleColor,
                    secondaryCircleColor = secondaryCircleColor
                )
            }
    ) {
        Text(
            text = stringResource(R.string.login),
            color = colorResource(id = R.color.main_text),
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(34.dp))

        Column {
            val loginIconSize = 50
            Box {
                Column(
                    modifier = Modifier.padding(end = loginIconSize.dp)
                ) {
                    LoginTextField(
                        text = username,
                        onTextChange = { username = it },
                        hint = stringResource(R.string.username),
                        leadingIcon = R.drawable.ic_outline_person,
                        textAndIconColor = colorResource(id = R.color.main_text),
                        shape = RoundedCornerShape(topEnd = 50.dp)
                    )

                    LoginTextField(
                        text = password,
                        onTextChange = { password = it },
                        hint = stringResource(R.string.password),
                        leadingIcon = R.drawable.ic_key,
                        textAndIconColor = colorResource(id = R.color.main_text),
                        shape = RoundedCornerShape(bottomEnd = 50.dp),
                        keyboardType = KeyboardType.Password
                    )
                }

                IconButton(
                    onClick = {},
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorResource(id = R.color.login_icon_background)
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = loginIconSize.div(2).dp)
                        .size(loginIconSize.dp),
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_right_alt),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Spacer(Modifier.height(18.dp))

            Text(
                text = stringResource(id = R.string.forgot_password),
                color = colorResource(id = R.color.forgot_password_text),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(end = 80.dp)
                    .align(Alignment.End)
                    .clickable {}
            )

            Spacer(Modifier.height(36.dp))

            Button(
                onClick = {},
                shape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.textfield_background)
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 12.dp,
                    pressedElevation = 28.dp,
                    focusedElevation = 28.dp
                ),
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun LoginTextField(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    hint: String,
    @DrawableRes leadingIcon: Int,
    textAndIconColor: Color,
    shape: Shape,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    val isPasswordField = remember { (keyboardType == KeyboardType.Password) }
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        placeholder = {
            Text(
                text = hint,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        },
        leadingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(id = leadingIcon),
                contentDescription = hint
            )
        },
        visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = shape,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = textAndIconColor,
            unfocusedTextColor = textAndIconColor,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = colorResource(id = R.color.textfield_border),
            unfocusedIndicatorColor = colorResource(id = R.color.textfield_border),
            focusedLabelColor = textAndIconColor,
            unfocusedLabelColor = textAndIconColor,
            focusedPlaceholderColor = textAndIconColor,
            unfocusedPlaceholderColor = textAndIconColor,
            focusedLeadingIconColor = textAndIconColor,
            unfocusedLeadingIconColor = textAndIconColor,
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(66.dp)
    )
}

private fun DrawScope.drawCircles(
    primaryCircleColor: Color,
    secondaryCircleColor: Color,
) {
    drawCircle(
        color = primaryCircleColor,
        radius = 150.dp.toPx(),
        style = Fill,
        center = Offset(x = 0f, y = 0f)
    )

    drawCircle(
        color = primaryCircleColor,
        radius = 120.dp.toPx(),
        style = Fill,
        center = Offset(x = 120.dp.toPx(), y = -30.dp.toPx())
    )

    drawCircle(
        color = secondaryCircleColor,
        radius = 150.dp.toPx(),
        style = Fill,
        center = Offset(x = size.width + 50.dp.toPx(), y = size.height)
    )

    drawCircle(
        color = secondaryCircleColor,
        radius = 120.dp.toPx(),
        style = Fill,
        center = Offset(x = size.width - 150.dp.toPx(), y = size.height + 50.dp.toPx())
    )
}

@Preview
@Composable
private fun Preview() {
    CleidesignsTheme {
        Design4Compose()
    }
}