package com.example.cricket.scorrer.ktorprac.Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cricket.scorrer.ktorprac.models.Search

@Composable
fun MovieSearchItem(search: Search,onClick:(Search)->Unit) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White).clickable {
            onClick(search)
        }) {

        AsyncImage(model = search.Poster,
            contentDescription = "Poster Image",
            modifier = Modifier.size(100.dp)
            )

        Column(modifier = Modifier.weight(1f).padding(vertical = 10.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {

            AppText(text = search.Title, fontsize = 18.sp, fontWeight = FontWeight.Bold)

            AppText(text = "(${search.Year})", fontWeight = FontWeight.SemiBold)



        }
        Column(modifier = Modifier.height(100.dp).padding(bottom = 10.dp, end = 10.dp), verticalArrangement = Arrangement.Bottom) {
            AppText(text = search.Type, fontWeight = FontWeight.SemiBold)
        }
        





    }
    

}

@Preview
@Composable
private fun MovieSearchItemPrev() {
    MovieSearchItem(Search("https://m.media-amazon.com/images/M/MV5BNGE0YTVjNzUtNzJjOS00NGNlLTgxMzctZTY4YTE1Y2Y1ZTU4XkEyXkFqcGc@._V1_SX300.jpg"
        ,"The Avengers","movie","2012","")){

    }
}