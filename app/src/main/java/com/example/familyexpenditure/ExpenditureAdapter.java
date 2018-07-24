package com.example.familyexpenditure;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ExpenditureAdapter extends RecyclerView.Adapter<ExpenditureAdapter.ExpenditureViewHolder> {
    List<Expenditure> expenditureList;
    Context context;
    ExpenditureListItemClickListener listItemClickListener;

    public ExpenditureAdapter(Context context, ExpenditureListItemClickListener listItemClickListener) {
        this.context = context;
        this.listItemClickListener = listItemClickListener;
    }


    @Override
    public ExpenditureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.expenditure_list, parent, false);
        return new ExpenditureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpenditureViewHolder holder, int position) {
        Expenditure expenditure = expenditureList.get(position);
        holder.itemAmount.setText(expenditure.getAmount());
        holder.itemName.setText(expenditure.getItem());
        holder.itemStatus.setText(expenditure.getStatus());
        holder.itemComment.setText(expenditure.getComment());

    }

    @Override
    public int getItemCount() {
        if (expenditureList == null) {
            return 0;
        }
        return expenditureList.size();
    }

    public interface ExpenditureListItemClickListener{
        void onItemClick(int itemId);
    }

    public class ExpenditureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemAmount;
        TextView itemName;
        TextView itemStatus;
        TextView itemComment;

    public ExpenditureViewHolder(View itemView) {
        super(itemView);
        itemAmount = itemView.findViewById(R.id.tvAmount);
        itemName = itemView.findViewById(R.id.tvItem);
        itemStatus = itemView.findViewById(R.id.tvStatus);
        itemComment = itemView.findViewById(R.id.tvComment);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int itemId = expenditureList.get(getAdapterPosition()).getId();
        listItemClickListener.onItemClick(itemId);

    }


    public void setExpenditureData(List<Expenditure>expenditureData) {
            expenditureList = expenditureData;
            notifyDataSetChanged();
        }
    }
}
