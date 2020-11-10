package com.javacodegeeks.ejbsecurity;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProductService {

    @PersistenceContext(unitName = "products")
    private EntityManager entityManager;

    @RolesAllowed({"User", "Admin"})
    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    @RolesAllowed({"Admin"})
    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }


    @PermitAll
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Product> getProducts() {
        TypedQuery query = entityManager.createQuery("SELECT p from Product as p", Product.class);
        return query.getResultList();
    }
}