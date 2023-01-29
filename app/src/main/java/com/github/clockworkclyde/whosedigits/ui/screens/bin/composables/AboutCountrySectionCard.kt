package com.github.clockworkclyde.whosedigits.ui.screens.bin.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
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
            text = stringResource(R.string.bin_data_title_about_country),
            style = MaterialTheme.typography.h6
         )
         Text(
            text = "$name, $alpha2",
            style = MaterialTheme.typography.h5
         )
         ClickableText(
            style = MaterialTheme.typography.subtitle2,
            text = AnnotatedString(
               stringResource(R.string.button_show_bin_result_on_map),
               spanStyle = SpanStyle(
                  textDecoration = TextDecoration.Underline,
                  color = colorResource(R.color.linkable_text)
               )
            ),
            onClick = { context.goToMapActivityWithParams(lat = lat, lng = lng) }
         )
         Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
         ) {
            Column {
               Text(
                  text = stringResource(R.string.bin_data_latitude),
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
                  text = stringResource(R.string.bin_data_longitude),
                  color = colorResource(R.color.label_grey),
                  style = MaterialTheme.typography.subtitle2
               )
               Text(
                  text = lng.toString(),
                  style = MaterialTheme.typography.subtitle1
               )
            }
         }
      }
   }
}