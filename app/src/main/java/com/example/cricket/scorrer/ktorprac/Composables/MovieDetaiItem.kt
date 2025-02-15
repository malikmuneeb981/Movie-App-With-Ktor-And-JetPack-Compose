package com.example.cricket.scorrer.ktorprac.Composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieDetailitem(heading:String,text:String) {


    Column(modifier = Modifier.fillMaxWidth()) {

        AppText(text = heading, fontWeight = FontWeight.Bold, fontsize = 17.sp,
            modifier = Modifier.padding(top = 10.dp))

        AppText(text = text,
            fontWeight = FontWeight.Medium, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp), textAlign = TextAlign.Start)

    }


}

@Preview
@Composable
private fun MovieDetailitemPrev() {
    MovieDetailitem("fsfs","Sfsdfsfs")
}