package org.example.Services;

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

public class recomendacionService {
    public void CargarNuevaRecomendacion(producto producto){
        Session session= HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(producto);
            session.getTransaction().commit();
        }finally {
            session.close();
        }

    }
    public List<Double>ObtenerPromedioValoracionesPorCategoria(){
        Session session=HibernateUtil.getSession();
        List<Double>ObtenerPromedioValoraciones=new ArrayList<>();
        try {
            session.beginTransaction();
            String Sql1=("SELECT \n" +
                    "    c.nombre AS categoria, \n" +
                    "    AVG(r.valoracion) AS promedio_valoracion\n" +
                    "FROM \n" +
                    "    categorias c\n" +
                    "JOIN \n" +
                    "    productos p ON c.id = p.categoria_id\n" +
                    "JOIN \n" +
                    "    recomendaciones r ON p.id = r.producto_id\n" +
                    "GROUP BY \n" +
                    "    c.nombre\n" +
                    "ORDER BY \n" +
                    "    promedio_valoracion DESC\n");
            Query<Double> consulta1= session.createQuery(Sql1);
            ObtenerPromedioValoraciones=consulta1.getResultList();

            session.getTransaction().commit();
        }finally {
            session.close();
        }
        return ObtenerPromedioValoraciones;
    }
    public List<recomendacion>ObtenerRecomendacionesDeUnProducto(productos producto) {
        Session session=HibernateUtil.getSession();
        List<recomendaciones>ObtenerRecomendaciones=new ArrayList<>();
        List<recomendacion>R1=new ArrayList<>();
        try{
            session.beginTransaction();
            String Sql2=("SELECT v.*\n" +
                    "FROM valoraciones v\n" +
                    "INNER JOIN productos p ON v.producto_id = p.producto_id\n" +
                    "WHERE p.producto_id = ?");
            Query consulta2= session.createQuery(Sql2)
                    .setParameter("producto", producto);
            ObtenerRecomendaciones=consulta2.getResultList();
            for (recomendaciones r: ObtenerRecomendaciones){
                R1.add(new recomendacion(r));
            }
        }finally {
            session.close();
        }
        return R1;
    }
}
