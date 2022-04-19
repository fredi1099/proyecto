package com.example.proyecto.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Publications(){
    Box(
        modifier = Modifier
            .width(328.dp)
            .height(44.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 17.dp,
                    topEnd = 17.dp,
                    bottomStart = 17.dp,
                    bottomEnd = 17.dp
                )
            )
            .background(
                Color(
                    red = 0.7686274647712708f,
                    green = 0.7686274647712708f,
                    blue = 0.7686274647712708f,
                    alpha = 1f
                )
            ),
        contentAlignment = Alignment.Center,
    ){
        Text(
            text = "user_name",
            textAlign = TextAlign.Center,

            fontSize = 18.880001068115234.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.sp,
            lineHeight = 34.61333465576172.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(94.dp)
                .height(35.dp)
                .alpha(1f),
            color = Color(red = 0.07058823853731155f, green = 0.07058823853731155f, blue = 0.07058823853731155f, alpha = 1f),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        )
    }

    Box(
        modifier = Modifier
            .width(333.dp)
            .height(248.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp,
                    bottomStart = 15.dp,
                    bottomEnd = 15.dp
                )
            )
            .background(
                Color(
                    red = 0.7686274647712708f,
                    green = 0.7686274647712708f,
                    blue = 0.7686274647712708f,
                    alpha = 1f
                )
            )
    )
    ShowMore("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean sodales nisi quis magna varius, ac sodales libero aliquam. Sed facilisis malesuada sagittis. Proin non condimentum felis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam ipsum enim, scelerisque in elit ut, accumsan malesuada augue. Cras nec dolor quis ex mattis mollis eu id massa. Phasellus lobortis neque quis tellus mollis, at placerat sapien aliquam. Donec faucibus sem at ullamcorper fermentum. Phasellus aliquam metus massa, non ornare justo vehicula ut. Quisque vel ipsum vitae mi iaculis auctor. Nulla non ex odio. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nam sit amet lectus nisl. Mauris id bibendum ex. Curabitur ultricies augue non eros porttitor imperdiet. Nam rutrum tincidunt dolor a dapibus.")
}

@Composable
fun ShowMore(
    text: String,
    modifier: Modifier = Modifier,
    minimizedMaxLines: Int = 1,){
    var cutText by remember(text) { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
    val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }

    // getting raw values for smart cast
    val textLayoutResult = textLayoutResultState.value
    val seeMoreSize = seeMoreSizeState.value
    val seeMoreOffset = seeMoreOffsetState.value

    LaunchedEffect(text, expanded, textLayoutResult, seeMoreSize) {
        val lastLineIndex = minimizedMaxLines - 1
        if (!expanded && textLayoutResult != null && seeMoreSize != null
            && lastLineIndex + 1 == textLayoutResult.lineCount
            && textLayoutResult.isLineEllipsized(lastLineIndex)
        ) {
            var lastCharIndex = textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
            var charRect: Rect
            do {
                lastCharIndex -= 1
                charRect = textLayoutResult.getCursorRect(lastCharIndex)
            } while (
                charRect.left > textLayoutResult.size.width - seeMoreSize.width
            )
            seeMoreOffsetState.value = Offset(charRect.left, charRect.bottom - seeMoreSize.height)
            cutText = text.substring(startIndex = 0, endIndex = lastCharIndex)
        }
    }

    Box(modifier) {
        Text(
            text = cutText ?: text,
            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
            overflow = TextOverflow.Ellipsis,
            onTextLayout = { textLayoutResultState.value = it },
        )
        if (!expanded) {
            val density = LocalDensity.current
            Text(
                "... ver más",
                onTextLayout = { seeMoreSizeState.value = it.size },
                modifier = Modifier
                    .then(
                        if (seeMoreOffset != null)
                            Modifier.offset(
                                x = with(density) { seeMoreOffset.x.toDp() },
                                y = with(density) { seeMoreOffset.y.toDp() },
                            )
                        else
                            Modifier
                    )
                    .clickable {
                        expanded = true
                        cutText = null
                    }
                    .alpha(if (seeMoreOffset != null) 1f else 0f)
            )
        }
    }
}

@Composable
fun Home(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(
                RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
            .background(Color(red = 1f, green = 1f, blue = 1f, alpha = 1f))
            .padding(start = 32.dp, top = 0.dp, end = 32.dp, bottom = 55.dp)
            .alpha(1f)
            .verticalScroll(rememberScrollState()),
    ) {
        Publications()
        Publications()
        Publications()
    }


}