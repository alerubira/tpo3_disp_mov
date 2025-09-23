package com.principal.tpo3_dispmoviles.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.principal.tpo3_dispmoviles.MainActivity;
import com.principal.tpo3_dispmoviles.clases.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Producto>> listaMutable=null;
    private ArrayList<Producto> productos;
    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<ArrayList<Producto>> getListaMutable(){
        if(listaMutable==null){
            listaMutable=new MutableLiveData<>();
        }
        return listaMutable;
    }
    public void buscarProductos(){

       productos= MainActivity.listaProductos;
        productos.sort(Comparator.comparing(Producto::getDescripcion, String.CASE_INSENSITIVE_ORDER));

        listaMutable.setValue(productos);
    }


}