package com.sergio.bootcampfinalproject.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.bootcampfinalproject.R
import com.sergio.bootcampfinalproject.ui.theme.BgColor
import com.sergio.bootcampfinalproject.ui.theme.Primary
import com.sergio.bootcampfinalproject.ui.theme.Secondary
import com.sergio.bootcampfinalproject.ui.theme.TextColor

@Composable
fun NormalTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun InputTextField(labelValue: String, icon : ImageVector){
    var textValue by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor)
            .clip(RoundedCornerShape(5.dp)),
        label = { Text(text=labelValue) },
        value = textValue,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions.Default,
        onValueChange = { newValue ->
            textValue = newValue
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Small Icon",
                modifier = Modifier.size(25.dp),

                )
        }
    )
}

@Composable
fun InputPasswordField(labelValue: String, icon : ImageVector){
    var password by remember {
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor)
            .clip(RoundedCornerShape(5.dp)),
        label = { Text(text=labelValue) },
        value = password,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        onValueChange = { newValue ->
            password = newValue
        },
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Small Icon",
                modifier = Modifier.size(25.dp),
                )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible) {
                painterResource(id = R.drawable.visibility)
            } else {
                painterResource(id = R.drawable.visibility_off)
            }

            val iconDesc = if (passwordVisible) {
                "Hide password"
            } else {
                "Show password"
            }

            IconButton(onClick = {
                passwordVisible = !passwordVisible
            }){
                Icon(
                    painter = iconImage,
                    contentDescription = iconDesc,
                    modifier = Modifier.size(25.dp),
                )
            }
        },
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
        .heightIn(min = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ){

        var checkedState by remember { mutableStateOf(false) }

        Checkbox(
            checked = checkedState,
            onCheckedChange = { isChecked ->
                checkedState = isChecked
            },
        )
        Text(
            text = "By continuing you accept our Privacy Policy and Term of Use",
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal
            ),
            color = TextColor,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonComponent() {
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary)),
                shape = RoundedCornerShape(50.dp)
            ),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Register",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}




