package com.example.harakaway.ui.screens.admin

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.OpenableColumns
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.harakaway.R
import com.example.harakaway.data.models.Job
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminForm(
    innerPadding: PaddingValues, navController: NavHostController,
    adminViewModel: AdminViewModel = viewModel(),
    modifier: Modifier
){
    var progress = adminViewModel.uploadProgress.collectAsState()

    var companyName by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }
    var jobCategory by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val context = LocalContext.current
    val launcher = launchFilePicker(context,adminViewModel)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(vertical = 32.dp,horizontal = 16.dp)
            .fillMaxHeight()
    ) {
        OutlinedTextField(
            value = companyName,
            label = { Text(text = "Company Name") },
            onValueChange = {
                companyName = it
            },
            maxLines = 3,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        OutlinedTextField(
            value =title,
            label = { Text(text = "Title") },
            onValueChange = {
                title = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        OutlinedTextField(
            value =jobCategory,
            label = { Text(text = "Job Category") },
            onValueChange = {
                jobCategory = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        OutlinedTextField(
            value =salary,
            label = { Text(text = "Salary") },
            onValueChange = {
                salary = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        OutlinedTextField(
            value =location,
            label = { Text(text = "Location") },
            onValueChange = {
               location = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        OutlinedTextField(
            value =status,
            label = { Text(text = "Status") },
            onValueChange = {
               status = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                        type = "*/*" // or "image/*" or "video/*"
                        addCategory(Intent.CATEGORY_OPENABLE)
                    }

                    launcher.launch(intent)
                }
            ) {
                Column {
                    Spacer(modifier = Modifier.padding(vertical = 2.dp))
                    Icon(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "Camera button",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.padding(vertical = 2.dp))
                    Text(text = "Select Image")
                    Spacer(modifier = Modifier.padding(vertical = 2.dp))
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text("Progress: ${progress.value}%")
        }
        Spacer(modifier = Modifier.padding(vertical = 8.dp))
        Button(
            onClick = {
                var result =   adminViewModel.createJob(
                  companyName= companyName,
                    title = title,
                    jobCategory = jobCategory,
                    salary = salary,
                    location = location,
                    status = status,
                    image_url = ""
                    )
                if (result!==null){
                    Toast.makeText(context, "${title} task created!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(
                text = "Create task"
            )
        }

    }
}





fun getFileNameFromUri(context: Context, uri: Uri): String? {
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    return cursor?.use {
        val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        if (it.moveToFirst() && nameIndex != -1) {
            it.getString(nameIndex)
        } else null
    }
}

//  get mime type
fun getExtensionFromUri(context: Context, uri: Uri): String? {
    val mimeType = context.contentResolver.getType(uri)
    return MimeTypeMap.getSingleton().getExtensionFromMimeType(mimeType)
}


@Composable
fun launchFilePicker(context: Context,todoViewModel: AdminViewModel): ManagedActivityResultLauncher<Intent, ActivityResult> {
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val uri = result.data?.data
        if (uri != null) {
            val inputStream = context.contentResolver.openInputStream(uri)
            val fileBytes = inputStream?.readBytes()
            val fileName = getFileNameFromUri(context, uri) ?: "upload.${
                getExtensionFromUri(
                    context,
                    uri
                ) ?: "dat"
            }"

            if (fileBytes != null) {
                todoViewModel.insertImage(fileName, fileBytes)
            }
        }
    }
    return launcher
}

fun createReturnJob(image_url: String,companyName: String, title: String,jobCategory: String,salary: String,location: String,status: String): Job{
    var job = Job(
        image_url = image_url,
        companyName = companyName,
        title = title,
        jobCategory = jobCategory,
        salary = salary,
        location = location,
        status = status,
    )
    return job
}

