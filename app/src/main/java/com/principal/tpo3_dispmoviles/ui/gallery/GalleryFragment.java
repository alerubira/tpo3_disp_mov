package com.principal.tpo3_dispmoviles.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.principal.tpo3_dispmoviles.MainActivity;
import com.principal.tpo3_dispmoviles.clases.Producto;
import com.principal.tpo3_dispmoviles.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textGallery;
       // galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        galleryViewModel.getListaMutable().observe(
                getViewLifecycleOwner(),   // <- este es el LifecycleOwner correcto
                new Observer<ArrayList<Producto>>() {
                    @Override
                    public void onChanged(ArrayList<Producto> productos) {
                        ProductoAdapter ia = new ProductoAdapter(productos, requireContext(), getLayoutInflater());
                        GridLayoutManager glm = new GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false);
                        binding.lista.setLayoutManager(glm);
                        binding.lista.setAdapter(ia);
                    }
                }
        );


        galleryViewModel.buscarProductos();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}