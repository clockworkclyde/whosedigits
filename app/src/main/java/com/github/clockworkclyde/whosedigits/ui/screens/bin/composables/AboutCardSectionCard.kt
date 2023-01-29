package com.github.clockworkclyde.whosedigits.ui.screens.bin.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.clockworkclyde.whosedigits.R

@Composable
fun AboutCardSectionCard(
   brand: String,
   cardType: String,
   luhn: Boolean,
   length: Int,
   scheme: String,
   isPrepaid: Boolean
) {
   Card(modifier = Modifier.padding(2.dp), shape = RoundedCornerShape(12.dp), elevation = 2.dp) {
      Column(
         modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth(),
         verticalArrangement = Arrangement.spacedBy(8.dp)
      ) {
         Text(
            text = stringResource(R.string.bin_data_title_about_card),
            style = MaterialTheme.typography.h6
         )
         Text(
            text = brand,
            style = MaterialTheme.typography.h5
         )
         Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column {
               Column {
                  Text(
                     text = stringResource(R.string.bin_data_length),
                     color = colorResource(R.color.label_grey),
                     style = MaterialTheme.typography.subtitle2
                  )
                  Text(
                     text = length.toString(),
                     style = MaterialTheme.typography.subtitle1
                  )
               }
               Column {
                  Text(
                     text = stringResource(R.string.bin_data_scheme_or_network),
                     color = colorResource(R.color.label_grey),
                     style = MaterialTheme.typography.subtitle2
                  )
                  Text(
                     text = scheme,
                     style = MaterialTheme.typography.subtitle1
                  )
               }
            }

            Column {
               Column {
                  Text(
                     text = stringResource(R.string.bin_data_luhn),
                     color = colorResource(R.color.label_grey),
                     style = MaterialTheme.typography.subtitle2
                  )
                  Text(
                     text = luhn.toString(),
                     style = MaterialTheme.typography.subtitle1
                  )
               }
               Column {
                  Text(
                     text = stringResource(R.string.bin_data_prepaid),
                     color = colorResource(R.color.label_grey),
                     style = MaterialTheme.typography.subtitle2
                  )
                  when (isPrepaid) {
                     true -> Text(
                        text = stringResource(R.string.bin_data_prepaid_positive),
                        style = MaterialTheme.typography.subtitle1
                     )
                     false -> Text(
                        text = stringResource(R.string.bin_data_prepaid_negative),
                        style = MaterialTheme.typography.subtitle1
                     )
                  }
               }
            }
            Column {
               Text(
                  text = stringResource(R.string.bin_data_card_type),
                  color = colorResource(R.color.label_grey),
                  style = MaterialTheme.typography.subtitle2
               )
               Text(
                  text = cardType,
                  style = MaterialTheme.typography.subtitle1
               )
            }
         }
      }
   }
}