package com.example.postalapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postalapp.Model.PostOffice;
import com.example.postalapp.Model.PostalCodeResponse;
import com.example.postalapp.R;

import java.util.List;

public class PostalcodeAdapter extends RecyclerView.Adapter<PostalcodeAdapter.PostalCodeViewHolder> {
    private List<PostOffice> PostOffice;
    private Context context;

    public PostalcodeAdapter(List<PostOffice> PostOffice, Context context) {
        this.PostOffice = PostOffice;
        this.context = context;
    }

    @NonNull
    @Override
    public PostalCodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pincode_list_item, parent, false);
        return new PostalCodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostalCodeViewHolder holder, int position) {
        PostOffice postOffice = PostOffice.get(position);
        holder.pincodeTextView.setText(postOffice.getPincode());

        holder.pincodeTextView.setOnClickListener(view -> {
            Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + postOffice.getPincode());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        });
    }

    @Override
    public int getItemCount() {
        return PostOffice.size();
    }

    public static class PostalCodeViewHolder extends RecyclerView.ViewHolder {
        TextView pincodeTextView;

        public PostalCodeViewHolder(@NonNull View itemView) {
            super(itemView);
            pincodeTextView = itemView.findViewById(R.id.pincodeTextView);
        }
    }
}

