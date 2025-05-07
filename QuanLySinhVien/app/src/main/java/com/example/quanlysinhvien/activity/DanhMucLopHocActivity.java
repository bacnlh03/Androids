package com.example.quanlysinhvien.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlysinhvien.R;
import com.example.quanlysinhvien.adapter.LopHocAdapter;
import com.example.quanlysinhvien.model.LopHoc;
import com.example.quanlysinhvien.sqlite.LopHocDAO;

import java.util.ArrayList;
import java.util.List;

public class DanhMucLopHocActivity extends AppCompatActivity implements View

        .OnClickListener {

    EditText edtTenLopHoc;
    ListView lvDanhSachLopHoc;
    List<LopHoc> lopHocList = new ArrayList<>();
    LopHocAdapter lopHocAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_lop_hoc);
        findViewById(R.id.btnLuuLopHoc).setOnClickListener(this);
        findViewById(R.id.btnThoatLopHoc).setOnClickListener(this);
        edtTenLopHoc = findViewById(R.id.edtTenLopHoc);
        lvDanhSachLopHoc = findViewById(R.id.lvdanhsachlophoc);
        fillLopHocListView();
    }

    private void fillLopHocListView() {
        LopHocDAO lopHocDAO = new LopHocDAO(this);
        lopHocList = lopHocDAO.getAll();
        lopHocAdapter = new LopHocAdapter(this, lopHocList);
        lvDanhSachLopHoc.setAdapter(lopHocAdapter);
        lvDanhSachLopHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                LopHocDAO lopHocDAO1 = new LopHocDAO(DanhMucLopHocActivity.this);
                LopHoc lopHoc = lopHocList.get(i);
                lopHocDAO.delete(lopHoc.getId());
                fillLopHocListView();
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLuuLopHoc:
                LopHoc lopHoc = new LopHoc();
                lopHoc.setTenlophoc(edtTenLopHoc.getText().toString());
                LopHocDAO lopHocDAO = new LopHocDAO(this);
                lopHocDAO.insert(lopHoc);
                fillLopHocListView();
                Toast.makeText(this,"Đã lưu lớp học",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnThoatLopHoc:
                finish();
                break;
        }
    }
}