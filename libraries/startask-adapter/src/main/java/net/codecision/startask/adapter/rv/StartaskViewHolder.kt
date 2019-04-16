package net.codecision.startask.adapter.rv

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

open class StartaskViewHolder(
        itemView: View
) : RecyclerView.ViewHolder(itemView) {

    protected fun getColor(colorResId: Int) = ContextCompat.getColor(getContext(), colorResId)

    protected fun getContext() = itemView.context

}