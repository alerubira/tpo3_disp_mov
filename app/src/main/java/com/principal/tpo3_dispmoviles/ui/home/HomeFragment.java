package com.principal.tpo3_dispmoviles.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.principal.tpo3_dispmoviles.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        homeViewModel.getMInforme().observe(this,String ->{
            binding.tvInforme.setText(String);
        });
        binding.btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo =binding.edtCodigo.getText().toString();
                Double precio =Double.parseDouble(binding.edtPrecio.getText().toString());
                homeViewModel.recibirDatos(binding.edtDetalle.getText().toString(),codigo,precio);
                binding.edtCodigo.setText("");
                binding.edtDetalle.setText("");
                binding.edtPrecio.setText("");
            }

        });

        //final TextView textView = binding.textHome;
        //homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}