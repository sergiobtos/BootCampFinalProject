package com.sergio.bootcampfinalproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.ktx.Firebase
import com.google.firebase.database.ktx.database
import com.sergio.bootcampfinalproject.app.TravelEarnerApp
import com.sergio.bootcampfinalproject.ui.theme.BootCampFinalProjectTheme
import java.time.LocalDate

data class Ad(
    val advertiserName: String,
    val countryFrom: String,
    val countryTo: String,
    val items: String,
    val price: String,
    val tripDate: String // You can use LocalDate if needed
)

class MainActivity : ComponentActivity() {
    private val registrationViewModel: RegistrationViewModel by viewModels()
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Firebase.database.reference
        registrationViewModel.setDatabaseReference(database)
        setContent {
            BootCampFinalProjectTheme{
                TravelEarnerApp(registrationViewModel)
            }
        }
    }
}

class RegistrationViewModel : ViewModel(){
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var database: DatabaseReference

    fun setDatabaseReference(database: DatabaseReference) {
        this.database = database
    }

    fun register(
        firstName: String,
        lastName: String,
        countryOfResidence: String,
        email: String, password: String,
        onResult: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val userId = task.result?.user?.uid ?: ""
                    saveUserToDatabase(
                        userId,
                        firstName,
                        lastName,
                        countryOfResidence,
                        email
                    )
                    onResult("Registration successful")
                } else {
                    val exception = task.exception
                    if (exception is FirebaseAuthUserCollisionException) {
                        onResult("Registration failed: Email already in use")
                    } else {
                        onResult("Registration failed: ${exception?.message}")
                    }
                }
            }
    }

    fun saveUserToDatabase(
        userId: String,
        firstName: String,
        lastName: String,
        countryOfResidence: String,
        email: String,
    ){
        val newUser = mapOf(
            "userId" to userId,
            "firstName" to firstName,
            "lastName" to lastName,
            "countryOfResidence" to countryOfResidence,
            "email" to email
        )

        database.child("users").push().setValue(newUser).addOnSuccessListener{
            Log.d("FirebaseData","Success saving")

        }.addOnFailureListener { e-> Log.d("Firebase","Error $e") }
    }

    fun saveUserAdToDatabase(ad : Ad) {
        val user = auth.currentUser
        if( user != null) {
            val userId = user.uid
            database
                .child("users")
                .child(userId)
                .child("ads")
                .push()
                .setValue(ad)
                .addOnSuccessListener { Log.d("FirebaseData", "Ad successfully saved")  }
                .addOnFailureListener{ e -> Log.d("Firebase", "Error saving ad: $e") }
        }else {
            Log.d("Firebase", "Error: No logged-in user")
        }
    }

    /*
    fun register(email: String, password: String, onResult: (String) -> Unit){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                task ->
                if(task.isSuccessful){
                    onResult("Registration successful")
                } else {
                    onResult("Registration failed: ${task.exception?.message}")
                }
            }
    }
*/

    fun signInWithEmailAndPassword(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful) {
                    callback(true, null)
                } else {
                    callback(false, task.exception?.message)
                }
            }
    }
}


