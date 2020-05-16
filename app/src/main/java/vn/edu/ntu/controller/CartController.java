package vn.edu.ntu.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.controller.ICartController;
import vn.edu.ntu.model.Product;

public class CartController extends Application implements ICartController {

    List<Product> listProducts = new ArrayList<>();

    public CartController() {
       listProducts.add(new Product("Khoai lang",25000,"khoai to"));
        listProducts.add(new Product("Khoai sọ",25000,"khoai bự"));
        listProducts.add(new Product("Khoai môn",25000,"khoai dài"));
        listProducts.add(new Product("Khoai tím",25000,"khoai dai"));
    }

    @Override

    public List<Product> getAProducts() {
        return listProducts;
    }
}
