package com.example.rosatom;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rosatom.databinding.InformationReportItemBinding;

import java.util.List;

class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.ViewHolder> {
    private List<InformationReport> reportList;

    ReportAdapter(List<InformationReport> reportList){
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public ReportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        InformationReportItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.information_report_item, parent, false);
        return new ReportAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.ViewHolder holder, int position) {
        InformationReport report = reportList.get(position);
        holder.headerTV.setText(report.getHeader());
        holder.dateTV.setText(report.getDate());
        holder.jobTV.setText(report.getJob());
        holder.recipientTV.setText(report.getRecipient());
        holder.reportTextTV.setText(report.getReportText());
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        InformationReportItemBinding binding;

        final TextView headerTV, dateTV, recipientTV, jobTV, reportTextTV;
        public ViewHolder(InformationReportItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            headerTV = binding.headerTV;
            dateTV = binding.dateTV;
            jobTV = binding.jobTV;
            recipientTV = binding.recipientTV;
            reportTextTV = binding.reportTextTV;
        }


    }
}