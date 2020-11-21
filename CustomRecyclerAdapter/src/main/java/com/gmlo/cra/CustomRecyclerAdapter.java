package com.gmlo.cra;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class CustomRecyclerAdapter<T,D> extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<T> items;

    public CustomRecyclerAdapter(){
        super();
        this.items = new ArrayList<>();
    }

    public T getItem(int index){
        return ((items!=null && index<items.size())?items.get(index):null);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<T> getList(){
        return items;
    }

    public void setList(List<T> list){
        items = list;
        notifyDataSetChanged();
    }

    public void addAll(List<T> list){
        items.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(T item){
        items.add(item);
        notifyDataSetChanged();
    }

    public void reset(){
        items.clear();
        notifyDataSetChanged();
    }

    protected abstract void onBindData(T item, int position, D dataBinding);

    protected abstract int getLayoutResId();

    protected abstract void onItemClick(T item, int position);

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        protected D mDataBinding;

        public CustomViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            mDataBinding = (D) binding;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),getLayoutResId(),viewGroup,false);
        return new CustomViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        onBindData(getItem(position),position, ((CustomViewHolder)holder).mDataBinding);
        ((ViewDataBinding)((CustomViewHolder)holder).mDataBinding).getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(items.get(position),position);
            }
        });
    }
}