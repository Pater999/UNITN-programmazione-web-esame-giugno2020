<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Minesweeper - Partita</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">

            <h1>Hello <%= session.getAttribute("user")%>
            </h1>

            <%
                out.println("<table class=\"table table-bordered\">");
                for (int i = 0; i < 9; i++) {
                    out.println("<tr >");
                    for (int j = 0; j < 9; j++) {
                        out.println("<td style='height: 50px; text-align: center;' class='table-light' id='Cella_" + i + "_" + j + "' onClick='clickCella(" + i + "," + j + ")'>  </td>");
                    }
                    out.println("</tr>");
                }
                out.println("</table>");
            %>

            <div class="input-group mb-3">
                <button style="width:200px; margin-right:20px" type="button" class="btn btn-info" onclick="test()">Test</button>
                <select id="SelectRiga" style="margin-right: 20px" class="form-control" id="sel1">
                    <option value="0">1</option>
                    <option value="1">2</option>
                    <option value="2">3</option>
                    <option value="3">4</option>
                    <option value="4">5</option>
                    <option value="5">6</option>
                    <option value="6">7</option>
                    <option value="7">8</option>
                    <option value="8">9</option>
                </select>
                <select id="SelectColonna"  class="form-control" style="margin-right: 20px" id="sel1">
                    <option value="0">1</option>
                    <option value="1">2</option>
                    <option value="2">3</option>
                    <option value="3">4</option>
                    <option value="4">5</option>
                    <option value="5">6</option>
                    <option value="6">7</option>
                    <option value="7">8</option>
                    <option value="8">9</option>
                </select>
                <form action="restart"><button name="restart" style="width:200px" type="submit" class="btn btn-warning">Restart</button></form>

            </div>
            <div class="row" id="outputTest"></div>
        </div>
       
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="js/giocaPartita.js"></script>
        <script>username = "<%= session.getAttribute("user")%>";</script>
    </body>
</html>
