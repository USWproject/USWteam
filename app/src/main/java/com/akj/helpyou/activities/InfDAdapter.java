package com.akj.helpyou.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akj.helpyou.R;

import java.util.List;

public class InfDAdapter extends RecyclerView.Adapter<InfDAdapter.InfDViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<InfD> infDList;

    private boolean checkClick = true;

    InfDAdapter(List<InfD> infDList){
        this.infDList = infDList;
    }
    @NonNull
    @Override
    public InfDViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_infd, viewGroup, false);
        return new InfDViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfDViewHolder infDViewHolder, int i) {
        InfD infD = infDList.get(i);
        infDViewHolder.vh.setText(infD.getVh());
        infDViewHolder.startpoint.setText(infD.getStartpoint());
        infDViewHolder.endpoint.setText(infD.getEndpoint());
        infDViewHolder.details.setText(infD.getDetails());
        infDViewHolder.etc.setText(infD.getEtc());

        // 자식 레이아웃 매니저 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                infDViewHolder.rvInfD2.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(infD.getInfD2List().size());

        // 자식 어답터 설정
        InfD2Adapter infD2Adapter = new InfD2Adapter(infD.getInfD2List());

        infDViewHolder.rvInfD2.setLayoutManager(layoutManager);
        infDViewHolder.rvInfD2.setAdapter(infD2Adapter);
        infDViewHolder.rvInfD2.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return infDList.size();
    }

    class InfDViewHolder extends RecyclerView.ViewHolder{
        Context context;

        private TextView vh;
        private TextView startpoint;
        private TextView endpoint;
        private TextView details;
        private TextView etc;
        private RecyclerView rvInfD2;

        public InfDViewHolder(@NonNull View itemView) {
            super(itemView);
            vh = itemView.findViewById(R.id.infd_vh);
            startpoint = itemView.findViewById(R.id.infd_startpoint);
            endpoint = itemView.findViewById(R.id.infd_endpoint);
            details = itemView.findViewById(R.id.infd_details);
            etc = itemView.findViewById(R.id.infd_etc);
            // 자식아이템 영역
            rvInfD2 = itemView.findViewById(R.id.recyclerView_infd2);

            details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("check2"," 1111");
                    if(checkClick) {
                        rvInfD2.setVisibility(View.VISIBLE);
                        checkClick=false;
                    }
                    else{
                        rvInfD2.setVisibility(View.GONE);
                        checkClick=true;
                    }
                }
            });
        }
    }
}
