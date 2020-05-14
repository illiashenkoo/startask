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

    fun removeItem(position: Int) {
        var removedAt: Int? = null

        synchronized(lockKey) {
            if (position < items.size) {
                items.removeAt(position)
                removedAt = position
            }
        }

        removedAt?.let { atPosition ->
            notifyItemRemoved(atPosition)
        }
    }

    fun removeItem(item: T) {
        var removedAt: Int? = null

        synchronized(lockKey) {
            val position = items.indexOf(item)

            if (position >= 0) {
                items.removeAt(position)
                removedAt = position
            }
        }

        removedAt?.let { atPosition ->
            notifyItemRemoved(atPosition)
        }
    }

    fun inflateView(@LayoutRes resource: Int, root: ViewGroup): View {
        return getLayoutInflater().inflate(resource, root, false)
    }

    private fun getLayoutInflater() = LayoutInflater.from(context)
}