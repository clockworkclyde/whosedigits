package com.github.clockworkclyde.whosedigits.ui.screens.bin.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.github.clockworkclyde.whosedigits.R
import com.github.clockworkclyde.whosedigits.util.goToMapActivityWithParams

@Composable
fun AboutCountrySectionCard(alpha2: String, name: String, lat: Float, lng: Float) {
   val context = LocalContext.current
   Card(modifier = Modifier.padding(2.dp), shape = RoundedCornerShape(12.dp), elevation = 2.dp) {
      Column(
         modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth(),
         verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
         Text(
            text = "About country",
            style = MaterialTheme.typography.h6
         )
         Text(
            text = "$name, $alpha2",
            style = MaterialTheme.typography.h5
         )
         Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.Top
         ) {
            Column {
               Text(
                  text = "latitude",
                  color = colorResource(R.color.label_grey),
                  style = MaterialTheme.typography.subtitle2
               )
               Text(
                  text = lat.toString(),
                  style = MaterialTheme.typography.subtitle1
               )
            }
            Column {
               Text(
                  text = "latitude",
                  color = colorResource(R.color.label_grey),
                  style = MaterialTheme.typography.subtitle2
               )
               Text(
                  text = lng.toString(),
                  style = MaterialTheme.typography.subtitle1
               )
            }
            ClickableText(
               style = MaterialTheme.typography.subtitle1,
               text = AnnotatedString("(show on map)"),
               onClick = { context.goToMapActivityWithParams(lat = lat, lng = lng) }
            )
         }
      }
   }
}