package com.example.quanlihocsinh;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlihocsinh.model.Hocsinh;

import java.util.List;

public class ManageApdapter extends ArrayAdapter<Hocsinh> {
    private Context mContext;
    private int mResources;
    private List<Hocsinh> mList;
    SQLlite sqLlite;
    Hocsinh hocsinh;
    public ManageApdapter (Context context, int resource, List<Hocsinh> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResources = resource;
        this.mList = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(mContext).inflate(mResources,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.textViewName = convertView.findViewById(R.id.txtName);
            viewHolder.textViewInfo = convertView.findViewById(R.id.txtinfo);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Hocsinh model = mList.get(position);
        viewHolder.textViewName.setText(model.getTen());
        viewHolder.textViewInfo.setText(model.getLop()+"-"+model.getMSSV()+"-"+model.getNganh());

        Button btnAdd = convertView.findViewById(R.id.btnAdd);
        Button btnEdit = convertView.findViewById(R.id.btnEdit);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AddInfoHocSinh.class);
                intent.putExtra("id",position);
                mContext.startActivity(intent);
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(mContext, EditInfoHocSinh.class);
                intent1.putExtra("id", position);
                intent1.putExtra("ten",model.getTen());
                intent1.putExtra("lop",model.getLop());
                intent1.putExtra("mssv",model.getMSSV());
                intent1.putExtra("nganh",model.getNganh());
                mContext.startActivity(intent1);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqLlite = new SQLlite(mContext);
                sqLlite.OpenDB();
                mList.remove(position);
                Boolean rs = sqLlite.DeleteItem(new Hocsinh(null,null,null,null, position));
                if (rs){
                    Toast.makeText(mContext,"Xoa thanh cong",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(mContext,"Xoa khong thanh cong",Toast.LENGTH_LONG).show();
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    public class ViewHolder{
        TextView textViewName;
        TextView textViewInfo;
    }
}
