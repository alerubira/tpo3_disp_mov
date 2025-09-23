package com.principal.tpo3_dispmoviles.ui.slideshow;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.principal.tpo3_dispmoviles.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Mostramos el diálogo cada vez que el fragment se vuelve visible
        mostrarDialogoSalir();
    }

    private void mostrarDialogoSalir() {
        new AlertDialog.Builder(requireContext())
                .setTitle("Cerrar aplicación")
                .setMessage("¿Seguro que quieres salir?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    // Cierra la app completamente
                    requireActivity().finishAffinity();
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    // Solo cierra el diálogo
                    dialog.dismiss();
                })
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
