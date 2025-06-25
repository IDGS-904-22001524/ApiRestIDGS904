package com.waldoz_x.apirestidgs904

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class StudentViewModel: ViewModel() {

    //Variable de estado mutable
    //Cuando cambia recompone los componentes del estado

    var state by mutableStateOf(StudentState())
        //Para que el setter sea privado
        private set

    var response:List<Student> by mutableStateOf(emptyList())
        private set


    init {
        //Corrutina para viewModel, se cancela cuando ViewModel es Limpiado
        //Corrutina, programacion asincrona
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                students = emptyList()
            )
            try {
                // Llama a la API para obtener los estudiantes
                val students = ApiService.getInstance().getStudents()
                response = students
                state = state.copy(
                    isLoading = false,
                    students = students
                )
            } catch (e: Exception) {
                // Maneja el error, por ejemplo, deja la lista vacía y quita el loading
                state = state.copy(
                    isLoading = false,
                    students = emptyList()
                )
            }
        }
    }
}
