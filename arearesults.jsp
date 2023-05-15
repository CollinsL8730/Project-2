<html>
    <body>
<%@page import="com.dronerecon.ws.AreaGridTile" %>
<%@page import="com.dronerecon.ws.DBManager" %>
<%@page import="java.util.ArrayList" %>

<%

String area_id = request.getParameter("area_id");

DBManager oDBManager = new DBManager();
oDBManager.DBLocation = "C:\\Apache Software Foundation\\Tomcat 9.0\\webapps\\dronereconportal\\db\\dronedata.sqlite";

ArrayList<AreaGridTile> lstTiles = oDBManager.readAreaGridTiles(area_id);

AreaGridTile rMax = lstTiles.get(0);
AreaGridTile gMax = lstTiles.get(0);

for (int i = 0; i < lstTiles.size(); i++) {

    if (rMax.r < lstTiles.get(i).r) {
        rMax = lstTiles.get(i);
    }

    if (gMax.g < lstTiles.get(i).g) {
        gMax = lstTiles.get(i);
    }
}

%>

<%="The Highest R Tile is " + "R: " + rMax.r + " X: " + rMax.x + " Y: " + rMax.y%>
<%="The Highest G Tile is " + "R: " + gMax.g + " X: " + gMax.x + " Y: " + gMax.y%>


</body>
</html>