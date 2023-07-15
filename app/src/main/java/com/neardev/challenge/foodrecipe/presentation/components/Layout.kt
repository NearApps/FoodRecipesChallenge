package com.neardev.challenge.foodrecipe.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.decathlon.vitamin.compose.VitaminIcons
import com.decathlon.vitamin.compose.foundation.VitaminTheme
import com.decathlon.vitamin.compose.vitaminicons.Fill
import com.decathlon.vitamin.compose.vitaminicons.Line
import com.decathlon.vitamin.compose.vitaminicons.fill.Alert
import com.decathlon.vitamin.compose.vitaminicons.fill.Mic
import com.decathlon.vitamin.compose.vitaminicons.line.Alert
import com.decathlon.vitamin.compose.vitaminicons.line.ErrorWarning
import com.decathlon.vitamin.compose.vitaminicons.line.Information
import com.neardev.challenge.foodrecipe.R
import com.neardev.challenge.foodrecipe.utilities.preview.PreviewParameterProviderDark

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
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp),
            painter = rememberVectorPainter(image = VitaminIcons.Line.ErrorWarning),
            colorFilter = ColorFilter.tint(VitaminTheme.colors.vtmnContentNegative),
            contentDescription = "Error Icon",
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = text,
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = VitaminTheme.typography.text3,
        )
        TextButton(
            onClick = onClick,
            modifier = Modifier
        ) {
            Text(
                text = textButton,
                style = MaterialTheme.typography.button,
            )
        }
    }
}

@Composable
fun EmptyView(
    text: String,
    textButton: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .height(40.dp)
                .width(40.dp),
            painter = rememberVectorPainter(image = VitaminIcons.Line.Alert),
            colorFilter = ColorFilter.tint(VitaminTheme.colors.vtmnContentInactive),
            contentDescription = "Empty Icon",
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = text,
            color = VitaminTheme.colors.vtmnContentSecondary,
            style = VitaminTheme.typography.text3,
        )
        TextButton(
            onClick = onClick,
            modifier = Modifier
        ) {
            Text(
                text = textButton,
                style = MaterialTheme.typography.button,
            )
        }
    }
}

@Composable
fun LoadingPlaceholder() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            //.background(brush = SolidColor(Color.Black), alpha = 0.2f)
            .fillMaxSize()
            .clickable(false) {}
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun LayoutPreview(
    @PreviewParameter(PreviewParameterProviderDark::class) isDark: Boolean
) {
    VitaminTheme(darkTheme = isDark) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isDark) Color.Black else Color.White)
                .padding(4.dp)
        ) {
            StaggeredVerticalGrid(
                modifier = Modifier.padding(4.dp),
                crossAxisCount = 2,
                spacing = 4.dp
            ) {
                (1..2).forEach { index ->
                    Box(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .clip(MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colors.surface)
                    ) {
                        Text(
                            text = index.toString(),
                            color = VitaminTheme.colors.vtmnContentSecondary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            ErrorView(
                text = "Error",
                textButton = "Retry",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            EmptyView(
                text = "Error",
                textButton = "Retry",
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            LoadingPlaceholder()
        }
    }
}