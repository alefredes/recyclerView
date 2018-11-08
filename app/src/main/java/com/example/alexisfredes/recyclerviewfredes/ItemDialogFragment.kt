package com.example.alexisfredes.recyclerviewfredes

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_item.view.*

class ItemDialogFragment : DialogFragment() {

    companion object {
        /**
         * Create a new instance of ItemDialogFragment, providing "item" as an
         * argument.
         */
        fun newInstance(item: Item): ItemDialogFragment {
            val f = ItemDialogFragment()
            val args = Bundle()
            args.putParcelable("item", item)
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = this.layoutInflater.inflate(R.layout.view_item, container, false)
        val item = arguments!!["item"] as Item
        view.item_image.loadUrl(item.url)
        view.item_title.text = item.title
        return view
    }

    /*override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        //val view : View = this.layoutInflater.inflate(R.layout.view_item, null)
        //builder.setView(view)
        builder.setView(R.layout.view_item)
        return builder.create()
    }*/
}