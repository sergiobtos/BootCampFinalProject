package com.sergio.bootcampfinalproject.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergio.bootcampfinalproject.R
import com.sergio.bootcampfinalproject.ui.theme.BgColor
import com.sergio.bootcampfinalproject.ui.theme.GrayColor
import com.sergio.bootcampfinalproject.ui.theme.Primary
import com.sergio.bootcampfinalproject.ui.theme.Secondary
import com.sergio.bootcampfinalproject.ui.theme.TextColor

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    labelValue: String,
    icon : ImageVector,
    value: String,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor)
            .clip(RoundedCornerShape(5.dp)),
        label = { Text(text=labelValue) },
        value = value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Small Icon",
                modifier = Modifier.size(25.dp),

                )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputPasswordField(
    labelValue: String,
    icon : ImageVector,
    value: String,
    onValueChange: (String) -> Unit
){
    val localFocusManager = LocalFocusManager.current
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor)
            .clip(RoundedCornerShape(5.dp)),
        label = { Text(text=labelValue) },
        value = value,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = { localFocusManager.clearFocus() }
        ),
        maxLines = 1,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = "Small Icon",
                modifier = Modifier.size(25.dp),
                )
        },
        trailingIcon = {
            val iconResource = if (passwordVisible) {
                R.drawable.visibility
            } else {
                R.drawable.visibility_off
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
                    painter = painterResource(id = iconResource),
                    contentDescription = iconDesc,
                    modifier = Modifier.size(25.dp),
                )
            }
        },
        visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckBoxComponent(
    checkedState: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checkedState,
            onCheckedChange = onCheckedChange,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonComponent(
    value: String,
    onButtonClick: () -> Unit
) {
    Button(onClick = { onButtonClick() },
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
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = "or",
            fontSize = 18.sp,
            color = TextColor,
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableTextComponent(
    initialText: String,
    clickableText: String,
    onTextSelected: (String) -> Unit
) {

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Primary))
        {
            pushStringAnnotation(tag = clickableText, annotation = clickableText)
            append(clickableText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
        ),
        text = annotatedString,
        onClick={
                offset -> annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also{span ->
                Log.d("Clickable Text Component", "{${span.item}}")
                if(span.item == clickableText){
                    onTextSelected(span.item)
                }
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnderLinedTextComponent(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textDecoration = TextDecoration.Underline
        ),
        color = GrayColor,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuField(
    labelValue: String,
    options: Array<String>,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BgColor)
            .clip(RoundedCornerShape(5.dp))
            .clickable { expanded = !expanded }
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Icon",
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = labelValue,
                color = Primary,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = selectedOptionText,
                color = Primary,
                modifier = Modifier.weight(2f).padding(8.dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option)},
                    onClick = {
                        selectedOptionText = option
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdItem(
    advertiserName: String,
    countryFrom: String,
    countryTo: String,
    items: String,
    price: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(16.dp)
    ) {
        // Advertiser's Name
        Text(
            text = advertiserName,
            style = MaterialTheme.typography.labelLarge,
            color = Color.Black
        )

        // Destination Country
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "From: $countryFrom To: $countryTo",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        // Items they can bring
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = items,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        // Price
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Price: $price",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )

        // Contact Button
        Spacer(modifier = Modifier.height(8.dp))
        ButtonComponent(
            value = "Contact",
            onButtonClick = {
                // No action for now
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdItemPreview() {
    AdItem(
        advertiserName = "Advertiser's Name",
        countryFrom = "Canada",
        countryTo = "Brazil",
        items = "Items which I can bring",
        price = "$100"
    )
}





