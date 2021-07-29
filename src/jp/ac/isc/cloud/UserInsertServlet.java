protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
 try {
 Connection users = null;
 try {
 request.setCharacterEncoding("utf-8");
 Class.forName("com.mysql.jdbc.Driver");
 users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUn
 icode=true&characterEncoding=utf8","root","");← ①
 String id = request.getParameter("insertId");
 String name = request.getParameter("insertName");
 String picture = request.getParameter("insertPicture");
 Statement state = users.createStatement();
 state.executeUpdate("INSERT INTO user_table VALUE('" + id + "','" + name +
 "','" + picture + "')");
 state.close();
 users.close();
 response.sendRedirect("/select"); //UserSelectServletを呼び出す
 }catch(ClassNotFoundException e) {
 e.printStackTrace();
 }
 }catch(SQLException e){
 e.printStackTrace();
 }
 }
