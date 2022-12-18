package com.demo.suggestionchipsinjetpackcompose.component.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.demo.suggestionchipsinjetpackcompose.ui.theme.Purple80
import com.demo.suggestionchipsinjetpackcompose.ui.theme.PurpleGrey40

@Composable
fun SuggestionChipLayout() {

    var chipsData by remember {
        mutableStateOf(listOf("India", "France", "Spain"))
    }
    var chipsState by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Suggestion Chip Example")
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            chipsData.forEach {
                SuggestionChipEachRow(label = it, selected = it == chipsState) { chip ->
                    chipsState = chip
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestionChipEachRow(
    label: String,
    selected: Boolean,
    onChipChange: (String) -> Unit
) {
    SuggestionChip(
        onClick = {
            if (!selected)
                onChipChange(label)
            else
                onChipChange("")
        },
        label = { Text(text = label) },
        //modifier = Modifier.padding(horizontal = 10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (selected) Purple80 else Color.Transparent
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = if (selected) Color.Transparent else PurpleGrey40
        )
    )

    /*ElevatedSuggestionChip(onClick = { *//*TODO*//* }) {

    }*/
}
