package com.principal.tpo3_dispmoviles.ui.borrar;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.principal.tpo3_dispmoviles.MainActivity;
import com.principal.tpo3_dispmoviles.clases.Producto;

public class BorrarViewModel extends ViewModel {
   private MutableLiveData<String> mText;
   private MutableLiveData<Producto> mProducto;
    public BorrarViewModel() {

    }
    // TODO: Implement the ViewModel
    public LiveData<String> getMInforme(){
        if(mText==null){
            mText=new MutableLiveData<>();
        }
        return mText;
    }
    public LiveData<Producto> getMProducto(){
        if(mProducto==null){
            mProducto=new MutableLiveData<>();
        }
        return mProducto;
    }
    public void buscarProducto(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            mText.setValue("Los datos ingresados son incorrectos o no están");
            return;
        }

        for (Producto p : MainActivity.listaProductos) {
            if (p.getCodigo().equals(codigo)) {
                mProducto.setValue(p); // si lo encuentra lo carga en el mutable
                return;
            }
        }


        mText.setValue("El producto con código " + codigo + " no existe");
    }
    public void resetear() {
        mProducto.postValue(null);
    }
}