package com.dronerecon.ws;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;

public class PortalDBService extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

		// ############
		// Get 5 parameter values from the request object (these are passed in from part 1 code).
		// "area_id" : String type
		// "tilex" : int type (Reference part 1 of Project 2 for converting string to int).
		// "tiley"
		// "r"
		// "g"
		// ############

        String r = request.getParameter("r");
        String g = request.getParameter("g");
        String area_id = request.getParameter("area_id");
        String tilex = request.getParameter("tilex");
        String tiley = request.getParameter("tiley");

        int itilex = Integer.parseInt(tilex);
        int itiley = Integer.parseInt(tiley);
        int ir = Integer.parseInt(r);
        int ig = Integer.parseInt(g);


		// ############
		// Instantiate a DBManager instance.
		// ############

        DBManager oDBManager = new DBManager();

        // Set DB location (Currently uses current DB file name and adds direct path from C drive before it).
        oDBManager.DBLocation = "C:\\Apache Software Foundation\\Tomcat 9.0\\webapps\\dronereconportal\\db\\dronedata.sqlite";
        //*** IMPORTANT: For Mac Users, comment out the above and use below line:
        //oDBManager.DBLocation = System.getProperty("catalina.base") + "/webapps/dronereconportal/db/" + oDBManager.DBLocation;


        // ############
		// Call insertAreaGridTile on db manager object and pass the 5 values from above.
        // ############

        oDBManager.insertAreaGridTile(area_id, itilex, itiley, ir, ig);


        // Response with confirmation of DB record written.
        out.println("{\"success\":true}");
    }
}

