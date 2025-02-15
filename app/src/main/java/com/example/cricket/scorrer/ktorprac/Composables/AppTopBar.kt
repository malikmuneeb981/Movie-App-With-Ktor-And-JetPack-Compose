package com.example.cricket.scorrer.ktorprac.Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppTopBar(modifier: Modifier = Modifier,backarrow:Boolean = true,text:String,onback:()->Unit={}) {

    Row(modifier=Modifier.fillMaxWidth().background(Color.White).padding(15.dp),
        horizontalArrangement = Arrangement.spacedBy(13.dp), verticalAlignment = Alignment.CenterVertically) {

        if (backarrow){
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.clickable {
                    onback()
                }
            )
        }
        AppText(text = text, modifier = Modifier.weight(1f),
            fontWeight = FontWeight.SemiBold, fontsize = 18.sp,
            textAlign = TextAlign.Start)


    }


}

@Preview
@Composable
private fun AppTopBarPrev() {
    AppTopBar(text = "Movie App"){

    }
}