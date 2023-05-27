package com.android.jetpackcomposedemo.data.list

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3. Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview. Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ascendion.base.theme.appTypography
import com.ascendion.base.theme.values.defaultAppColors
import com.ascendion.base.utils.HorizontalSpacer

@Composable
fun PeoplelistPage(
viewModel: PeopleListViewModel = hiltViewModel(),
onNavigateToDetail: (url: String) -> Unit
){
when (val pageUi = viewModel.pageState.value)
    PeopleListPageUistate. LOADING-> DefaultLoaderScreen(
    is PeopleListPageUiState.SUCCESS -> {
        LazyVerticalGrid(
            columns GridCells . Fixed (count: 1),
        contentPadding = PaddingValues(4.dp)
        ){
        pageUi.list.forEach { viewData ->
            item {
                PeopleListCard(viewData = viewData, onPeopleCardClick = {
                    onNavigateToDetail(it)

                    })
                }
            }
        }
    }

    is PeoplelistPageUiState.FAILURE -> DefaultErrorScreen (msg = pageUi.msg

    }
}
@optIn(ExperimentalMaterial3Api::class)
@Composable
fun PeopleListCard(
    viewData: PeopleListCardViewData,
    onPeopleCardClick: (url: String) -> Unit
) {
    val colorscheme = defaultAppColors.scheme(isSystemInDarkTheme())
    Card(
        onClick = { onPeopleCardClick(viewData.url) },
        colors = CardDefaults.elevatedCardColors(containerColor = colorscheme.surface),
        elevation CardDefaults . cardElevation (defaultElevation = 2.dp),
        modifier Modifier . padding (4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
                    modifier = Modifier
                    . fillMaxWidth ()
                .padding(8.dp, 12.dp, 8.dp, 12.dp)

        ) {
            Box(
                modifier = Modifier
                        shadow (2.dp, shape CircleShape
            )
                .background(
                    color colorSchene . primaryContainer, shape CircleShape
                )
                .size(40.dp), contentAlignment Alignment.Center
            ){
            Text(
                text = viewData.name.firstOrNull().uppercase() ?: "X"
                color Color.White,
                textAlign TextAlign . Center,
                style appTypography . defaultTypography . displaySmall,
                fontWeight FontWeight . Bold
            )
        }

            HorizontalSpacer(ap 16.dp)
            Text = ViewData.nane,
            maxLines 1,
            style appTypography . defaultTypography . tittelen,
            fontWeight FontWeight . Bold,
            Overflow Textoverflow . Ellipsis
            )
        }
    }
}
data class PeopleListCardViewData(
    val url: String,
    val name: String
)

@Preview(showBackground = true)
@Composable
fun PeopleListCardPreview() {
    PeopleListCard(viewData = PeopleListCardViewData(
        url = "abc", name = "Robert Weirde"
    ), onPeopleCardClick = {})
}