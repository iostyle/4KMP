package com.iostyle.compoil.ui.page

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.fragment.app.FragmentManager
import com.iostyle.compoil.data.Records
import com.iostyle.compoil.data.getCacheRecords


/**
 * UI State that represents PageScreen
 **/
data class PageState(
    val pageItems: MutableList<Records> = mutableListOf(),
    var isRefreshing: Boolean = false
)

/**
 * Page Actions emitted from the UI Layer
 * passed to the coordinator to handle
 **/
data class PageActions(
    val onRefresh: () -> Unit = {},
    val onDelete: (Records) -> Unit = {},
    val onFloatingButtonClick: (fragmentManager: FragmentManager) -> Unit = {},
)

val previewData by lazy {
    mutableListOf(
        Records(1730512179000, 1156, 5.64f),
        Records(1731635379000, 1327, 7.92f),
        Records(1733104179000, 1505, 6.66f),
    )
}

/**
 * PreviewParameter Provider for PageScreen Preview
 * Add values to the sequence to see the preview in different states
 **/
class PageStatePreviewParameterProvider : PreviewParameterProvider<PageState> {
    override val values: Sequence<PageState>
        get() = sequenceOf(
            PageState(previewData, isRefreshing = false)
        )
}

data class ItemPreview(
    val records: MutableList<Records>,
    val delete: (Records) -> Unit
)

class ListViewPreviewParameterProvider : PreviewParameterProvider<ItemPreview> {
    override val values: Sequence<ItemPreview>
        get() = sequenceOf(
            ItemPreview(previewData, {})
        )
}
