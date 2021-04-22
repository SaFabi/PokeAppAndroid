package com.example.pokeapp.DAO;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.Map;

public class Peticion {
    public Peticion() {
    }

    public static class DELETE {
        private Context context;
        private String url;

        public DELETE(Context context, String url) {
            this.context = context;
            this.url = url;
        }

        public void getResponse(final Peticion.OnPeticionListener<String> listener) {
            RequestQueue queue = Volley.newRequestQueue(this.context);
            StringRequest request = new StringRequest(3, this.url, new Listener<String>() {
                public void onResponse(String response) {
                    listener.onSuccess(response);
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error.toString(), error.networkResponse != null ? error.networkResponse.statusCode : 0);
                }
            });
            request.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0F));
            queue.add(request);
        }
    }

    public static class PUT {
        private Context context;
        private String url;
        private Map<String, String> parametros;

        public PUT(Context context, String url, Map<String, String> parametros) {
            this.context = context;
            this.url = url;
            this.parametros = parametros;
        }

        public void getResponseString(final Peticion.OnPeticionListener<String> listener) {
            RequestQueue queue = Volley.newRequestQueue(this.context);
            StringRequest request = new StringRequest(2, this.url, new Listener<String>() {
                public void onResponse(String response) {
                    listener.onSuccess(response);
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error.toString(), error.networkResponse != null ? error.networkResponse.statusCode : 0);
                }
            }) {
                public String getBodyContentType() {
                    return "application/x-www-form-urlencoded; charset=utf-8";
                }

                protected Map<String, String> getParams() throws AuthFailureError {
                    return PUT.this.parametros;
                }
            };
            request.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0F));
            queue.add(request);
        }
    }

    public static class POST {
        private Context context;
        private String url;
        private Map<String, String> parametros;

        public POST(Context context, String url, Map<String, String> parametros) {
            this.context = context;
            this.url = url;
            this.parametros = parametros;
        }

        public void getResponse(final Peticion.OnPeticionListener<String> listener) {
            RequestQueue queue = Volley.newRequestQueue(this.context);
            StringRequest request = new StringRequest(1, this.url, new Listener<String>() {
                public void onResponse(String response) {
                    listener.onSuccess(response);
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error.toString(), error.networkResponse != null ? error.networkResponse.statusCode : 0);
                }
            }) {
                public String getBodyContentType() {
                    return "application/x-www-form-urlencoded; charset=utf-8";
                }

                protected Map<String, String> getParams() throws AuthFailureError {
                    return POST.this.parametros;
                }
            };
            request.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0F));
            queue.add(request);
        }
    }

    public static class GET {
        private String url;
        private Context context;

        public GET(Context context, String url) {
            this.context = context;
            this.url = url;
        }

        public void getResponse(final Peticion.OnPeticionListener<String> listener) {
            RequestQueue queue = Volley.newRequestQueue(this.context);
            StringRequest request = new StringRequest(0, this.url, new Listener<String>() {
                public void onResponse(String response) {
                    listener.onSuccess(response);
                }
            }, new ErrorListener() {
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error.toString(), error.networkResponse != null ? error.networkResponse.statusCode : 0);
                }
            });
            request.setRetryPolicy(new DefaultRetryPolicy(30000, 1, 1.0F));
            queue.add(request);
        }
    }

    public interface OnPeticionListener<T> {
        void onSuccess(T var1);

        void onFailed(String var1, int var2);
    }
}
