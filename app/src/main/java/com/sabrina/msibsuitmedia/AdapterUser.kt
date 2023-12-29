package com.sabrina.msibsuitmedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sabrina.msibsuitmedia.databinding.UserItemBinding
import com.sabrina.msibsuitmedia.response.DataItem

class AdapterUser(): RecyclerView.Adapter<AdapterUser.ItemViewHolder>() {
    private val userList = ArrayList<DataItem>()
    private var onClickCallback: OnItemClickCallback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ItemViewHolder((view))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    inner class ItemViewHolder(private val itemBinding: UserItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: DataItem) {
            itemBinding.root.setOnClickListener{
                onClickCallback?.onItemClicked(data)
            }
            itemBinding.apply {
                firstNameTv.text = data.firstName
                lastNameTv.text = data.lastName
                emailUserTv.text = data.email
                Glide.with(itemView)
                    .load(data.avatar)
                    .circleCrop()
                    .into(userIc)
            }
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: DataItem)
    }

    fun setClickCallback(ItemClickCallback: OnItemClickCallback){
        this.onClickCallback = ItemClickCallback
    }
    fun clearUsers() {
        this.userList.clear()
        notifyDataSetChanged()
    }

    fun setList(users:ArrayList<DataItem>){
        userList.clear()
        userList.addAll(users)
        notifyDataSetChanged()
    }
}