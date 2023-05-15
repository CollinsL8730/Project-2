package com.dronerecon.ws;

        import jakarta.servlet.ServletException;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import java.io.*;
        import java.net.URL;
        import java.util.*;
        import java.security.SecureRandom;

/**
 *
 * @author Your Name Here :-)
 */
public class DroneDataService extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

        // ##############################
        // 1. Get params passed in.

        // Get the following parameters from the request object and put them into strings:
        // area_id
        // tilex
        // tiley
        // totalcols
        // totalrows
        // r
        // g
        // ##############################

        String r = request.getParameter("r");
        String g = request.getParameter("g");
        String area_id = request.getParameter("area_id");
        String tilex = request.getParameter("tilex");
        String tiley = request.getParameter("tiley");
        String totalcols = request.getParameter("totalcols");
        String totalrows = request.getParameter("totalrows");

        int itilex = Integer.parseInt(tilex);
        int itiley = Integer.parseInt(tiley);
        int itotalcols = Integer.parseInt(totalcols);
        int itotalrows = Integer.parseInt(totalrows);

        // Call Cloud and pass data to be stored in DB

        try {

            // Call Portal DB Service.
            URL url = new URL("http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id=" + area_id + "&tilex=" + itilex + "&tiley=" + itiley + "&r=" + r + "&g=" + g);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        // ##############################
        // 2. Default value of beginning direction.

        // Set a string called sDirection to "right".
        // ##############################

        String sDirection = "right";



        // ##############################
        // 3. Calculate next drone move.

        // Determine next tile to move to.
        // Base this on current x and y.
        // Change sDirection if necessary.
        // Drone must serpentine from top left of grid back and forth down.
        // If rows are done, change sDirection to "stop".
        // ##############################

        //Check if on even row
        if (itiley % 2 == 0) {

            //Check if drone on last col, then increase y
            if (itilex == itotalcols - 1){
                itiley++;
                sDirection = "left";
            }

            //Drone is not on last col, so adjust x
            else {
                itilex++;
                sDirection = "right";
            }
        }
        // It's on odd row
        else {
            //Check if drone on far left col, increase y
            if (itilex == 0) {
                itiley++;
                sDirection = "right";
            }

            //Drone is not on first col, so adjust x
            else {
                itilex--;
                sDirection = "left";
            }
        }

        //Check if drone is off grid and stop
        if (itiley == itotalrows) {
            sDirection = "stop";
        }


        // ##############################
        // 4. Format & Return JSON string to caller.

        /* Return via out.println() a JSON string like this:
        {"area_id":"[area id from above]", "nextTileX":"[next tile x]", "nextTileY":"[next tile y]", "direction":"[direction string from above]"}
        */
        // ##############################

        String sReturnJson = "{\"area_id\":\"" + area_id + "\", \"nextTileX\":\"" + itilex + "\", \"nextTileY\":\"" + itiley + "\", \"direction\":\"" + sDirection + "\"}";
        out.println(sReturnJson);
    }
}

