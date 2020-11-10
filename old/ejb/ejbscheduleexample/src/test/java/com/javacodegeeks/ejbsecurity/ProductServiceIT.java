package com.javacodegeeks.ejbsecurity;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJBAccessException;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@RunWith(Arquillian.class)
public class ProductServiceIT {

    @Inject
    private ProductService productService;

    @Inject
    private AdministratorHandler administratorHandler;

    @Inject
    private UserHandler user;

    @Deployment
    public static JavaArchive createDeployment() throws IOException {
        return ShrinkWrap.create(JavaArchive.class, "javaee-testing-security.jar")
                .addClasses(Product.class, ProductService.class, AdministratorHandler.class, UserHandler.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
    }

    @Test
    public void testAsAdministrator() throws Exception {
        administratorHandler.call(new Callable() {
            @Override
            public Product call() throws Exception {
                productService.addProduct(new Product("CAP", "$10"));
                productService.addProduct(new Product("Socks", "$5"));

                List<Product> products = productService.getProducts();
                Assert.assertEquals("List.size()", 2, products.size());

                for (Product book : products) {
                    productService.deleteProduct(book);
                }

                Assert.assertEquals("BookshelfService.getBooks()", 0, productService.getProducts().size());
                return null;
            }
        });
    }

    @Test(expected = EJBAccessException.class)
    public void testAsUser() throws Exception {
        user.call(new Callable() {
            @Override
            public Product call() throws Exception {
                productService.addProduct(new Product("Milk Shake", "$10"));
                productService.addProduct(new Product("cake", "$2"));

                List<Product> products = productService.getProducts();
                Assert.assertEquals("List.size()", 2, products.size());

                for (Product book : products) {
                    productService.deleteProduct(book);
                    Assert.fail("Users should not be allowed to delete");
                }
                Assert.assertEquals("BookshelfService.getBooks()", 2, productService.getProducts().size());
                return null;
            }
        });
    }

    @Test(expected = EJBAccessException.class)
    public void testAsUnauthenticatedUser() throws Exception {
        productService.addProduct(new Product("Pant", "$20"));
        Assert.fail("Unauthenticated users should not be able to add books");
        productService.deleteProduct(null);
        Assert.fail("Unauthenticated users should not be allowed to delete");
    }

    @Test
    public void testReadAsUnauthenticatedUser() throws Exception {
        List books = productService.getProducts();
        Assert.assertEquals("BookshelfService.getBooks()", 0, books.size());
    }
}