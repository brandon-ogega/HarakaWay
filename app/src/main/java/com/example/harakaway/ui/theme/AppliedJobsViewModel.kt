//package com.example.harakaway.ui.theme
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import com.example.harakaway.data.models.ApplicationStatus
//import com.example.harakaway.data.models.Job
//
//
//class AppliedJobsViewModel: ViewModel(){
//    data class Job(
//        val companyName: String,
//        val title: String,
//        val status: ApplicationStatus
//    )
//    var selectedStatus by mutableStateOf(ApplicationStatus.All)
//        private set
//    var filteredJobs by mutableStateOf(allJobs)
//        private set
//    fun updateStatus(status: ApplicationStatus) {
//        selectedStatus = status
//        filteredJobs = if (status == ApplicationStatus.All) {
//            allJobs
//        } else {
//            allJobs.filter { it.status == status }
//        }
//    }
//
//
//    private val allJobs = listOf(
//        Job("Spotify", "Product Designer", ApplicationStatus.Applied),
//        Job("Google", "UX Designer", ApplicationStatus.Accepted),
//        Job("Apple", "UI Designer", ApplicationStatus.Rejected),
//        Job("Netflix", "Frontend Developer", ApplicationStatus.Applied),
//        Job("Meta", "Product Manager", ApplicationStatus.Accepted)
//    )
//
//}