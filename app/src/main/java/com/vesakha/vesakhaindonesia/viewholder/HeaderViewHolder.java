package com.vesakha.vesakhaindonesia.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vesakha.vesakhaindonesia.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    TextView headerName;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        headerName = itemView.findViewById(R.id.tvHeaderItem);
    }

    public void setHeaderName(String toko) {
        this.headerName.setText(toko);
    }
}
