/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andreas
 */
public class CarFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();

    public List<String> ScrapeCars() throws InterruptedException, ExecutionException {
        List<String> Data = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(2);

        List<Future<String>> listT = new ArrayList<>();
        List<Future<String>> listJ = new ArrayList<>();

        Future<String> future = es.submit(new findCarsSrax());
        Future<String> future1 = es.submit(new findCarsJonas());
        
        listT.add(future);
        listJ.add(future1);

        for (Future<String> fut : listT) {
            Data.add(fut.get());
        }

        for (Future<String> fut : listJ) {
            Data.add(fut.get());
        }

        return Data;
    }

    public static class findCarsJonas implements Callable<String> {

        @Override
        public String call() throws Exception {
            URL url = new URL("https://jhdata.eu/CarsAPI/api/cars");
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("User-Agent", "server");
            Scanner scan = new Scanner(con.getInputStream());
            String jsonStr = null;
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
            }
            scan.close();
            return jsonStr;
        }
    }

    public static class findCarsSrax implements Callable<String> {

        @Override
        public String call() throws Exception {
            URL url = new URL("https://srax.dk/SraxSuperCars/api/cars");
            System.out.println(url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("User-Agent", "server");
            Scanner scan = new Scanner(con.getInputStream());
            String jsonStr = null;
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
            }
            scan.close();
            return jsonStr;
        }
    }
}
