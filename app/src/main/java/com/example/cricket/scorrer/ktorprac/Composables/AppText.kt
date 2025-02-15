package com.example.cricket.scorrer.ktorprac.Composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.cricket.scorrer.ktorprac.R



@Composable
fun AppText(modifier: Modifier = Modifier
            , text:String,
            fontStyle: FontStyle = FontStyle.Normal,
            font:Int = R.font.poppins_regular,
            fontWeight: FontWeight = FontWeight.Normal,
            fontsize:TextUnit = 15.sp,
            color:Color = Color.Black,
            textAlign: TextAlign = TextAlign.Center
) {

    Text(text = text, fontStyle = fontStyle, fontWeight = fontWeight, fontSize = fontsize,modifier = modifier,
        color = color, textAlign = textAlign,)



}