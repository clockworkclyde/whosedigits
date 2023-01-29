package com.github.clockworkclyde.whosedigits.domain.bin

import androidx.core.text.isDigitsOnly
import com.github.clockworkclyde.whosedigits.domain.BinRepository
import com.github.clockworkclyde.whosedigits.models.BIN_REQUIRED_LENGTH
import com.github.clockworkclyde.whosedigits.models.base.Response
import com.github.clockworkclyde.whosedigits.models.ui.BinData
import javax.inject.Inject

class SearchDataWithBinUseCase @Inject constructor(private val repository: BinRepository) {

    suspend operator fun invoke(bin: String): Response<BinData> {
        return if (bin.length != BIN_REQUIRED_LENGTH) {
            Response.Failure(IllegalArgumentException("Its total length must be 8"))
        } else if (!bin.isDigitsOnly() || bin.toIntOrNull() == null) {
            Response.Failure(IllegalArgumentException("Bin can contain only digits"))
        } else {
            repository.search(bin.toInt())
        }
    }
}