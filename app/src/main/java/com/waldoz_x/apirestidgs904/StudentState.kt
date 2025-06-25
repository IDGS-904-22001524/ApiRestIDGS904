package com.waldoz_x.apirestidgs904

data class StudentState (
    val students: List<Student> = emptyList(),
    val isLoading: Boolean = false // Corrected: Replaced non-breaking space with a regular space
)