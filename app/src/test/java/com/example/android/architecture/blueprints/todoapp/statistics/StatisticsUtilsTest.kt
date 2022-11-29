package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

 class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // GIVEN
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )
        // WHEN
        val result = getActiveAndCompletedStats(tasks)

        // THEN
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f,result.activeTasksPercent )
    }

     @Test
     fun getActiveAndCompletedStats_both_returnsFortySixty() {

         // Create an active tasks (the false makes this active)
         val tasks = listOf<Task>(
             Task("title", "desc", isCompleted = true),
             Task("title", "desc", isCompleted = true),
             Task("title", "desc", isCompleted = false),
             Task("title", "desc", isCompleted = false),
             Task("title", "desc", isCompleted = false)

         )
         // Call our function
         val result = getActiveAndCompletedStats(tasks)

         // Check the result
         assertEquals(40f, result.completedTasksPercent)
         assertEquals(60f, result.activeTasksPercent)
     }

     @Test
     fun getActiveAndCompletedStats_empty_returnsZero() {

         val tasks = emptyList<Task>()


         val result = getActiveAndCompletedStats(tasks)

         assertEquals(0f, result.completedTasksPercent)
         assertEquals(0f, result.activeTasksPercent)
     }

     @Test
     fun getActiveAndCompletedStats_error_returnsZero() {

         val tasks = null


         val result = getActiveAndCompletedStats(tasks)

         assertEquals(0f, result.completedTasksPercent)
         assertEquals(0f, result.activeTasksPercent)
     }
}