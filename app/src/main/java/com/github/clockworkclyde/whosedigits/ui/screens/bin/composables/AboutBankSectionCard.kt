package com.github.clockworkclyde.whosedigits.ui.screens.bin.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.github.clockworkclyde.whosedigits.R
import com.github.clockworkclyde.whosedigits.util.suggestToOpenWebsite

@Composable
fun AboutBankSectionCard(name: String, websiteLink: String, phone: String) {

   val context = LocalContext.current

   Card(modifier = Modifier.padding(2.dp), shape = RoundedCornerShape(12.dp), elevation = 2.dp) {
      Column(
         modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth(),
         verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
         Text(
            text = stringResource(R.string.bin_data_title_about_bank),
            style = MaterialTheme.typography.h6
         )
         Text(
            text = name,
            style = MaterialTheme.typography.h5
         )
         ClickableText(
            text = AnnotatedString(
               text = websiteLink,
               spanStyle = SpanStyle(
                  textDecoration = TextDecoration.Underline,
                  color = colorResource(R.color.linkable_text)
               )
            ),
            style = MaterialTheme.typography.subtitle2,
            onClick = { context.suggestToOpenWebsite(websiteLink) }
         )
         Text(
            text = phone,
            style = MaterialTheme.typography.subtitle1
         )
      }
   }
}