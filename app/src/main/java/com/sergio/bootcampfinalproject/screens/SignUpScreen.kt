package com.sergio.bootcampfinalproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sergio.bootcampfinalproject.components.CheckBoxComponent
import com.sergio.bootcampfinalproject.components.HeadingTextComponent
import com.sergio.bootcampfinalproject.components.InputPasswordField
import com.sergio.bootcampfinalproject.components.InputTextField
import com.sergio.bootcampfinalproject.components.NormalTextComponent
import com.sergio.bootcampfinalproject.navigation.SystemBackButtonHandler
import com.sergio.bootcampfinalproject.navigation.TravelEarnerAppRouter


@Composable
fun SignUpScreen(){
    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            NormalTextComponent("Hey there, ")
            HeadingTextComponent("Create an Account")
            Spacer(modifier = Modifier.height(20.dp))
            InputTextField(labelValue="First Name", icon=Icons.Outlined.AccountCircle)
            InputTextField(labelValue="Last Name", icon=Icons.Outlined.AccountCircle)
            InputTextField(labelValue="Email", icon=Icons.Outlined.Email)
            InputPasswordField(labelValue="Password", icon=Icons.Outlined.Lock)
            CheckBoxComponent()
            Spacer(modifier = Modifier.height(40.dp))
        }

    }

    SystemBackButtonHandler{
        //TravelEarnerAppRouter.navigateTo(Screen.LoginScreen)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    SignUpScreen()
}