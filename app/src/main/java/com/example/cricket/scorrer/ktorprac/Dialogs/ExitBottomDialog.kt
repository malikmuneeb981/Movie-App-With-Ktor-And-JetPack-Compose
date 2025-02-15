package com.example.cricket.scorrer.ktorprac.Dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.cricket.scorrer.ktorprac.Composables.AppText

@Composable
fun ExitBottomDialog(ondismiss:()->Unit,onExit:()->Unit) {

    Dialog(onDismissRequest = {

        ondismiss()
    }, properties = DialogProperties(usePlatformDefaultWidth = false)) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent).clickable(interactionSource = remember { MutableInteractionSource() }, // Prevents animation
                indication = null) {
                ondismiss()
            }, contentAlignment = Alignment.BottomCenter) {

            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                .background(
                    Color.White, shape = RoundedCornerShape(16.dp)
                )
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 20.dp)){


               AppText(text = "Exit App?", fontWeight = FontWeight.SemiBold, fontsize = 20.sp, modifier = Modifier.fillMaxWidth())

                AppText(text = "Are You Sure You Want To Exit App?", fontWeight = FontWeight.Medium, fontsize = 17.sp,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp))


                Row(modifier = Modifier.fillMaxWidth().padding(top = 30.dp), horizontalArrangement = Arrangement.spacedBy(15.dp)) {

                    Box(modifier = Modifier.weight(1f).background(color = Color.White, shape = RoundedCornerShape(
                        16.dp
                    )).border(width = 1.dp, color = Color(0xFF0085FF)
                        .copy(alpha = 0.10f), shape = RoundedCornerShape(16.dp)).clip(
                        RoundedCornerShape(16.dp)
                    ).clickable {
                        ondismiss()
                    }.padding(vertical = 13.dp)) {

                        AppText(text = "No", modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Medium,
                            fontsize = 16.sp)
                    }

                    Box(modifier = Modifier.weight(1f).background(color = Color(0xFFDD2828), shape = RoundedCornerShape(
                        16.dp
                    )).clip(
                        RoundedCornerShape(16.dp)
                    ).clickable {
                        onExit()
                    }.padding(vertical = 13.dp)) {

                        AppText(text = "Exit", modifier = Modifier.fillMaxWidth(), color = Color.White, fontWeight = FontWeight.Medium,
                            fontsize = 16.sp)
                    }

                }

            }



        }


    }

}

@Preview
@Composable
private fun ExitBottomDialogPrev() {
    ExitBottomDialog(onExit = {}, ondismiss = {})
}