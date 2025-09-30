package com.principal.tpo3_dispmoviles.ui.borrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.principal.tpo3_dispmoviles.MainActivity;
import com.principal.tpo3_dispmoviles.R;
import com.principal.tpo3_dispmoviles.clases.Producto;
import com.principal.tpo3_dispmoviles.databinding.FragmentBorarBorrarBinding;
import com.principal.tpo3_dispmoviles.databinding.FragmentBorrarBinding;

public class BorarBorrarFragment extends Fragment {

    private BorarBorrarViewModel mViewModel;
    private FragmentBorarBorrarBinding binding;
    private Producto producto = null;
    public static BorarBorrarFragment newInstance() {
        return new BorarBorrarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentBorarBorrarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        if (getArguments() != null) {
             producto = (Producto) getArguments().getSerializable("producto");

            if (producto != null) {
                binding.tvDescripcion.setText("Descripcion ."+producto.getDescripcion());
                binding.tvCodigo.setText("Codigo :"+producto.getCodigo());
                binding.tvPrecio.setText("Precio :"+producto.getPrecio()+"");

            }
        }
        binding.btnBorrarBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (producto != null) {
                    MainActivity.listaProductos.removeIf(p ->
                            p.getCodigo().equals(producto.getCodigo())
                    );
                    Toast.makeText(getContext(), "Producto eliminado", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BorarBorrarViewModel.class);
        // TODO: Use the ViewModel
    }

}