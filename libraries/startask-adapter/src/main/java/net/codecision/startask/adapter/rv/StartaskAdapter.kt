package net.codecision.startask.adapter.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class StartaskAdapter<T, VH : RecyclerView.ViewHolder>(
        val context: Context,
        private val items: MutableList<T>
) : RecyclerView.Adapter<VH>() {

    private val lockKey = Any()

    constructor(context: Context) : this(context, mutableListOf())

    override fun getItemCount(): Int {
        return items.size
    }

    fun getItem(position: Int): T {
        return items[position]
    }

    fun getItemPosition(item: T): Int {
        return items.indexOf(item)
    }

    fun replaceAll(collection: Collection<T>) {
        synchronized(lockKey) {
            items.clear()
            items.addAll(collection)
        }

        notifyDataSetChanged()
    }

    fun inflateView(@LayoutRes resource: Int, root: ViewGroup): View {
        return getLayoutInflater().inflate(resource, root, false)
    }

    private fun getLayoutInflater() = LayoutInflater.from(context)
}