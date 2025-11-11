package com.example.androidpractice.ui.todo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.room.Room
import com.example.androidpractice.data.repository.TodoRepository
import com.example.androidpractice.db.room.AppDatabase
import com.example.androidpractice.model.Todo

@Composable
fun TodoScreen() {

    val context = LocalContext.current
    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "Todo db"
    ).build()

    val viewModel: TodoViewModel = remember {
        TodoViewModel(TodoRepository(db.todoDao()))
    }

    val uiState by viewModel.uiState.collectAsState()

    val showAddTodoDialog = remember { mutableStateOf(false) }
    val titleInput = remember { mutableStateOf("") }
    val contentInput = remember { mutableStateOf("") }

    if (showAddTodoDialog.value) {
        Dialog(onDismissRequest = { showAddTodoDialog.value = false }) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(24.dp)
            ) {
                Column {
                    TextField(
                        value = titleInput.value,
                        onValueChange = { titleInput.value = it },
                        label = { Text("Title") },
                    )
                    Spacer(Modifier.height(16.dp))
                    TextField(
                        value = contentInput.value,
                        onValueChange = { contentInput.value = it },
                        label = { Text("Content") },
                    )
                    Spacer(Modifier.height(24.dp))
                    Row {
                        TextButton(onClick = { showAddTodoDialog.value = false }) {
                            Text("취소")
                        }
                        TextButton(onClick = {
                            viewModel.onIntent(
                                TodoIntent.AddTodo(
                                    title = titleInput.value,
                                    content = contentInput.value
                                )
                            )
                            showAddTodoDialog.value = false
                            titleInput.value = ""
                            contentInput.value = ""
                        }) {
                            Text("확인")
                        }
                    }
                }
            }
        }
    }

    Box(Modifier.fillMaxSize()) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(160.dp),
                modifier = Modifier.padding(paddingValues),
            ) {
                items(uiState.todos.size) { index ->
                    TodoNote(uiState.todos[index], modifier = Modifier.padding(8.dp))
                }
            }
        }

        FloatingActionButton(
            onClick = {
                showAddTodoDialog.value = true
            },
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .shadow(8.dp, RoundedCornerShape(50))
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = Color.White
            )
        }
    }
}

@Composable
fun TodoNote(
    todo: Todo,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .shadow(1.dp, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFFFF176))
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = todo.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = todo.content
            )
        }
    }
}

@Preview()
@Composable
fun TodoScreenPreview() {
    TodoScreen()
}

@Preview()
@Composable
fun TodoNotePreview() {
    TodoNote(todo = Todo(title = "test", content = "content Test "), Modifier)
}