package com.principal.tpo3_dispmoviles.ui.borrar;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.principal.tpo3_dispmoviles.R;
import com.principal.tpo3_dispmoviles.databinding.ActivityMainBinding;
import com.principal.tpo3_dispmoviles.databinding.FragmentBorrarBinding;
import com.principal.tpo3_dispmoviles.databinding.FragmentHomeBinding;

public class BorrarFragment extends Fragment {

    private BorrarViewModel mViewModel;
    private FragmentBorrarBinding binding;

    public static BorrarFragment newInstance() {
        return new BorrarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBorrarBinding.inflate(inflater, container, false);

        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        mViewModel.getMInforme().observe(this,String ->{
               binding.tvAviso.setText(String);
        });
        mViewModel.getMProducto().observe(this,Producto ->{
            Bundle bundle = new Bundle();
            bundle.putSerializable("producto", Producto);
            NavHostFragment.findNavController(this)
                    .navigate(R.id.borarBorrarFragment, bundle);
        });
        binding.btnBorrar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mViewModel.buscarProducto(binding.edtBorrar.getText().toString());
            }
        });
        return inflater.inflate(R.layout.fragment_borrar, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        // TODO: Use the ViewModel
    }

}