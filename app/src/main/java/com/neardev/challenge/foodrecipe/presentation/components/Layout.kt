package com.neardev.challenge.foodrecipe.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    crossAxisCount: Int,
    spacing: Dp = 0.dp,
    content: @Composable () -> Unit,
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        check(constraints.hasBoundedWidth) {
            "Unbounded width not supported"
        }
        val spacingWidth = spacing.roundToPx() / crossAxisCount
        val columnWidth = constraints.maxWidth / crossAxisCount
        val itemConstraints =
            constraints.copy(maxWidth = columnWidth - spacingWidth)
        val colHeights = IntArray(crossAxisCount) { 0 } // track each column's height
        val placeables = measurables.map { measurable ->
            val column = shortestColumn(colHeights)
            val placeable = measurable.measure(itemConstraints)
            colHeights[column] += placeable.height
            placeable
        }

        val height = colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val colY = IntArray(crossAxisCount) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val column = shortestColumn(colY)
                val offset = if (column > 0) spacingWidth else 0

                placeable.place(
                    x = (columnWidth + offset) * column,
                    y = colY[column]
                )
                colY[column] += placeable.height
            }
        }
    }
}

private fun shortestColumn(colHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}


@Composable
fun ErrorView(
    text: String,
    textButton: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 8.dp)
        )
        TextButton(onClick = onClick) {
            Text(
                text = textButton,
                style = MaterialTheme.typography.button,
            )
        }
    }
}

@Composable
fun LoadingPlaceholder() {
    StaggeredVerticalGrid(
        crossAxisCount = 2,
        spacing = 16.dp,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        (1..10).map {
            Column(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colors.background)
            ) {
                Box(
                    Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .aspectRatio(1f)
                        .background(MaterialTheme.colors.onBackground.copy(alpha = 0.08f))
                )
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.onBackground.copy(alpha = 0.08f))
                )
            }
        }
    }
}