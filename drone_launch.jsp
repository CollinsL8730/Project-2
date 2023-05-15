<html>

  <body>

      <br />
      <h2 style="text-align:center;background-color:gray;color:white">DRONE RECON</h2>

      <!-- ###################################################
      Create a form here where the action is set to "drone_sim.jsp".
      Set a text input with name as "area_id".
      Set a text input with name as "colcount".
      Set a text input with name as "rowcount".
      Create a button with text similar to this: "Create Area Grid".
      ################################################### -->

      <center>

      <form action="drone_sim.jsp">
        <table>
          <tr>
            <td colspan="100%" style="text-align:center;background-color:ffffcc">
              Area Grid
            </td>
          </tr>
          <tr>
            <td>
              Area ID
            </td>
            <td>
              <input name="area_id" type="text">
            </td>
          </tr>
          <tr>
            <td>
              Column Count
            </td>
            <td>
              <input name="totalcols" type="text">
            </td>
          </tr>
          <tr>
            <td>
              Row Count
            </td>
            <td>
              <input name="totalrows" type="text">
            </td>
          </tr>
          <tr>
            <td>
              <input type="submit" value="Create Area Grid">
            </td>
          </tr>
        </table>
      </form>

      </center>
      
  </body>
</html>