<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Dto.User" %>
<%@page import="Dao.UserDao" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="codepixer">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Book</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
        <!--
        CSS
        ============================================= -->
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/nice-select.css">					
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>

        <header id="header" id="home">
            <div class="container">
                <div class="row align-items-center justify-content-between d-flex">
                    <div id="logo">
                        <a href="index.html"><img src="img/logo.png" alt="" title="" /></a>
                    </div>
                    <nav id="nav-menu-container">
                        <ul class="nav-menu">
                            <li class="menu-active"><a href="adminHomePage.html">Home</a></li>
                            <li><a href="addBook.html">Add Book</a></li>
                            <li><a href="addUser.html">Add User</a></li>
                            <li><a href="showBook.html">Show Book</a></li>
                            <li><a href="showUser.jsp">Show User</a></li>
                            <li><a href="showIssuedBook.jsp">Show Issued Book</a></li>
                            <li><a href="adminLogout.jsp">Logout</a></li>
                        </ul>
                    </nav><!-- #nav-menu-container -->		    		
                </div>
            </div>
        </header><!-- #header -->


        <!-- start banner Area -->
        <section class="banner-area" id="home">	
            <div class="container">
                <div class="row fullscreen d-flex align-items-center justify-content-start">
                    <div class="banner-content col-lg-7">
                        <h5 class="text-white text-uppercase">Author: Travor James</h5>
                        <h1 class="text-uppercase">
                            New Adventure				
                        </h1>
                        <p class="text-white pt-20 pb-20">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod temp <br> or incididunt ut labore et dolore magna aliqua. Ut enim ad minim.
                        </p>
                        <a href="#" class="primary-btn text-uppercase">Issue Now</a>
                    </div>
                    <div class="col-lg-5 banner-right">
                        <img class="img-fluid" src="img/header-img.png" alt="">
                    </div>												
                </div>
            </div>
        </section>
        <!-- End banner Area -->	

        <%
            UserDao dao = new UserDao();
            ArrayList<User> user = dao.getUser();
        %>
    <center>
        <br><br><br>
        <div class="container justify-content-center table">
            <h2>User Information</h2><br>
            <table border="1" cellspacing="0" cellpadding="6" style="width: 85%">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Status</th>
                    <th>Delete User</th>
                </tr>
                </thead>
                <tbody>
                <% for(User u: user) {%>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getName() %></td>
                    <td><%= u.getEmail() %></td>
                    <td><%= u.getPassword() %></td>
                    <td><%= u.getStatus() %></td>
                    <td><a href="deleteUser.jsp?id=<%= u.getId()%>">Delete</a></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
        </center>
        <!-- Start testomial Area -->
        <section class="testomial-area section-gap">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="menu-content pb-60 col-lg-8">
                        <div class="title text-center">
                            <h1 class="mb-10">What our Reader’s Say about us</h1>
                            <p>Who are in extremely love with eco friendly system.</p>
                        </div>
                    </div>
                </div>						
                <div class="row">
                    <div class="active-tstimonial-carusel">
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t1.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t2.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t3.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>	
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t1.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t2.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t3.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>															
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t1.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t2.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>
                        <div class="single-testimonial item">
                            <img class="mx-auto" src="img/t3.png" alt="">
                            <p class="desc">
                                Accessories Here you can find the best computer accessory for your laptop, monitor, printer, scanner, speaker, projector, hardware and more. laptop accessory
                            </p>
                            <h4>Mark Alviro Wiens</h4>
                            <p>
                                CEO at Google
                            </p>
                        </div>														
                    </div>
                </div>
            </div>	
        </section>
        <!-- End testomial Area -->


        <!-- start footer Area -->		
        <footer class="footer-area section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>About Us</h6>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore magna aliqua.
                            </p>
                            <p class="footer-text">
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>								
                        </div>
                    </div>
                    <div class="col-lg-5  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Newsletter</h6>
                            <p>Stay update with our latest</p>
                            <div class="" id="mc_embed_signup">
                                <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="form-inline">
                                    <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '" required="" type="email">
                                    <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
                                    <div style="position: absolute; left: -5000px;">
                                        <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                    </div>

                                    <div class="info"></div>
                                </form>
                            </div>
                        </div>
                    </div>						
                    <div class="col-lg-2 col-md-6 col-sm-6 social-widget">
                        <div class="single-footer-widget">
                            <h6>Follow Us</h6>
                            <p>Let us be social</p>
                            <div class="footer-social d-flex align-items-center">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                <a href="#"><i class="fa fa-behance"></i></a>
                            </div>
                        </div>
                    </div>							
                </div>
            </div>
        </footer>	
        <!-- End footer Area -->	

        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script>			
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="js/easing.min.js"></script>			
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.min.js"></script>	
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>	
        <script src="js/owl.carousel.min.js"></script>			
        <script src="js/jquery.sticky.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>			
        <script src="js/parallax.min.js"></script>	
        <script src="js/waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>			
        <script src="js/mail-script.js"></script>	
        <script src="js/main.js"></script>	
    </body>
</html>



