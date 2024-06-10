package com.example.uptodo.screen.onboarding

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uptodo.MainActivity
import com.example.uptodo.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    context: MainActivity
) {

    val images = listOf(
        R.drawable.img_first_onboarding,
        R.drawable.img_second_onboarding,
        R.drawable.img_third_onboarding,
    )

    val title = listOf(
        R.string.title_first_ob,
        R.string.title_second_ob,
        R.string.title_third_ob,
    )

    val description = listOf(
        R.string.description_first_ob,
        R.string.description_second_ob,
        R.string.description_third_ob,
    )

    val pagerState = rememberPagerState(pageCount = title.size)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) { currentPage ->
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = images[currentPage]),
                    contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                )
                PageIndicator(
                    pageCount = title.size,
                    currentPage = currentPage,
                    modifier = Modifier.padding(top = 25.dp)
                )
                Text(
                    text = stringResource(id = title[currentPage]),
                    modifier = Modifier.padding(top = 25.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = stringResource(id = description[currentPage]),
                    modifier = Modifier.padding(top = 25.dp),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        ButtonSection(
            modifier = Modifier.weight(1f),
            pagerState = pagerState,
            context = context,
            navController = navController
        )
    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    context: MainActivity,
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.Bottom
    ) {
        TextButton(onClick = {
            scope.launch {
                if (pagerState.currentPage != 2) {
                    pagerState.animateScrollToPage(pagerState.currentPage + 2)
                }
            }

        }) {
            Text(text = stringResource(id = R.string.skip_intro))
        }

        Button(
            shape = RectangleShape,
            onClick = {
                scope.launch {
                    if (pagerState.currentPage != 2) {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    } else {
                        onBoardingIsFinished(context = context)
                        navController.popBackStack()
                        navController.navigate("home")
                    }
                }
            }) {
            Text(text = stringResource(id = if (pagerState.currentPage != 2) R.string.next else R.string.get_started))
        }
    }
}


@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        repeat(pageCount) {
            IndicatorSingleDot(isSelected = it == currentPage)
        }
    }
}

@Composable
fun IndicatorSingleDot(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 35.dp else 15.dp, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(4.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFFFFFFFF) else Color(0xFFAFAFAF))
    )
}

private fun onBoardingIsFinished(context: MainActivity) {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("finished", true)
    editor.apply()
}
