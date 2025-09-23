package com.principal.tpo3_dispmoviles.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.principal.tpo3_dispmoviles.MainActivity;
import com.principal.tpo3_dispmoviles.clases.Producto;

public class HomeViewModel extends ViewModel {

   // private final MutableLiveData<String> mText;
   private MutableLiveData<String> mInforme;
    public HomeViewModel() {
        //mText = new MutableLiveData<>();
       // mText.setValue("This is home fragment");
    }

    /*public LiveData<String> getText() {
        return mText;
    }*/
    public LiveData<String> getMInforme(){
        if(mInforme==null){
            mInforme=new MutableLiveData<>();
        }
        return mInforme;
    }
    public void recibirDatos(String descripcion,String codigo,double precio){
        //verificar tambienque sea enter y double,despues parsear
        if((descripcion==null||descripcion.length()<1)||(codigo==null||codigo.length()<1)||(precio<1)){
            mInforme.setValue("Los Datos Ingresados son Incorrectos o No Estan");
        }else {
            Producto producto=new Producto(codigo,descripcion,precio);
            if(buscarProducto(producto)){
                mInforme.setValue("Ese Producto ya existe");
            }else{
                MainActivity.listaProductos.add(producto);
                mInforme.setValue("El Producto se cargo Exitosamente");
            }
        }

    }
    private boolean buscarProducto(Producto producto){

        for(Producto p: MainActivity.listaProductos){
            if(p.getCodigo().equals(producto.getCodigo())){
                return true;
            }
        }
        return false;
    }


}