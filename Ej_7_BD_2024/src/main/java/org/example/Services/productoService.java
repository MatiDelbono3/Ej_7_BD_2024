package org.example.Services;

import java.util.List;
import org.example.connections.HibernateUtil;
import org.hibernate.Session;
import org.example.DTO.categoria;
import org.example.DTO.producto;
import org.example.DTO.recomendacion;
import org.example.entities.categorias;
import org.example.entities.productos;
import org.example.entities.recomendaciones;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class productoService {
    public List<producto> ObtenerProductoConMasValoraciones(){
        Session session=HibernateUtil.getSession();
        List<productos>ProductoConMasValoraciones=new ArrayList<>();
        List<producto>R3=new ArrayList<>();
        try {
            session.beginTransaction();
            String Sql3=("FROM productos p\n" +
                    "INNER JOIN recomendaciones r ON p.id =r.producto_id\n" +
                    "GROUP BY p.id, p.nombre\n" +
                    "ORDER BY total_valoraciones DESC\n" +
                    "LIMIT 1;");
            Query consulta3= session.createQuery(Sql3);
            ProductoConMasValoraciones=consulta3.getResultList();
            for (productos p : ProductoConMasValoraciones){
                R3.add(new producto(p));
            }
        }finally {
            session.close();
        }
        return R3;
    }
}
